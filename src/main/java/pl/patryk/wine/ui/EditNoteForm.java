package pl.patryk.wine.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.hibernate.sql.Delete;
import pl.patryk.wine.model.*;
import pl.patryk.wine.model.enums.*;
import pl.patryk.wine.service.ICountryService;
import pl.patryk.wine.service.IRegionService;
import pl.patryk.wine.service.impl.BeansSupplier;

import java.util.ArrayList;
import java.util.List;

@Route(value="addnotes", layout = MainLayout.class)
@PageTitle("Wine Notes")
public class EditNoteForm extends FormLayout {
    FormLayout wineSpecificFields = new FormLayout();
    FormLayout tastingNoteFields = new FormLayout();

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button cancel = new Button("Cancel");


    TextField name = new TextField("Note name");
    RadioButtonGroup<Boolean> blind = new RadioButtonGroup();
    
    TextField wineName = new TextField("Wine name");
    NumberField vintage = new NumberField("Vintage");
    ComboBox<WineType> wineType = new ComboBox<>("Wine type");
    ComboBox<WineColor> wineColor = new ComboBox<>("Wine color");
    NumberField alcohol = new NumberField("Alcohol");
    NumberField residualSugar = new NumberField("Residual sugar (g/L)");
    TextField producer = new TextField("Producer");
    ComboBox<Country> wineCountry = new ComboBox<>("Country");
    ComboBox<Region> wineRegion = new ComboBox<>("Region");

    H2 appearance = new H2("Appearance");
    ComboBox<WineColor> color = new ComboBox<>("Color");
    ComboBox<String> colorSpecification = new ComboBox<>();
    ComboBox<ColorIntensity> colorIntensity = new ComboBox<>("Color intensity");

    H2 nose = new H2("Nose");
    ComboBox<AromaIntensity> aromaIntensity = new ComboBox<>("Aroma intensity");
    TextArea aromaCharasteristics = new TextArea("Aroma characteristics");

    H2 palate = new H2("Palate");
    ComboBox<Sweetness> sweetness = new ComboBox<>("Sweetness");
    ComboBox<AcidityLvl> acidityLvl = new ComboBox<>("Acidity");
    ComboBox<TanninsLvl> tanninsLvl = new ComboBox<>("Tannins");
    TextArea tanninsNature = new TextArea("Tannins nature");
    ComboBox<AlcoholLvl> alcoholLvl = new ComboBox<>("Alcohol ");
    ComboBox<Body> body = new ComboBox<>("Body ");
    ComboBox<FlavourIntensity> flavourIntensity = new ComboBox<>("Flavour intensity ");
    TextArea flavourCharasteristics = new TextArea("Flavours charasteristics");
    TextArea otherObservations = new TextArea("Other observations");
    ComboBox<FinishLength> finishLength = new ComboBox<>("Finish length");
    ComboBox<OverallRating> overallRating = new ComboBox<>("Overall rating");

    Binder<WineInfo> wineInfoBinder = new Binder<>(WineInfo.class);
    Binder<Note> noteBinder = new Binder<>(Note.class);

    public EditNoteForm() {
        addClassName("edit-note-form");
        wineInfoBinder.bindInstanceFields(this);
        noteBinder.bindInstanceFields(this);

        configureRadioButtons();
        createButtonLayout();

        createWineSpecificFields();
        configureWineSpecificFields();

        createTastingNoteFields();
        configureTastingNoteFields();

        add(name,
                blind,
                wineSpecificFields,
                tastingNoteFields
        );
    }

//    private VerticalLayout getLayout() {
//        VerticalLayout layout = new VerticalLayout(name,
//                blind, wineSpecificFields, tastingNoteFields, createButtonLayout());
//        layout.setSpacing(true);
//        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
//        layout.addClassName("add-note-form");
//        layout.setWidth("100%");
//        return layout;
//    }

    public void setNote(Note note) {
        noteBinder.setBean(note);
        if(note.getOverallRating() == null) {
            wineInfoBinder.setBean(new WineInfo());
        } else {
            wineInfoBinder.setBean(note.getWineInfo());
        }

    }

    private void configureTastingNoteFields() {
        configureAppearanceFields();
        configureNoseFields();
        configurePalateFields();
    }

    private void configureAppearanceFields() {
        configureColorButt();
        colorIntensity.setItems(ColorIntensity.values());
        colorIntensity.setItemLabelGenerator(ColorIntensity::getDisplayValue);
    }

    private void configureNoseFields() {
        aromaIntensity.setItems(AromaIntensity.values());
        aromaIntensity.setItemLabelGenerator(AromaIntensity::getDisplayValue);
    }

    private void configurePalateFields() {
        sweetness.setItems(Sweetness.values());
        sweetness.setItemLabelGenerator(Sweetness::getDisplayValue);

        acidityLvl.setItems(AcidityLvl.values());
        acidityLvl.setItemLabelGenerator(AcidityLvl::getDisplayValue);

        tanninsLvl.setItems(TanninsLvl.values());
        tanninsLvl.setItemLabelGenerator(TanninsLvl::getDisplayValue);

        alcoholLvl.setItems(AlcoholLvl.values());
        alcoholLvl.setItemLabelGenerator(AlcoholLvl::getDisplayValue);

        body.setItems(Body.values());
        body.setItemLabelGenerator(Body::getDisplayValue);

        flavourIntensity.setItems(FlavourIntensity.values());
        flavourIntensity.setItemLabelGenerator(FlavourIntensity::getDisplayValue);

        finishLength.setItems(FinishLength.values());
        finishLength.setItemLabelGenerator(FinishLength::getDisplayValue);

        overallRating.setItems(OverallRating.values());
        overallRating.setItemLabelGenerator(OverallRating::getDisplayValue);
    }


