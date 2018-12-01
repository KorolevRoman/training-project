package training.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
* Организация
*/

@Entity(name = "Organization")
public class Organization {

    @Id
    @Column(name = "Id")
    private Integer id;


}
