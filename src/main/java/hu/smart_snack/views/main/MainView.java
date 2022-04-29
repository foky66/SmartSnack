package hu.smart_snack.views.main;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import lombok.extern.slf4j.Slf4j;


@PageTitle("Main")
@Route(value = "main")
@Slf4j
public class MainView extends AppLayout {

    public MainView() {
        createHeader();
        createDrawers();

    }

    private void createDrawers() {
        RouterLink main = new RouterLink("Home", HomeView.class);
        RouterLink create = new RouterLink("Create Machine", CreateSnackMachineView.class);
        RouterLink listAll = new RouterLink("All Machines", AvailableMachinesView.class);
        create.setHighlightCondition(HighlightConditions.sameLocation());
        addToDrawer(new VerticalLayout(
                main,
                listAll,
                create
        ));
    }

    private void createHeader() {
        H1 title = new H1("SnackMachine");
        title.addClassNames("text-l", "m-m");
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), title);
        header.setAlignItems(FlexComponent.Alignment.AUTO);
        addToNavbar(header);
    }

}
