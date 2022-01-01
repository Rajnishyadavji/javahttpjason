package rajnish.camp;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class main {
   // private static HttpURLConnection connection;
    public static void main(String [] args){
        HttpClient client= HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder().uri(URI.create("https://api.jsonbin.io/b/61a0a59501558c731cc910b5/1")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(main::parse)
                .join();
    }
    public static String parse(String responseBody){
        JSONObject  albums=new JSONObject(responseBody);
        JSONObject  album=albums.getJSONObject("menu");
           String id =album.getString("id");
           String value=album.getString("value");
           int h=album.getInt("height");
            System.out.println("id :"+id);
            System.out.println("value :"+value);
            System.out.println("height :"+h);
        JSONObject  album1=album.getJSONObject("popup");
        JSONArray album2=album1.getJSONArray("menuitem");
        for(int i=0;i<album2.length();i++){
            JSONObject album3=album2.getJSONObject(i);
            value=album3.getString("value");
            String onclick= album3.getString("onclick");
            System.out.println("value :"+value);
            System.out.println("onclick :"+onclick);

        }


        return null;

    }

}
