package pl.patryk.wine.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import pl.patryk.wine.model.Producer;
import pl.patryk.wine.model.Wine;
import pl.patryk.wine.model.enums.WineType;
import pl.patryk.wine.service.IProducerService;
import pl.patryk.wine.service.IWineService;
import pl.patryk.wine.service.impl.BeansSupplier;



import java.util.List;
@Route("xx")
public class WineSearchForm extends FormLayout {


    ComboBox<Wine> name = new ComboBox<>("Wine");
    NumberField vintageNumber = new NumberField("Vintage");
    ComboBox<WineType> wineType = new ComboBox<>("Type");
    ComboBox<Producer> producerComboBox = new ComboBox<>("Producer");

    Button addNoteToThisWine = new Button("Selected wine note");
    Button addCustomNote = new Button("Custom note");
    Button cancel = new Button("Cancel");



    public WineSearchForm() {


        addClassName("wine-search-form");
        setSizeFull();
        configureButtons();
        add(
                name,
                vintageNumber,
                wineType,
                producerComboBox,
                createButtonLayout()
        );

    }




    private void configureButtons() {
        List<Wine> wineList = BeansSupplier.get(IWineService.class).findAll();
        name.setItemLabelGenerator(Wine::getNameVintageProducerCountry);
        name.setItems(wineList);


        wineType.setItemLabelGenerator(WineType::getDisplayValue);
        wineType.setItems(WineType.values());
        wineType.setVisible(false);


        List<Producer> producerList = BeansSupplier.get(IProducerService.class).findAll();
        producerComboBox.setItemLabelGenerator(Producer::getNameAndCountry);
        producerComboBox.setItems(producerList);
        producerComboBox.setVisible(false);

        vintageNumber.setVisible(false);

        name.addValueChangeListener(click -> {
            if(name.getValue() != null) {
                Wine wine = name.getValue();
                wineType.setVisible(true);
                wineType.setValue(wine.getType());
                wineType.setReadOnly(true);

                vintageNumber.setVisible(true);
                vintageNumber.setValue((double) wine.getVintage());
                vintageNumber.setReadOnly(true);

                producerComboBox.setVisible(true);
                producerComboBox.setValue(wine.getProducer());
                producerComboBox.setReadOnly(true);

                addNoteToThisWine.setEnabled(true);
            }

            else if(name.getValue() == null) {
                wineType.setVisible(false);
                vintageNumber.setVisible(false);
                producerComboBox.setVisible(false);
            }

        });



    }

    private Component createButtonLayout() {
        addNoteToThisWine.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addNoteToThisWine.setEnabled(false);

        addCustomNote.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        cancel.addThemeVariants(ButtonVariant.LUMO_CONTRAST);


        cancel.addClickShortcut(Key.CANCEL);

        return new HorizontalLayout(addCustomNote, addNoteToThisWine, cancel);
    }
}
