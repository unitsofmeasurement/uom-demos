package tech.uom.demo.web.vaadindemo;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import tec.uom.se.unit.Units;

import javax.measure.Unit;
import javax.measure.UnitConverter;

import static systems.uom.common.USCustomary.*;
import static tec.uom.se.unit.Units.*;
import static tec.uom.se.unit.MetricPrefix.*;

@SpringComponent
@UIScope
public class ConversionForm extends FormLayout {

//    private Binder<ConversionRequest> binder = new Binder<>(ConversionRequest.class);


    TextField result = new TextField("Result");
    TextField fromValue = new TextField("Value");

    Select<Unit> fromSelect = new Select<>();
    Select<Unit> toSelect = new Select<>();

    @Autowired
    public ConversionForm() {


        fromSelect.setLabel("From");
        fromSelect.setEmptySelectionAllowed(Boolean.FALSE);
        fromSelect.setEmptySelectionCaption("Select you title");


        toSelect.setLabel("To");
        toSelect.setEmptySelectionAllowed(Boolean.FALSE);
        toSelect.setEmptySelectionCaption("Select you title");

        Select<String> baseUnits = new Select<>();
        baseUnits.setLabel("Unit of Measurement");
        baseUnits.setItems("length", "energy", "area", "mass", "power", "angle", "temperature", "speed");
        baseUnits.addValueChangeListener(new HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<Select<String>, String>>() {
            @Override
            public void valueChanged(AbstractField.ComponentValueChangeEvent<Select<String>, String> selectStringComponentValueChangeEvent) {
                String selectedUnit = selectStringComponentValueChangeEvent.getValue();
                Unit<?>[] units = setUnitsOfMeasurements(selectedUnit);

                fromSelect.setItems(units);
                toSelect.setItems(units);
            }
        });

        Button btnConvert = new Button("Convert");

        HorizontalLayout fromPanel = new HorizontalLayout(baseUnits, fromSelect, toSelect);
        fromPanel.setSizeFull();


        HorizontalLayout toPanel = new HorizontalLayout(fromValue, result);
        toPanel.setSizeFull();

        btnConvert.addClickListener(event -> convert());

        add(new VerticalLayout(fromPanel, toPanel, btnConvert));

    }

    public void convert() {

        Unit sourceUnit = fromSelect.getValue();
        Unit destUnit = toSelect.getValue();
        UnitConverter converter = sourceUnit.getConverterTo(destUnit);


        result.setValue(String.valueOf(converter.convert(Double.parseDouble(fromValue.getValue()))));
    }

    private Unit<?>[] setUnitsOfMeasurements(String selection) {
        switch (selection) {
            case "length":
                return new Unit[] {
                        MILE,
                        KILO(METRE),
                        METRE,
                        CENTI(METRE),
                        DECI(METRE),
                        MILLI(METRE),
                        FOOT,
                        INCH,
                        YARD
                };
            case "energy":
                return new Unit[] {
                        JOULE,
                        //Units.ELECTRON_VOLT,
//                    UCUM.BTU
                };
            case "area":
                return new Unit[] {
                        SQUARE_METRE,
                        SQUARE_FOOT,
                        ARE,
                        HECTARE,
                        ACRE
                };
            case "mass":
                return new Unit[] {
                        KILOGRAM,
                        GRAM,
                        POUND,
                        OUNCE,
                        TON
                };
            case "power":
                return new Unit[] {
                        HORSEPOWER,
                        WATT
                };
            case "angle":
                return new Unit[] {
                        CENTIRADIAN,
                        GRADE //,
                        //Units.REVOLUTION
                };
            case "speed":
                return new Unit[] {
                        Units.KILOMETRE_PER_HOUR,
                        MILE_PER_HOUR
                };
            case "temperature":
                return new Unit[] {
                        CELSIUS,
                        FAHRENHEIT,
                        KELVIN,
                        RANKINE
                };
            default:
                return null;
        }
    }
}
