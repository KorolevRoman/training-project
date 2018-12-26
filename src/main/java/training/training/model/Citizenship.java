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

    public Citizenship() {
    }

    public Citizenship(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee){
        getEmployees().add(employee);
        employee.setCitizenship(this);
    }
}
