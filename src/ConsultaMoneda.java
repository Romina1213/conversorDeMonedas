import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public TipoMoneda consultarMoneda(String base_code, String target_code, double cantidad){
        String direccion = "https://v6.exchangerate-api.com/v6/7893a03f29124bd8f20afcf8/pair/" + base_code + "/" + target_code +"/"+cantidad;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        Gson gson = new Gson();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            TipoMoneda moneda = gson.fromJson(json,TipoMoneda.class);
            return moneda;
        }catch (Exception e){
            throw new RuntimeException("No encontre ese tipo de moneda");
        }

    }
}