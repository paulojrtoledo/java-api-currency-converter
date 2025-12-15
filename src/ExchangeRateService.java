import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateService {
    private String getApiKey() throws IOException {
        // Tenta ler do arquivo .env primeiro
        java.nio.file.Path envPath = java.nio.file.Paths.get(".env");
        if (java.nio.file.Files.exists(envPath)) {
            String content = new String(java.nio.file.Files.readAllBytes(envPath));
            for (String line : content.split("\n")) {
                if (line.startsWith("EXCHANGE_RATE_API_KEY=")) {
                    return line.substring("EXCHANGE_RATE_API_KEY=".length()).trim();
                }
            }
        }
        throw new RuntimeException("Crie um arquivo .env com: EXCHANGE_RATE_API_KEY=sua_chave");
    }

    public double getExchangeRate(String fromCurrency, String toCurrency) throws IOException {
        String apiKey = getApiKey(); // Agora lê do arquivo
        String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + fromCurrency;

        // making request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // convert to Json
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        double result = jsonobj.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();

        System.out.println("\nExchange Rate: " + result);
        return result;
    }

}
