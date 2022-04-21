package hu.smart_snack.Services;

import hu.smart_snack.model.SnackMachine;

import java.util.List;

public interface SnackMachineService {
    
    SnackMachine create(SnackMachine snackMachine);
    List<SnackMachine> getAllSnackMachine();
    SnackMachine get(Integer iD);
    SnackMachine update(SnackMachine snackAutomat);
    
}
