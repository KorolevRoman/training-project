package training.training.model;

import javax.persistence.*;
import java.util.Set;

/**
* Организация
*/

@Entity(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Column(length = 12, unique = true)
    private String inn;

    @Column(length = 9)
    private String kpp;

    @Column
    private String address;

    @Column
    private String phone;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(
            mappedBy = "organization"
    )
    private Set<Office> offices;

    /**
     * Конструктор для hibernate
     */
    public Organization() {
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void addOffice(Office office){
        getOffices().add(office);
        office.setOrganization(this);
    }

    public void removeOffice(Office office){
        getOffices().remove(office);
        office.setOrganization(null);
    }

}
