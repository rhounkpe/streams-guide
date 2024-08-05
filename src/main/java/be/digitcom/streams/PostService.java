package be.digitcom.streams;
import be.digitcom.streams.models.Post;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.InputStream;

import static org.springframework.http.MediaType.*;


@Service
public class PostService {
    private final RestClient restClient;

    public PostService(RestClient restClient) {
        this.restClient = restClient;
    }

    public InputStream findById(int id) {
        return restClient.get()
                .uri("/posts/{id}", id)
                .accept(APPLICATION_JSON)
                .exchange((request, response) -> {
                    if (response.getStatusCode().is4xxClientError()) {
                        //TODO: Handle it properly
                        // throw new MyCustomRuntimeException(response.getStatusCode(), response.getHeaders());
                    }
                    else {
                        //Post post = convertResponse(response);
                        //return post;
                        System.out.println(response);
                        return response.getBody();
                    }
                    return null;
                });
    }

    public ResponseEntity<String> findAll() {
        return restClient.get()
                .uri("/posts")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, ((request, response) -> {
                    System.out.println("request: " + request);
                    System.out.println("response: " +response);
                }))
                .onStatus(statusCode -> {
                    // System.out.println("statusCode: " + statusCode);
                    return statusCode.is2xxSuccessful();
                }, (request, response) -> {
                })
                .toEntity(String.class);
    }

    public ResponseEntity<Void> createPost(Post post) {
        return restClient.post()
                .uri("/posts")
                .accept(APPLICATION_JSON)
                .body(post)
                .retrieve()
                .toBodilessEntity();
    }
}
