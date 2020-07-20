package pl.patryk.wine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.patryk.wine.dao.*;
import pl.patryk.wine.model.*;
import pl.patryk.wine.model.enums.*;

import java.time.LocalDateTime;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class,args);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User user = new User();
        user.setEmail("placki@o2.pl");
        user.setLogin("placki@o2.pl");
        user.setPass("placki@o2.pl");
        user.setUserRole(UserRole.USER);


        Country country = new Country();
        country.setCountryName("France");

        Region region = new Region();
        region.setCountry(country);
        region.setRegionName("Bordeaux");




        CountryDAO countryDAO = ctx.getBean(CountryDAO.class);


        Producer producer = new Producer();
        producer.setCountry(country);
        producer.setName("Chateau Latour");

        ProducerDAO producerDAO = ctx.getBean(ProducerDAO.class);


        Wine wine = new Wine();
        wine.setColor(WineColor.RED);
        wine.setCountry(country);
        wine.setName("Chateau Latour 1er Grand Cru Classe");
        wine.setProducer(producer);
        wine.setType(WineType.STILL);
        wine.setRegion(region);
        wine.setVintage(1998);





        Note note = new Note();
        note.setUser(user);
        note.setAcidityLvl(AcidityLvl.LOW);
        note.setAromaIntensity(AromaIntensity.HIGH);
        note.setColorIntensity(ColorIntensity.DEEP);
        note.setCreationDate(LocalDateTime.now());
        note.setFinishLength(FinishLength.MEDIUM);
        note.setOverallRating(OverallRating.ACCEPTABLE);
        note.setTanninsLvl(TanninsLvl.HIGH);
        note.setWineColor(WineColor.RED);
        note.setWine(wine);
        note.setNote("BARDZO PRZYJEMNE AROMATY CZERESNI");



        country.addWine(wine);

        producer.addWine(wine);

        user.addNote(note);

        country.addRegion(region);


        userDAO.save(user);
        NoteDAO noteDAO = ctx.getBean(NoteDAO.class);
        WineDAO wineDAO = ctx.getBean(WineDAO.class);
        wineDAO.save(wine);
        noteDAO.save(note);


        countryDAO.save(country);
        producerDAO.save(producer);


        System.out.println(noteDAO.findNotesForUser(user.getId())
                .toString());
    }
}
