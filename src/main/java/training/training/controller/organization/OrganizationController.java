package training.training.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import training.training.service.organization.OrganizationService;
import training.training.view.OrganizationView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/list")
    @ResponseBody
    public List<OrganizationView> organizations(){
        return organizationService.organizations();
    }

    @GetMapping("/{id}")
    public OrganizationView organization(@PathVariable Integer id){
       return organizationService.organization(id);
    }
}
