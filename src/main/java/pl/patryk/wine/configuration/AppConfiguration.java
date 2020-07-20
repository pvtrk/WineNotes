package pl.patryk.wine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pl.patryk.wine.session.SessionObject;
import pl.patryk.wine.session.TastingRoom;

@Configuration
public class AppConfiguration {

    @Bean
    @SessionScope
    public SessionObject sessionObject() {
        return new SessionObject();
    }

    @Bean
    @SessionScope
    public TastingRoom tastingRoom() {
        return new TastingRoom();
    }
}
