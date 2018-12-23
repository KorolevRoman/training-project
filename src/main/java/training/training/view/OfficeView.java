package training.training.view;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OfficeView {

    public Integer id;

    @NotEmpty
    @Size(max = 45)
    public String name;

    @NotEmpty
    public Integer orgId;

    @NotEmpty
    @Size(max = 100)
    public String address;

    @NotEmpty
    @Size(max = 11)
    public String phone;

    @NotEmpty
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

    public OfficeView(Integer id, @NotEmpty @Size(max = 45) String name, @NotEmpty Integer orgId, @NotEmpty @Size(max = 100) String address, @NotEmpty @Size(max = 11) String phone, @NotEmpty Boolean isActive) {
        this.id = id;
        this.name = name;
        this.orgId = orgId;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public String toString(){
        return "{id: " + id + "; name:" + name + "; address: " + address + "; phone: " + phone + "; is active:" + isActive + "}";
    }


}
