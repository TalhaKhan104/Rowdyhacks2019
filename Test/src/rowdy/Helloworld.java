package rowdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import org.apache.http.impl.client.HttpClients;

public class Helloworld {

	public static void main(String[] args) {
		System.out.println("HelloWorld");
		String url = "http://us-qa.api.iheart.com/api/v3/locationConfig?email=ppprinter6@gmail.com&hostname=iphone.mobile&version=6.7.0";

		HttpClient client = HttpClients.custom().build();

		HttpUriRequest request = RequestBuilder.get(url).setHeader("Accept", "application/json").build();

		try {
			HttpResponse response = client.execute(request);

			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result);
			
		} catch (IOException e) {
			System.out.println("Oops!" + e.getMessage());
			e.printStackTrace();
		}

	}

}

