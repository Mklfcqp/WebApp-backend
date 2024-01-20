import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        //https://api.polygon.io/v2/aggs/ticker/AAPL1/range/1/day/2024-01-06/2024-01-06?apiKey=q1WmASAd6Xeha70QSMOcKh0UpHo7G6g0
        // data hodit do
//        ObjectMapper objectMapper = new ObjectMapper();
//        Root s = objectMapper.readValue("https://api.polygon.io/v2/aggs/ticker/AAPL1/range/1/day/2024-01-06/2024-01-06?apiKey=q1WmASAd6Xeha70QSMOcKh0UpHo7G6g0", Root.class);
//        System.out.println(s);

    }
}
