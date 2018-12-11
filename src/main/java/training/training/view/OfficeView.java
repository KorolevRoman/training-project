package training.training.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OfficeView {
    @NotEmpty
    public Integer id;

    @NotEmpty
    @Size(max = 45)
    public String name;

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

    public OfficeView(@NotEmpty Integer id, @NotEmpty @Size(max = 45) String name, @NotEmpty @Size(max = 100) String address, @NotEmpty @Size(max = 11) String phone, @NotEmpty Boolean isActive) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public String toString(){
        return "id: " + id + "; name:" + name + "; address: " + address + "; phone: " + phone + "; is active:" + isActive;
    }
}
