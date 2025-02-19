import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.IntStream;

public class TestMain {
    public static void main(String[] args) {
        String url = "http://localhost/hello";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        IntStream
                .range(1, 100000)
                .parallel()
                .forEach(i -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                            .thenApply(HttpResponse::body)
                            .thenAccept(System.out::println)
                            .join();
                });
    }
}
