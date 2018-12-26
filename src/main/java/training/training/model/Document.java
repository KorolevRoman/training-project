package training.training.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name = "code")
    private TypeOfDocument typeOfDocument;

    @Column(name = "date_issue")
    private Date dateIssue;

    @Column
    private String number;

    public Document() {
    }

    public Document( String number) {
        this.number = number;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTypeOfDocument(TypeOfDocument typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }

    public TypeOfDocument getTypeOfDocument() {
        return typeOfDocument;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public String getNumber() {
        return number;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
