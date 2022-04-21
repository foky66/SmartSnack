package hu.smart_snack.repo;

import hu.smart_snack.model.SnackMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartSnackRepository extends JpaRepository<SnackMachine, Integer> {

}