    private void configureWineSpecificFields() {
        configureColorButt();

        wineCountry.setItems(BeansSupplier.get(ICountryService.class).findAll());
        wineCountry.setItemLabelGenerator(Country::getCountryName);

        wineType.setItems(WineType.values());
        wineType.setItemLabelGenerator(WineType::getDisplayValue);

        wineRegion.setItems(BeansSupplier.get(IRegionService.class).findAll());
        wineRegion.setItemLabelGenerator(Region::getRegionName);
    }

    private void createWineSpecificFields() {
        wineSpecificFields.add(wineName);
        wineSpecificFields.add(producer);
        wineSpecificFields.add(vintage);
        wineSpecificFields.add(color);
        wineSpecificFields.add(wineType);
        wineSpecificFields.add(alcohol);
        wineSpecificFields.add(residualSugar);
        wineSpecificFields.add(wineCountry);
        wineSpecificFields.add(wineRegion);
    }

    private void createTastingNoteFields() {

        tastingNoteFields.add(appearance);
        tastingNoteFields.add(wineColor);
        tastingNoteFields.add(wineType);
        tastingNoteFields.add(colorIntensity);
        tastingNoteFields.add(colorSpecification);

        tastingNoteFields.add(nose);
        tastingNoteFields.add(aromaIntensity);
        tastingNoteFields.add(aromaCharasteristics);

        tastingNoteFields.add(palate);
        tastingNoteFields.add(sweetness);
        tastingNoteFields.add(acidityLvl);
        tastingNoteFields.add(tanninsLvl);
        tastingNoteFields.add(tanninsNature);
        tastingNoteFields.add(alcoholLvl);
        tastingNoteFields.add(body);
        tastingNoteFields.add(flavourIntensity);
        tastingNoteFields.add(flavourCharasteristics);
        tastingNoteFields.add(otherObservations);
        tastingNoteFields.add(finishLength);
        tastingNoteFields.add(overallRating);
        tastingNoteFields.add(createButtonLayout());
    }

    private void configureRadioButtons() {
        blind.setLabel("Blind note");
        blind.setItems(true, false);
        blind.addValueChangeListener(event -> {
            if(event.getValue() == true) {
                wineSpecificFields.setVisible(false);

            } else {
                wineSpecificFields.setVisible(true);
            }
        });
    }

    private void configureColorButt() {
        color.setItems(WineColor.values());
        color.setItemLabelGenerator(WineColor::getDisplayValue);
        color.addValueChangeListener(event -> {
            colorSpecification.setItems(event.getValue().getColourSpecification());
            wineColor.setValue(event.getValue());
            if(event.getValue() == WineColor.WHITE) {
                tanninsLvl.setValue(TanninsLvl.NONE);
                tanninsNature.setVisible(false);
            } else {
                tanninsLvl.clear();
                tanninsNature.setVisible(true);
            }
        });

        wineColor.setItems(WineColor.values());
        wineColor.setItemLabelGenerator(WineColor::getDisplayValue);
        wineColor.addValueChangeListener(event -> {
            if(event.getValue() != null) {
                colorSpecification.setItems(event.getValue().getColourSpecification());
                color.setValue(event.getValue());
                if(event.getValue() == WineColor.WHITE) {
                    tanninsLvl.setValue(TanninsLvl.NONE);
                    tanninsNature.setVisible(false);
                } else {
                    tanninsLvl.clear();
                    tanninsNature.setVisible(true);
                }
            }
        });

        wineType.setItems(WineType.values());
        wineType.setItemLabelGenerator(WineType::getDisplayValue);
    }

    private Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        save.addClickShortcut(Key.ENTER);

        delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        cancel.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        cancel.addClickShortcut(Key.CANCEL);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(click -> fireEvent
                (new DeleteEvent(this, wineInfoBinder.getBean(), noteBinder.getBean())));
        cancel.addClickListener(click -> fireEvent(new CloseEvent(this)));

        wineInfoBinder.addStatusChangeListener(evt -> save.setEnabled(wineInfoBinder.isValid()));
        noteBinder.addStatusChangeListener(evt -> save.setEnabled(noteBinder.isValid()));
        return new HorizontalLayout(save, delete, cancel);
    }

    private void validateAndSave() {
        if(noteBinder.isValid() && wineInfoBinder.isValid()) {
            fireEvent(new SaveEvent(this, wineInfoBinder.getBean(), noteBinder.getBean()));

        }
    }

    public static abstract class EditNoteForEvent extends ComponentEvent<EditNoteForm> {
        private Note note;
        private WineInfo wineInfo;

        protected EditNoteForEvent(EditNoteForm source, WineInfo wineInfo, Note note) {
            super(source, false);
            this.note = note;
            this.wineInfo = wineInfo;
        }

        public Note getNote() {
            return this.note;
        }

        public WineInfo getWineInfo() {
            return this.wineInfo;
        }
    }

    public static class SaveEvent extends EditNoteForEvent {
        SaveEvent(EditNoteForm source, WineInfo wineInfo, Note note) {
            super(source, wineInfo, note);
        }
    }

    public static class DeleteEvent extends EditNoteForEvent {
        DeleteEvent(EditNoteForm source, WineInfo wineInfo, Note note) {
            super(source, wineInfo, note);
        }

    }

    public static class CloseEvent extends EditNoteForEvent {
        CloseEvent(EditNoteForm source) {
            super(source, null, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
