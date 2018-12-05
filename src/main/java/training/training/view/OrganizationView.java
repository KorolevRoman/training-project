package training.training.view;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Организация")
public class OrganizationView {
    @NotEmpty
    public Integer id;

    @NotEmpty
    @Size(max = 45)
    public String name;

    @NotEmpty
    @Size(max = 12)
    public String inn;

    public OrganizationView(@NotEmpty Integer id, @NotEmpty @Size(max = 45) String name, @NotEmpty @Size(max = 12) String inn) {
        this.id = id;
        this.name = name;
        this.inn = inn;
    }

    @Override
    public String toString(){
        return "{id: " + id + "; name: " + name + "; inn: " + inn + "}";
    }
}
