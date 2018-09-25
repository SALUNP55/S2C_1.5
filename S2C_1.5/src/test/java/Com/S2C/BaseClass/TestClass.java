package Com.S2C.BaseClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import org.json.JSONObject;

import com.google.gson.JsonObject;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;



public class TestClass {
	String json;
	// TODO Auto-generated method stub

	public static final MediaType JSON = MediaType.get("application/x-www-form-urlencoded");
	OkHttpClient client = new OkHttpClient();

	String post() throws IOException {
		
		//RequestBody body = RequestBody.create(JSON, json);
		//System.out.println(body.contentType());
		//Headers header = Headers.of("Content-Type", "application/x-www-form-urlencoded", "client_id", "syntel","client_secret", "syntel123$");
		//System.out.println(header);
		RequestBody body = new FormBody.Builder()
				.add("grant_type", "password")
				.add("client_id","syntel")
				.add("client_secret", "syntel123$")
				.add("username", "minerva5@mailforspam.com")
				.add("password", "Smart2000")
				.build();
		Request request = new Request.Builder()
				.url("https://api-stg.whrcloud.com/oauth/token")
				.post(body)
				.build();
		try (Response response = client.newCall(request).execute()) {
		
			//ResponseBody Response =response.body().create(JSON, response.toString())
	
			JSONObject jobject = new JSONObject(response.body().string());
			return jobject.get("access_token").toString();
		
		}
	}
	
String post2() throws IOException {
		
		//RequestBody body = RequestBody.create(JSON, json);
		//System.out.println(body.contentType());
		//Headers header = Headers.of("Content-Type", "application/x-www-form-urlencoded", "client_id", "syntel","client_secret", "syntel123$");
		//System.out.println(header);
		
		Request request = new Request.Builder()
				.url("https://api-stg.whrcloud.com/api/v1/masterApplianceCategories")
				.header("Authorization", ("Bearer"+post()))
				.addHeader("wp-client-region", "NAR")
				.addHeader("wp-client-country", "US")
				.addHeader("wp-client-brand", "WHIRLPOOL")
				.addHeader("wp-client-language", "ENG")
		        .build();
		try (Response response = client.newCall(request).execute()) {
		
			//ResponseBody Response =response.body().create(JSON, response.toString())
	
			//JSONObject jobject = new JSONObject(response.body().string());
			//return jobject.get("access_token").toString();
			return response.body().string();
		
		}
	}
	
	
				
	  
	public static void main(String[] args) throws IOException {
		TestClass example = new TestClass();
	    String access_token = example.post();
	    System.out.println(access_token);
	   System.out.println(example.post2()); 
        

	}
}


