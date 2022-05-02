package hu.smart_snack.schedule;


import hu.smart_snack.model.SnackMachine;
import hu.smart_snack.services.Impl.SnackMachineServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Configuration
@Slf4j
@EnableScheduling
public class ConsumeSchedule {

    private final SnackMachineServiceImpl service;
    private List<SnackMachine> machines;
    private SnackMachine machine;

    @Autowired
    public ConsumeSchedule(SnackMachineServiceImpl service) {
        this.service = service;
    }


    @Scheduled(fixedDelay = 23000)
    public void simulateConsuming(){
        getMachine();
        HashMap<String, Integer> products = machine.getProducts();
        log.info("Consuming ID=" + machine.getId() + " products : " + machine.getProducts() );
        for(Map.Entry<String, Integer> entry : products.entrySet()){
            entry.setValue(entry.getValue()-2);
            if(entry.getValue() < 0){
                entry.setValue(0);
            }
            if(entry.getValue() == 0 ) {
                machine.setAnyProductEmpty(true);
            }
        }

        machine.setProducts(products);
        log.info("Consumed products : " + machine.getProducts() );
        service.update(machine);

    }


    public void getMachine(){
        Random rnd = new Random();
        machines = service.getAllSnackMachine();
        machine = machines.get(rnd.nextInt(machines.size() - 1) + 1);
    }
}
