package rajnish.camp;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class main {
    private static HttpURLConnection connection;
    public static void main(String [] args){
        HttpClient client= HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder().uri(URI.create("https://api.jsonbin.io/b/61a0a59501558c731cc910b5/1")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

}
