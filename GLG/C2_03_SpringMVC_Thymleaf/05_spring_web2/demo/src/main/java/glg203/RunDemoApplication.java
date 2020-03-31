package glg203;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * RunDemoApplication
 */
@SpringBootApplication
public class RunDemoApplication {


    /**
     * Un bean pour montrer que ceux-ci sont accessibles depuis les contrôleurs.
     * @return
     */
    @Bean
    HelloMessageGlobal helloMessageGlobal() {
        return new HelloMessageGlobal("Ce message a été injecté");
    }

    
    public static void main(String[] args) {
        SpringApplication.run(RunDemoApplication.class, args);
    }
}