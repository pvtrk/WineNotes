package pl.patryk.wine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.patryk.wine.dao.*;
import pl.patryk.wine.model.*;
import pl.patryk.wine.model.enums.*;
import pl.patryk.wine.service.impl.NoteService;

import java.time.LocalDateTime;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class,args);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        NoteDAO noteDAO = ctx.getBean(NoteDAO.class);
        WineDAO wineDAO = ctx.getBean(WineDAO.class);
        CountryDAO countryDAO = ctx.getBean(CountryDAO.class);
        ProducerDAO producerDAO = ctx.getBean(ProducerDAO.class);


        User user = new User();
        user.setEmail("placki@o2.pl");
        user.setLogin("placki@o2.pl");
        user.setPass("placki@o2.pl");
        user.setUserRole(UserRole.USER);


        Country country = new Country();
        country.setCountryName("France");

        Country country2 = new Country();
        country2.setCountryName("New Zealand");

        Region region = new Region();
        region.setCountry(country);
        region.setRegionName("Bordeaux");

        Region region2 = new Region();
        region2.setCountry(country2);
        region2.setRegionName("Marlborough");




        Producer producer = new Producer();
        producer.setCountry(country);
        producer.setName("Chateau Latour");

        Producer producer2 = new Producer();
        producer2.setCountry(country2);
        producer2.setName("Kim Crawford");





        Wine wine = new Wine();
        wine.setColor(WineColor.RED);
        wine.setCountry(country);
        wine.setName("Chateau Latour 1er Grand Cru Classe");
        wine.setProducer(producer);
        wine.setType(WineType.STILL);
        wine.setRegion(region);
        wine.setVintage(1998);

        Wine wine2 = new Wine("Sauvignon Blanc", producer2, country2,
                region2, 2018, WineType.STILL, WineColor.WHITE);




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

        Note note2 = new Note("Aromaty brzoskwiń", user, wine2, WineColor.WHITE, ColorIntensity.MEDIUM,
                AcidityLvl.MEDIUMPLUS, AromaIntensity.MEDIUMPLUS, TanninsLvl.NONE,
                FinishLength.MEDIUMPLUS, OverallRating.VERYGOOD, LocalDateTime.now(), false);


        country2.addWine(wine2);
        country.addWine(wine);
        country.addRegion(region);
        country2.addRegion(region2);

        producer.addWine(wine);
        producer2.addWine(wine2);

        user.addNote(note);
        user.addNote(note2);




        userDAO.save(user);

        wineDAO.save(wine);
        wineDAO.save(wine2);
        noteDAO.save(note);
        noteDAO.save(note2);



        countryDAO.save(country);
        countryDAO.save(country2);
        producerDAO.save(producer);
        producerDAO.save(producer2);

        NoteService noteService = ctx.getBean(NoteService.class);

        System.out.println(noteService.findNotesForUser(user.getId(),"")
                .toString());
    }
}
