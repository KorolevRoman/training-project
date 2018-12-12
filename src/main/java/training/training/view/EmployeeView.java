package training.training.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class EmployeeView {
    @NotEmpty
    public Integer id;

    @NotEmpty
    @Size(max = 45)
    public String firstName;

    @NotEmpty
    @Size(max = 45)
    public String secondName;

    @NotEmpty
    @Size(max = 45)
    public String middleName;

    @NotEmpty
    @Size(max = 45)
    public String position;

    @NotEmpty
    @Size(max = 11)
    public String phone;

    @NotEmpty
    @Size(max = 45)
    public String docName;

    @NotEmpty
    @Size(max = 45)
    public String docNumber;

    @NotEmpty
    public Date docDate;

    @NotEmpty
    @Size(max = 3)
    public Integer citizenshipCode;

    @NotEmpty
    @Size(max = 45)
    public String citizenshipName;

    public EmployeeView() {
    }

    public EmployeeView(@NotEmpty Integer id, @NotEmpty @Size(max = 45) String firstName, @NotEmpty @Size(max = 45) String secondName, @NotEmpty @Size(max = 45) String middleName, @NotEmpty @Size(max = 45) String position, @NotEmpty @Size(max = 11) String phone, @NotEmpty @Size(max = 45) String docName, @NotEmpty @Size(max = 45) String docNumber, @NotEmpty Date docDate, @NotEmpty @Size(max = 3) Integer citizenshipCode, @NotEmpty @Size(max = 45) String citizenshipName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipCode = citizenshipCode;
        this.citizenshipName = citizenshipName;
    }

    @Override
    public String toString(){
        return "{id: " + id + "; firstName: " + firstName + "; secondName: " + secondName + "; middleName: " + middleName +
                "; position: " + position + "; docName: " + docName + "; docNumber: " + docNumber + "; docDate: " + docDate +
                "; citizenshipCode: " + citizenshipCode + "; citizenshipName: " + citizenshipName + "}";
    }
}
