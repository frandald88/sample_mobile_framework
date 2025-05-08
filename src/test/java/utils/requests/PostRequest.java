package utils.requests;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class PostRequest {

  private final static String USER_AGENT = "Mozilla/5.0";

  /*
   * POST REQUEST WITH BODY IGNORING THE SSL CERT
   * 
   */
  // HTTP POST request
  public static void sendPostWithBody(String body) throws Exception {
    String url = "https://localhost:8081/save_execution";
    // String url = "https://testing.consulting.com:8081/save_mobile_execution";
    URL obj = new URL(url);
    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

    // Ignore SSL certificate
    SSLContext sslContext = SSLContext.getInstance("TLS");
    TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
      public void checkClientTrusted(X509Certificate[] chain, String authType) {
      }

      public void checkServerTrusted(X509Certificate[] chain, String authType) {
      }

      public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
      }
    } };
    sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
    con.setSSLSocketFactory(sslContext.getSocketFactory());

    // Add request header
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    con.setRequestProperty("Content-Type", "application/json");

    // Add request body
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(body);
    wr.flush();
    wr.close();

    int responseCode = con.getResponseCode();
    System.out.println("\nSending 'POST' request to URL : " + url);
    System.out.println("Post parameters : " + body);
    System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();

    // Print result
    System.out.println(response.toString());
  }

  /*
   * POST REQUEST WITHOUT BODY IGNORING THE SSL CERT
   * 
   */
  // HTTP POST request
  public static void sendPost() throws Exception {

    String url = "https://localhost:8081/get_mobile_executions";
    URL obj = new URL(url);
    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

    // Ignore SSL certificate
    SSLContext sslContext = SSLContext.getInstance("TLS");
    TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
      public void checkClientTrusted(X509Certificate[] chain, String authType) {
      }

      public void checkServerTrusted(X509Certificate[] chain, String authType) {
      }

      public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
      }
    } };
    sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
    con.setSSLSocketFactory(sslContext.getSocketFactory());

    // Add request header
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

    String urlParameters = "param1=value1&param2=value2";

    // Send post request
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(urlParameters);
    wr.flush();
    wr.close();

    int responseCode = con.getResponseCode();
    System.out.println("\nSending 'POST' request to URL : " + url);
    System.out.println("Post parameters : " + urlParameters);
    System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();

    // Print result
    System.out.println(response.toString());
  }

}
