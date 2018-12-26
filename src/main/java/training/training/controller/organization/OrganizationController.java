package training.training.controller.organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import training.training.service.organization.OrganizationService;
import training.training.view.OrganizationView;
import training.training.view.ResultView;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController", description = "Управление информацией об организациях")
@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Получить организацию по id", httpMethod = "GET")
    @GetMapping("/{id}")
    public OrganizationView getOrganizationById(@PathVariable Integer id) throws Exception{
        if( id != null) {
            return organizationService.getOrganizationById(id);
        } else {
            throw new IllegalArgumentException("Missed id");
        }
    }

    @ApiOperation(value = "Добавить новую организацию", httpMethod = "POST")
    @PostMapping("/save")
    public ResultView addOrganization(@RequestBody OrganizationView view) throws Exception {
        if(view != null){
            return organizationService.addOrganization(view);
        } else {
            throw new IllegalArgumentException("Missed request body");
        }

    }

    @ApiOperation(value = "Обновить информацию об организации", httpMethod = "POST")
    @PostMapping("/update")
    public ResultView updateOrganization(@RequestBody OrganizationView view) throws Exception {
        if((view !=null) && (view.id !=null)){
            return organizationService.updateOrganization(view);
        } else {
            throw new IllegalArgumentException("Missed organization or id of organization");
        }
    }

    @ApiOperation(value = "Получить организацию по заданному фильтру", httpMethod = "POST")
    @PostMapping("/list")
    public OrganizationView getOrganization(@RequestBody OrganizationView view) throws Exception {
        if((view.name != null) && (view.inn != null) && (view.isActive != null)){
            return organizationService.getOrganization(view);
        } else {
            throw new IllegalArgumentException("Missed one or all parameter of find");
        }

    }
}
