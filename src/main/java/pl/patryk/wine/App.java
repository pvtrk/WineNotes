package pl.patryk.wine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.patryk.wine.dao.NoteDAO;
import pl.patryk.wine.dao.UserDAO;
import pl.patryk.wine.model.Note;
import pl.patryk.wine.model.User;
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
        userDAO.save(user);

        Note note = new Note();
        note.setUser(user);
        note.setAcidityLvl(AcidityLvl.LOW);
        note.setAromaIntesity(AromaIntensity.HIGH);
        note.setColorIntensity(ColorIntensity.DEEP);
        note.setCreationDate(LocalDateTime.now());
        note.setFinishLength(FinishLength.MEDIUM);
        note.setOverallRating(OverallRating.ACCEPTABLE);
        note.setTanninsLvl(TanninsLvl.HIGH);
        note.setWineColor(WineColor.RED);
        note.setNote("BARDZO PRZYJEMNE AROMATY CZERESNI");

        NoteDAO noteDAO = ctx.getBean(NoteDAO.class);
        noteDAO.save(note);

        System.out.println(noteDAO.findNotesForUser(user.getId()).toString());
    }
}
