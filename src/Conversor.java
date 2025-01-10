import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public Divisas conversor(String original, String convertir, double cantidad){
        var key= "aa47ceecea6eb2589a0f2391";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+key+"/pair/"+original+"/"+convertir+"/"+cantidad);
        HttpClient client = HttpClient.newHttpClient();

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisas.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa divisa, por favor asegurate de estar usando el código correcto");
        }
    }

}
