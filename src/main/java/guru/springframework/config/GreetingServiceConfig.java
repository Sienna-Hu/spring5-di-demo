package guru.springframework.config;

import guru.springframework.services.GreetingRepository;
import guru.springframework.services.GreetingService;
import guru.springframework.services.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

     @Bean
     GreetingServiceFactory greetingServiceFactory(GreetingRepository greetingRepository) {
          return new GreetingServiceFactory(greetingRepository);
     }

     @Bean
     @Primary
     @Profile({"default", "en"})
     GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory) {
          return greetingServiceFactory.createGreatingService("en");
     }

     @Bean
     @Profile({"es"})
     GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory) {
          return greetingServiceFactory.createGreatingService("es");
     }

     @Bean
     @Profile({"de"})
     GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory) {
          return greetingServiceFactory.createGreatingService("de");
     }

}
