package training.training.controller.organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import training.training.service.organization.OrganizationService;
import training.training.view.OrganizationView;
import training.training.view.ResultView;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController", description = "Управление инфорамцией об организациях")
@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Получить организацию по заданному фильтру", httpMethod = "POST")
    @PostMapping("/list")
    public OrganizationView getOrganization(@RequestBody OrganizationView view) throws Exception {
        try {
            return organizationService.getOrganization(view);
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/save")
    public ResultView addOrganization(@RequestBody OrganizationView view) throws Exception {
        try {
            return organizationService.addOrganization(view);
        } catch (Exception e){
            throw  e;
        }
    }

    @ApiOperation(value = "Обновить информацию об организации", httpMethod = "POST")
    @PostMapping("/update")
    public ResultView updateOrganization(@RequestBody OrganizationView view) throws Exception {
        try {
            return organizationService.updateOrganization(view);
        } catch (Exception e) {
            throw e;
        }
    }

    @ApiOperation(value = "Получить орагнизацию по id", httpMethod = "GET")
    @GetMapping("/{id}")
    public OrganizationView getOrganizationById(@PathVariable Integer id) throws Exception{
        try {
            return organizationService.getOrganizationById(id);
        } catch (Exception e){
            throw e;
        }
    }
}
