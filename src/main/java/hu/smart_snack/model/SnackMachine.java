package hu.smart_snack.model;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Getter
public class SnackMachine {

    @Id
    @GeneratedValue
    Integer id;
    String county;
    String city;
    HashMap<String,Integer> products;
    boolean isWorking;
    boolean isAnyProductEmpty;

}
