package hu.smart_snack.Controller;


import hu.smart_snack.Services.Impl.SnackMachineServiceImpl;
import hu.smart_snack.model.SnackMachine;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snackMachine")
@RequiredArgsConstructor
public class SnackMachineController {
    private final SnackMachineServiceImpl service;

    @GetMapping("/list")
    public List<SnackMachine> getMachines(){
       return service.getAllSnackMachine();
    }

    @PostMapping("/save")
    public SnackMachine saveMachine(@RequestBody SnackMachine machine){
        return service.create(machine);
    }

    @GetMapping("/get/{machineID}")
    public SnackMachine getMachine(@PathVariable("machineID") Integer ID){
        return service.get(ID);
    }


}
