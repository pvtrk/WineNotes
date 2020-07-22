package pl.patryk.wine.ui;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import pl.patryk.wine.model.Note;
import pl.patryk.wine.model.Producer;
import pl.patryk.wine.model.Wine;
import pl.patryk.wine.model.enums.OverallRating;
import pl.patryk.wine.model.enums.WineColor;
import pl.patryk.wine.service.INoteService;
import pl.patryk.wine.service.impl.BeansSupplier;

import java.time.LocalDateTime;
import java.util.List;


@Route("")
@CssImport("./styles/shared-styles.css")
public class MyNotesView extends VerticalLayout {
    private final EditNoteForm form;
    Grid<Note> grid = new Grid<>(Note.class);
    TextField filterText = new TextField();
    private INoteService noteService;


    public MyNotesView() {
        this.noteService = BeansSupplier.get(INoteService.class);
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        congitureFilter();

        form = new EditNoteForm();

        Div content = new Div(grid, form);
        content.addClassName("content");
        content.setSizeFull();

        add(filterText, content);
        updateList();
    }


    private void congitureFilter() {
        filterText.setPlaceholder("Search...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());
    }

    private void configureGrid() {
        grid.addClassName("note-grid");
        grid.setSizeFull();
        grid.removeAllColumns();


        grid.addColumn(note -> {
            String name = note.getName();
            return name == null ? "-" : name;
        }).setHeader("Note name").setSortable(true);

        grid.addColumn(note -> {
            Wine wine = note.getWine();
            return wine == null ? "-" : wine.getName();
        }).setHeader("Wine").setSortable(true);

        grid.addColumn(note -> {
            WineColor wineColor = note.getWineColor();
            return wineColor == null ? "-" : wineColor.getDisplayValue();
        }).setHeader("Colour").setSortable(true);

        grid.addColumn(note -> {
            Producer producer = note.getWine().getProducer();
            return producer == null ? "-" : producer.getName();
        }).setHeader("Producer").setSortable(true);

        grid.addColumn(note -> {
            LocalDateTime creationTime = note.getCreationDate();
            return creationTime == null ? "-" : creationTime;
        }).setHeader("Created").setSortable(true);

        grid.addColumn(note -> {
            OverallRating overallRating = note.getOverallRating();
            return overallRating == null ? "-" : overallRating.getDisplayValue();
        }).setHeader("Rating").setSortable(true);

        grid.getColumns().forEach(col -> col.setAutoWidth(true));


    }

    private void updateList() {
        List<Note> noteList = noteService.findNotesForUser(1L, filterText.getValue());
        grid.setItems(noteList);
    }

}
