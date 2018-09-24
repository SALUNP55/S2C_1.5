package Com.S2C.BaseClass;

	import java.io.IOException;
	import okhttp3.MediaType;
	import okhttp3.OkHttpClient;
	import okhttp3.Request;
	import okhttp3.RequestBody;
	import okhttp3.Response;
	public class example {
	  public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

	  OkHttpClient client = new OkHttpClient();

	  String post(String url, String json) throws IOException {
	    RequestBody body = RequestBody.create(JSON, json);
	    Request request = new Request.Builder()
	        .url(url)
	        .post(body)
	        .build();
	    try (Response response = client.newCall(request).execute()) {
	      return response.body().string();
	    }
	  }

	  String bowlingJson() {
	    return "{'grant_type': 'password',"
	            +"'client_id': 'syntel',"		    	
	    		+"'client_secret': 'syntel123$',"
		    	+"'username': 'tedmarketplaces@gmail.com',"
		    	+"'password': 'Smart2000'"
		    	+"}";
	    		
	  }

	  public static void main(String[] args) throws IOException {
		  example example = new example();
	
		    String json = example.bowlingJson();		 
	        String response = example.post("https://api.us.apiconnect.ibmcloud.com/whirlpool-developer-network-wcloud-dev/whirlpool-iot-qa/oauth/token", json);
		    System.out.println(response);
	  }
	}


