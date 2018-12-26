package training.training.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class EmployeeView {

    public Integer id;

    @NotEmpty
    @Size(max = 45)
    public String firstName;

    @NotEmpty
    @Size(max = 45)
    public String secondName;

    @Size(max = 45)
    public String middleName;

    @NotNull
    public Integer officeId;

    @NotEmpty
    @Size(max = 45)
    public String position;

    public Set<DocumentView> documents;

    public Integer citizenshipCode;

    @Size(max = 45)
    public String citizenshipName;

    public EmployeeView() {
    }

    public EmployeeView(Integer id, @NotEmpty @Size(max = 45) String firstName, @NotEmpty @Size(max = 45) String secondName, @Size(max = 45) String middleName, @NotEmpty @Size(max = 45) String position, Set<DocumentView> documents, Integer citizenshipCode, @Size(max = 45) String citizenshipName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.documents = documents;
        this.citizenshipCode = citizenshipCode;
        this.citizenshipName = citizenshipName;
    }

    public EmployeeView(Integer id, @NotEmpty @Size(max = 45) String firstName, @NotEmpty @Size(max = 45) String secondName, @Size(max = 45) String middleName, @NotNull Integer officeId, @NotEmpty @Size(max = 45) String position, Set<DocumentView> documents, Integer citizenshipCode, @Size(max = 45) String citizenshipName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.officeId = officeId;
        this.position = position;
        this.documents = documents;
        this.citizenshipCode = citizenshipCode;
        this.citizenshipName = citizenshipName;
    }

    public EmployeeView(@NotEmpty @Size(max = 45) String firstName, @NotEmpty @Size(max = 45) String secondName, @Size(max = 45) String middleName, @NotNull Integer officeId, @NotEmpty @Size(max = 45) String position, Set<DocumentView> documents, Integer citizenshipCode, @Size(max = 45) String citizenshipName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.officeId = officeId;
        this.position = position;
        this.documents = documents;
        this.citizenshipCode = citizenshipCode;
        this.citizenshipName = citizenshipName;
    }

    @Override
    public String toString(){
       return  "{id: " + id + "; firstName: " + firstName + "; secondName: " + secondName + "; middleName: " + middleName +
                    "; position: " + position + "; citizenshipCode: " + citizenshipCode + "; citizenshipName: " + citizenshipName + "}";
    }
}
