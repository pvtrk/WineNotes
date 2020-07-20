package pl.patryk.wine.ui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.patryk.wine.model.Note;
import pl.patryk.wine.service.impl.NoteService;

import java.util.List;


@Route("")
public class MainView extends VerticalLayout {
    private NoteService noteService;
    Grid<Note> grid = new Grid<>(Note.class);


    public MainView(@Autowired NoteService noteService) {
        this.noteService = noteService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(grid);
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("note-grid");
        grid.setSizeFull();
        grid.setColumns("wine", "wineColor", "colorIntensity", "acidityLvl"
        ,"aromaIntensity", "tanninsLvl", "finishLength",
                "overallRating", "creationDate");

    }

    private void updateList() {
        List<Note> noteList = noteService.findNotesForUser(1L);
        grid.setItems(noteList);
    }

}
