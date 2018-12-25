package training.training.view;

import io.swagger.annotations.ApiModel;
import org.codehaus.commons.nullanalysis.NotNullByDefault;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Организация")
public class OrganizationView {
    public Integer id;

    @NotEmpty
    @Size(max = 45)
    public String name;

    @NotEmpty
    @Size(max = 100)
    public String fullName;

    @NotEmpty(message = "the organization must have a INN")
    @Size(max = 12)
    public String inn;

    @NotEmpty
    @Size(max = 9)
    public String kpp;

    @NotEmpty
    @Size(max = 100)
    public String address;

    @Size(max = 11)
    public String phone;

    @NotNull(message = "active cannot be null")
    public Boolean isActive;

    public OrganizationView() {
    }

    public OrganizationView(@NotEmpty @Size(max = 45) String name, @NotEmpty @Size(max = 100) String fullName, @NotEmpty(message = "the organization must have a INN") @Size(max = 12) String inn, @NotEmpty @Size(max = 9) String kpp, @NotEmpty @Size(max = 100) String address, @NotNull(message = "active cannot be null") Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.isActive = isActive;
    }

    public OrganizationView(@NotEmpty @Size(max = 45) String name, @NotEmpty(message = "the organization must have a INN") @Size(max = 12) String inn) {
        this.name = name;
        this.inn = inn;
    }

    @Override
    public String toString(){
        return "{id: " + id + "; name: " + name + "; fullName: " + fullName + "; inn: " + inn + "; kpp: " + kpp +
                "; address: " + address + "; phone: " + phone + "; isActive: " + isActive + "}";
    }


}
