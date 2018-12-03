package training.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
* Организация
*/

@Entity(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer id;

    @Column
    private String name;

}
