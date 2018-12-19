package training.training.view;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty
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

    @NotEmpty
    public Boolean isActive;

    public OrganizationView() {
    }

    public OrganizationView(Integer id, @NotEmpty @Size(max = 45) String name, @NotEmpty @Size(max = 12) String inn, @NotEmpty Boolean isActive) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
    }

    public OrganizationView(@NotEmpty Integer id, @NotEmpty @Size(max = 45) String name, @NotEmpty @Size(max = 100) String fullName, @NotEmpty @Size(max = 12) String inn, @NotEmpty @Size(max = 9) String kpp, @NotEmpty @Size(max = 100) String address, @Size(max = 11) String phone, @NotEmpty Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public String toString(){
        return "{id: " + id + "; name: " + name + "; fullName: " + fullName + "; inn: " + inn + "; kpp: " + kpp +
                "; address: " + address + "; phone: " + phone + "; isActive: " + isActive + "}";
    }

}
