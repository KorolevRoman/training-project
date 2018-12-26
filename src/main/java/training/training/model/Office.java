package training.training.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Version
    private Integer version;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
