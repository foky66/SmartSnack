package hu.smart_snack.Services.Impl;

import hu.smart_snack.Services.SnackMachineService;
import hu.smart_snack.model.SnackMachine;
import hu.smart_snack.repo.SmartSnackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SnackMachineServiceImpl implements SnackMachineService {
    private final SmartSnackRepository repository;

    @Override
    public SnackMachine create(SnackMachine snackAutomat) {
        log.info("Saving new SnackMachine: {}", snackAutomat);
        return repository.save(snackAutomat);
    }

    @Override
    public List<SnackMachine> getAllSnackMachine() {
        log.info("Listing all SnackMachines");
        return repository.findAll();
    }

    @Override
    public SnackMachine get(Integer iD) {
        log.info("Return SnackMachine by Id:{}", iD);
        return repository.findById(iD).get();
    }

    @Override
    public SnackMachine update(SnackMachine snackAutomat) {
        log.info("Updating SnackMachine ID:{}",snackAutomat.getId());
        return repository.save(snackAutomat);
    }
}
