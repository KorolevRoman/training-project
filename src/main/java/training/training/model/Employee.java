package training.training.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "middle_name")
    private String middleName;

    @Column
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship")
    private Citizenship citizenship;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Document> documents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    public Employee() {
    }

    public Employee(String firstName, String secondName, String middleName, String position) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.documents = new HashSet<>();
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public Office getOffice() {
        return office;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void addDocument(Document document){
        getDocuments().add(document);
        document.setEmployee(this);
    }

    public void removeDocument(Document document){
        getDocuments().remove(document);
        document.setEmployee(null);
    }
}
