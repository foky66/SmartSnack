package hu.smart_snack.views.main;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.SerializableBiConsumer;
import com.vaadin.flow.router.Route;
import hu.smart_snack.controller.SnackMachineController;
import hu.smart_snack.model.SnackMachine;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Route(value = "allMachines", layout = MainView.class)
@Slf4j
public class AvailableMachinesView extends HorizontalLayout {

    private final SnackMachineController controller;

    public AvailableMachinesView(SnackMachineController controller) {
        this.controller = controller;
        createGrid();
    }

    private void createGrid(){
        List<SnackMachine> allMachines = controller.getMachines() ;
        Grid<SnackMachine> grid = new Grid<>(SnackMachine.class,false);
        grid.addColumn(SnackMachine::getId).setHeader("SnackMachine ID").setWidth("25px");
        grid.addColumn(SnackMachine::getCounty).setHeader("County");
        grid.addColumn(SnackMachine::getCity).setHeader("City");
        grid.addColumn(SnackMachine::getProduct).setHeader("Products").setWidth("40px");
        grid.addColumn(createStatusComponentRenderer()).setHeader("Product Shortage");
        grid.getColumns().forEach(col-> col.setAutoWidth(true));

        grid.setItems(allMachines);
        add(grid);
    }
    private static final SerializableBiConsumer<Span, SnackMachine> statusComponentUpdater = (span, machine) -> {
        boolean isAvailable = !machine.isAnyProductEmpty();
        String theme = String
                .format("badge %s", isAvailable ? "success" : "error");
        span.getElement().setAttribute("theme", theme);
        span.setText(isAvailable ? "not empty" : "empty");
    };

    private static ComponentRenderer<Span, SnackMachine> createStatusComponentRenderer() {
        return new ComponentRenderer<>(Span::new, statusComponentUpdater);
    }
}
