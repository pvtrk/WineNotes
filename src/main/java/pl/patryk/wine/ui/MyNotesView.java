package pl.patryk.wine.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import pl.patryk.wine.model.Note;
import pl.patryk.wine.model.WineInfo;
import pl.patryk.wine.model.enums.OverallRating;
import pl.patryk.wine.model.enums.WineColor;
import pl.patryk.wine.service.INoteService;
import pl.patryk.wine.service.IWineInfoService;
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
    private IWineInfoService wineInfoService;

    public MyNotesView() {
        this.noteService = BeansSupplier.get(INoteService.class);
        this.wineInfoService = BeansSupplier.get(IWineInfoService.class);
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        getToolBar();

        form = new EditNoteForm();
        form.addListener(EditNoteForm.SaveEvent.class, this::saveNote);
        form.addListener(EditNoteForm.DeleteEvent.class, this::deleteNote);
        form.addListener(EditNoteForm.CloseEvent.class, this::closeEditorEvt);


        Div content = new Div(grid, form);
        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
        updateList();
        closeEditor();

    }

    private void closeEditorEvt(EditNoteForm.CloseEvent event) {
        closeEditor();
    }

    private void deleteNote(EditNoteForm.DeleteEvent event) {
        this.noteService.delete(event.getNote());
        this.wineInfoService.delete(event.getWineInfo());
        updateList();
    }

    private void saveNote(EditNoteForm.SaveEvent event) {
        this.wineInfoService.save(event.getWineInfo());
        this.noteService.save(event.getNote());
        updateList();
    }

    private void closeEditor() {
        form.setNote(new Note());
        form.setVisible(false);
        form.removeClassName("editing");
    }


    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Search...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addNoteButton = new Button("Add note", click -> addNote());
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addNoteButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addNote() {
        grid.asSingleSelect().clear();
        editNote(new Note());
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
            WineInfo wineInfo = note.getWineInfo();
            return wineInfo == null ? "-" : wineInfo.getWineName();
        }).setHeader("Wine").setSortable(true);

        grid.addColumn(note -> {
            WineColor wineColor = note.getWineColor();
            return wineColor == null ? "-" : wineColor.getDisplayValue();
        }).setHeader("Colour").setSortable(true);

        grid.addColumn(note -> {
            String producer = note.getWineInfo().getProducer();
            return producer == null ? "-" : producer.toString();
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

        grid.asSingleSelect().addValueChangeListener(event -> {
            editNote(event.getValue());
        });

    }

    private void editNote(Note note) {
        if(note == null) {
            closeEditor();
        } else {
            form.setNote(note);
            form.setVisible(true);
            form.addClassName("editing");
        }


    }

    private void updateList() {
        List<Note> noteList = noteService.findNotesForUser(1L, filterText.getValue());
        grid.setItems(noteList);
    }

}
