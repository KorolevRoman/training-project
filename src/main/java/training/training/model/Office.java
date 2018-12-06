package training.training.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Office")
public class Office {

    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(
            mappedBy = "office"
    )
    private Set<Employee> employees;

    /**
     * Конструктор для hibernate
     */
    public Office() {
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee){
        getEmployees().add(employee);
        employee.setOffice(this);
    }

    public void removeEmployee(Employee employee){
        getEmployees().remove(employee);
        employee.setOffice(null);
    }
}
