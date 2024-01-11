package in.raj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class VotingAppApplication {

    
    public static void main(String[] args) {
        SpringApplication.run(VotingAppApplication.class, args);
    }
}
