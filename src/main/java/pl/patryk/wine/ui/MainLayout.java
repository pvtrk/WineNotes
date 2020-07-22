package pl.patryk.wine.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightCondition;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;


@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createDrawer() {
        RouterLink myNotesLink = new RouterLink("My Notes", MyNotesView.class);
        myNotesLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink addNotesLink = new RouterLink("Add Note", MyNotesView.class);
        myNotesLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink SearchForWine = new RouterLink("Search wine", MyNotesView.class);
        myNotesLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
                myNotesLink
        ));
    }

    private void createHeader() {
        H1 logo = new H1("Wine Notes for beloved sommeliers");
        logo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.addClassName("header");
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);


        addToNavbar(header);
    }
}
