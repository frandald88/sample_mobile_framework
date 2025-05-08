package utils.requests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class PostMobileExecution {

	private static final String USER_AGENT = "Mozilla/5.0";

	public static void sendPOST(String requestBody, String authToken) throws IOException {

		try (InputStream input = new FileInputStream("src/test/java/resources/config.properties")) {

			Properties prop = new Properties();
			prop.load(input);

			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(prop.getProperty("PORTAL_SAVE_EXECUTION"));
			httpPost.addHeader("User-Agent", USER_AGENT);

			// Set the Authorization header with the provided token
			httpPost.addHeader("Authorization", "Bearer " + authToken);

			StringEntity requestEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
			httpPost.setEntity(requestEntity);

			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

			System.out.println("POST Response Status:: " + httpResponse.getStatusLine().getStatusCode());

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					httpResponse.getEntity().getContent()));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();

			// print result
			System.out.println(response.toString());
			httpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
