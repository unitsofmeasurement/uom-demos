package tech.uom.demo.web.vaadindemo;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Route("")
@PWA(name = "Project Base for Vaadin Flow", shortName = "Project Base")
public class ConversionView extends VerticalLayout {

    private static final Logger LOG = LoggerFactory.getLogger(ConversionView.class);


    private final ConversionForm conversionForm;

    public ConversionView(ConversionForm conversionForm) {
        this.conversionForm = conversionForm;

        LOG.debug("In init");
        HorizontalLayout mainContent = new HorizontalLayout(conversionForm);
        mainContent.setSizeFull();
        add(mainContent);

    }

}
