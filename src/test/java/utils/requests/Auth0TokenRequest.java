package utils.requests;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.json.JSONObject;

public class Auth0TokenRequest {
  public static String sendRequest() throws Exception {
    try (InputStream input = new FileInputStream("src/test/java/resources/config.properties")) {

      Properties prop = new Properties();
      prop.load(input);

      // Auth0 credentials
      String clientId = prop.getProperty("AUTH0_CLIENTID");
      String clientSecret = prop.getProperty("AUTH0_CLIENTSECRET");
      String grantType = "client_credentials";
      String audience = prop.getProperty("AUTH0_AUDIENCE");

      // Auth0 domain
      String auth0Domain = prop.getProperty("AUTH0_DOMAIN");

      // Request URL
      String tokenUrl = "https://" + auth0Domain + "/oauth/token";

      // Create the POST request body
      String requestBody = "grant_type=" + grantType +
          "&client_id=" + clientId +
          "&client_secret=" + clientSecret +
          "&audience=" + audience;

      // Create URL object
      URL url = new URL(tokenUrl);

      // Open a connection to the URL
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set request method to POST
      connection.setRequestMethod("POST");

      // Set request headers
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.setRequestProperty("Content-Length", String.valueOf(requestBody.length()));

      // Enable input/output streams
      connection.setDoOutput(true);

      // Write request body
      try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
        outputStream.writeBytes(requestBody);
        outputStream.flush();
      }

      // Get response code
      int responseCode = connection.getResponseCode();
      System.out.println("Response Code: " + responseCode);

      // Read response content
      try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = in.readLine()) != null) {
          response.append(line);
        }
        // Parse JSON response to get the "access_token" value
        String jsonResponse = response.toString();
        String accessToken = parseAccessToken(jsonResponse);

        connection.disconnect();
        System.out.println("Auth0 Token Generated Succesfully");

        return accessToken;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return "There was an error generating the Auth0 token";
    }

  }

  // Helper method to parse "access_token" value from JSON response
  private static String parseAccessToken(String jsonResponse) {
    JSONObject jsonObject = new JSONObject(jsonResponse);
    return jsonObject.getString("access_token");
  }
}
