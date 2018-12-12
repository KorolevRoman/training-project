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

    @PostMapping("/save")
    public String addOrganization(@RequestParam OrganizationView view){
        if(view != null){
            try {
                return "{\n\t\"data\":{\n\t\t" + organizationService.addOrganization(view) + "\n\t}\n}";
            } catch (Exception e){
                return "{\n\t\"error\":{\n\t\t" + e.getMessage() + "\n\t}\n}";
            }
        }
        return null;
    }

    @GetMapping("/{id}")
    public String getOrganization(@PathVariable Integer id){
        try {
            return "{data:" + organizationService.getOrganization(id).toString() + "}";
        } catch (Exception e){
            return "{error:" + e.getMessage() + "}";
        }
    }
}
