package Com.S2C.BaseClass;

import java.io.IOException;



import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class TestClass {

	// TODO Auto-generated method stub

	public static final MediaType JSON = MediaType.get("application/x-www-form-urlencoded");
	OkHttpClient client = new OkHttpClient();

	String post(String url, String json) throws IOException {
		
		RequestBody body = RequestBody.create(JSON, json);
		System.out.println(body.contentType());
		Headers header = Headers.of("Content-Type", "application/x-www-form-urlencoded", "client_id", "syntel","client_secret", "syntel123$");
		System.out.println(header);
		Request request = new Request.Builder()
				.url(url)
				.headers(header)
				.post(body)
				.build();
		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}
	}

	/*String bowlingJson() {
		String password = "password";
		String email = "tedmarketplaces@gmail.com";
		String userPassword = "Smart2000";
		String json ="\"grant_type\":\"" + password.trim() + "\",\n" + "\"client_id\":\"syntel\",\n" +"\"client_secret\":\"syntel123$\",\n"
				+ "\"username\":\"" + email + "\",\n" + "\"password\":\"" + userPassword + "\"\n" ;
		return json;

	}*/
	String bowlingJson() {
		return "\n{\ngrant_type: 'password',"
				+ "\nclient_id:'syntel',"
						+ "\nclient_secret:'syntel123$',"
						+ "\nusername:'tedmarketplaces@gmail.com',"
						+ "\npassword:'Smart2000'\n}";
						
	}
	
	

          
	
	  
	public static void main(String[] args) throws IOException {
		TestClass example = new TestClass();
		String json = example.bowlingJson();
		String response = example.post("https://api.us.apiconnect.ibmcloud.com/whirlpool-developer-network-wcloud-dev/whirlpool-iot-qa/oauth/token",json);
		System.out.println(response);

	}
}


