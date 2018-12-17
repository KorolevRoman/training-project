package training.training.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import training.training.service.organization.OrganizationService;
import training.training.view.OrganizationView;


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
    public OrganizationView getOrganizations (@RequestBody OrganizationView view) throws Exception {
        try {
            return organizationService.getOrganizations(view);
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/save")
    public void addOrganization(@RequestBody OrganizationView view){
        if(view != null){
            try {
                organizationService.addOrganization(view);
            } catch (Exception e){
                e.getMessage();
            }
        }
    }

    @GetMapping("/{id}")
    public OrganizationView getOrganization(@PathVariable Integer id) throws Exception{
        try {
            return organizationService.getOrganization(id);
        } catch (Exception e){
            throw e;
        }
    }
}
