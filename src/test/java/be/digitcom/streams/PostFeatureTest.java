package be.digitcom.streams;

import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
        // classes = {SpringBootKarateApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class PostFeatureTest {
/*
    @LocalServerPort
    private String localServerPort;


    @Karate.Test
    public Karate someTest() {
        return karateSzenario("Some test here");
    }



    private Karate karateSzenario(String s){
        return Karate.run()
                .scenarioName(s)
                .relativeTo(getClass())
                .systemProperty("Karate.port", localServerPort)
                .karateEnv("dev");
    }

 */
}
