package utils.requests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Properties;

public class BS_GetVideoSession {

  /*
   * THIS GET REQUEST USES BROWSERSTACK TO RETRIEVE THE VIDEO_URL OF THE EXECUTION
   * 
   */
  private final static String USER_AGENT = "Mozilla/5.0";

  public static String sendGet(String username, String password, String ID) throws Exception {
    try (InputStream input = new FileInputStream("src/test/java/resources/config.properties")) {

      Properties prop = new Properties();
      prop.load(input);

      String url = prop.getProperty("BS_BUILD_SESSION") + ID + "/sessions.json?limit=1";
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

      // Add authentication header
      String credentials = username + ":" + password;
      String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
      con.setRequestProperty("Authorization", "Basic " + encodedCredentials);

      // Add request header
      con.setRequestMethod("GET");
      con.setRequestProperty("User-Agent", USER_AGENT);
      con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

      int responseCode = con.getResponseCode();
      System.out.println("\nSending 'GET' request to URL : " + url);
      System.out.println("Response Code : " + responseCode);

      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      // Print result
      String executionInfo = response.toString();

      String str = executionInfo.substring(23, executionInfo.length() - 2);

      JSONObject responseObject = new JSONObject(str); // json

      String videoUrl = responseObject.getString("video_url");

      return videoUrl;

    } catch (Exception e) {
      e.printStackTrace();
      return "GET_REQUEST_ERROR: Video Url Not Found";
    }
  }
}
