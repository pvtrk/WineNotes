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
        WineInfoDAO wineInfoDAO = ctx.getBean(WineInfoDAO.class);
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

        WineInfo wineInfo = new WineInfo();
        wineInfo.setAlcohol(15.0);
        wineInfo.setWineColor(WineColor.RED);
        wineInfo.setWineCountry(country);
        wineInfo.setWineName("chateaulatour");
        wineInfo.setProducer("chateau latour");
        wineInfo.setWineRegion(region);
        wineInfo.setResidualSugar(15.0);
        wineInfo.setVintage(1998.0);
        wineInfo.setWineType(WineType.STILL);


        Note note = new Note();
        note.setUser(user);
        note.setName("Moja nowa notka");

        note.setWineColor(WineColor.RED);
        note.setColorIntensity(ColorIntensity.DEEP);
        note.setColorSpecification(WineColor.RED.getColourSpecification().get(2));

        note.setAromaIntensity(AromaIntensity.HIGH);
        note.setAromaCharasteristics("Eleganckie aromaty gruszki");

        note.setSweetness(Sweetness.DRY);
        note.setAcidityLvl(AcidityLvl.LOW);
        note.setTanninsLvl(TanninsLvl.HIGH);
        note.setTanninsNature("Smoooth");
        note.setAlcoholLvl(AlcoholLvl.MEDIUM);
        note.setBody(Body.FULL);
        note.setFlavourIntensity(FlavourIntensity.MEDIUMPLUS);
        note.setFlavourCharasteristics("Blackberries, truffles");
        note.setOtherObservations("elegant , cheap wine");
        note.setFinishLength(FinishLength.MEDIUM);
        note.setOverallRating(OverallRating.VERYGOOD);

        note.setWineInfo(wineInfo);
        note.setBlind(false);
        note.setCreationDate(LocalDateTime.now());
        //note.setNote("BARDZO PRZYJEMNE AROMATY CZERESNI");


        country2.addWine(wine2);
        country.addWine(wine);
        country.addRegion(region);
        country2.addRegion(region2);

        producer.addWine(wine);
        producer2.addWine(wine2);

        user.addNote(note);





        userDAO.save(user);

        wineDAO.save(wine);
        wineDAO.save(wine2);
        wineInfoDAO.save(note.getWineInfo());
        noteDAO.save(note);



        countryDAO.save(country);
        countryDAO.save(country2);
        producerDAO.save(producer);
        producerDAO.save(producer2);

        NoteService noteService = ctx.getBean(NoteService.class);

        System.out.println(noteService.findNotesForUser(user.getId(),"")
                .toString());
    }
}
