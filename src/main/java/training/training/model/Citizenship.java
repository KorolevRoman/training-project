package training.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "Citizenship")
public class Citizenship {

    @Id
    @Column
    private Integer code;

    @Column
    private String name;

    @OneToMany(
            mappedBy = "citizenship"
    )
    private Set<Employee> employees;
}
