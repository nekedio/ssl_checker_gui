/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tatmedia.code.checker;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.net.URL;

/**
 *
 * @author nekedio
 */
public class SslChecker {

    final public String checkCertExpires(String host) throws Exception {
        final TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {

                public X509Certificate[] getAcceptedIssuers() {
                    // TODO Auto-generated method stub
                    return null;
                }

                public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                        throws CertificateException {
                    // TODO Auto-generated method stub
                }

                public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                        throws CertificateException {
                    // TODO Auto-generated method stub
                }
            }
        };

        try {
            final SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }

        final URL url = new URL("https://" + host);
        final HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.connect();
        final Certificate[] certs = conn.getServerCertificates();
        for (Certificate c : certs) {
            final X509Certificate xc = (X509Certificate) c;
            final String dn = xc.getSubjectDN().getName();
            final Date expiresOn = xc.getNotAfter();
            final Date now = new Date();
            final long countDays = (expiresOn.getTime() - now.getTime()) / (1000 * 60 * 60 * 24);
            if (countDays <= 1) {
                return "Внимание! Остался ОДИН день";
            } else if (countDays >= 2 && countDays <= 4) {
                return "Внимание! Осталось " + countDays + " дня";
            } else {
                return "Осталось " + countDays + " дней";
            }
        }

        return "Не удалось получить данные из сертика";
    }
}
