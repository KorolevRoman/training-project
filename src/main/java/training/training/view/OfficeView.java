package training.training.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeView {

    public Integer id;

    @NotEmpty
    @Size(max = 45)
    public String name;

    @NotNull
    public Integer orgId;

    @NotEmpty
    @Size(max = 100)
    public String address;

    @NotEmpty
    @Size(max = 11)
    public String phone;

    @NotNull
    public Boolean isActive;

    public OfficeView() {
    }

    public OfficeView(@NotEmpty @Size(max = 45) String name, @NotEmpty Integer orgId, @NotEmpty @Size(max = 100) String address, @NotEmpty @Size(max = 11) String phone, @NotEmpty Boolean isActive) {
        this.name = name;
        this.orgId = orgId;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OfficeView(@NotEmpty @Size(max = 45) String name, @NotEmpty Integer orgId, @NotEmpty @Size(max = 11) String phone, @NotEmpty Boolean isActive) {
        this.name = name;
        this.orgId = orgId;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public String toString(){
        return "{id: " + id + "; name:" + name + "; address: " + address + "; phone: " + phone + "; is active:" + isActive + "}";
    }


}
