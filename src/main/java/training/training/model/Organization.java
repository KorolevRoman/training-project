package training.training.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
* Организация
*/

@Entity(name = "Organization")
public class Organization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Version
    private Integer version;

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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
