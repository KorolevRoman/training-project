package training.training.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Document")
public class Document {

    @Id
    @GeneratedValue
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

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTypeOfDocument(TypeOfDocument typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }
}
