package tech.uom.demo.web.vaadindemo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;


@SpringComponent
@UIScope
public class ConversionForm extends FormLayout {

//    private Binder<ConversionRequest> binder = new Binder<>(ConversionRequest.class);


    TextField result = new TextField("Result");
    TextField fromValue = new TextField("Value");

    @Autowired
    public ConversionForm() {



        Select<String> fromSelect = new Select<>();
        fromSelect.setLabel("From");
        fromSelect.setItems("KM", "CM", "MM", "Micro Meter");

        fromSelect.setEmptySelectionAllowed(Boolean.FALSE);
        fromSelect.setEmptySelectionCaption("Select you title");



        Select<String> toSelect = new Select<>();
        toSelect.setLabel("To");
        toSelect.setItems("KM", "CM", "MM", "Micro Meter");

        toSelect.setEmptySelectionAllowed(Boolean.FALSE);
        toSelect.setEmptySelectionCaption("Select you title");

        Button btnConvert = new Button("Convert");

//        binder.bindInstanceFields(this);


        HorizontalLayout fromPanel = new HorizontalLayout(fromSelect, toSelect);
        fromPanel.setSizeFull();


        HorizontalLayout toPanel = new HorizontalLayout(fromValue, result);
        toPanel.setSizeFull();

        btnConvert.addClickListener(event -> convert());

        add(new VerticalLayout(fromPanel, toPanel, btnConvert));

    }

    public void convert() {
        result.setValue(Integer.toString(Integer.getInteger(fromValue.getValue())*2));
    }
}
