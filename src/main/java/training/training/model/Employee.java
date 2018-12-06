package training.training.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column
    private Integer id;

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

    public void setOffice(Office office) {
        this.office = office;
    }

    public Set<Document> getDocuments() {
        return documents;
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
