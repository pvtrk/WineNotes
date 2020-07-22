package pl.patryk.wine.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import pl.patryk.wine.model.Wine;
import pl.patryk.wine.model.enums.*;

import java.util.ArrayList;
import java.util.List;


public class EditNoteForm extends FormLayout {
    List<Component> wineSpecificFields = new ArrayList<>();
    List<Component> tastingNoteFields = new ArrayList<>();

    RadioButtonGroup blind = new RadioButtonGroup();
    
    ComboBox<Wine> wine = new ComboBox<>("Wine");



    H2 appearance = new H2("Appearance");
    ComboBox<WineColor> wineColor = new ComboBox<>("Color");
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




    public EditNoteForm() {
        configureButtons();
    }

    private void configureButtons() {
        blind.setLabel("Blind note");
        blind.setItems("Yes", "No");
        
    }

    
}
