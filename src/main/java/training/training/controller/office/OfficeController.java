package training.training.controller.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import training.training.service.office.OfficeService;
import training.training.view.OfficeView;
import training.training.view.ResultView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController", description = "Управление информацией об офисе")
@RestController
@RequestMapping(value = "/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value = "Получить офис по id", httpMethod = "GET")
    @GetMapping("/{id}")
    public OfficeView getOfficeById(@PathVariable Integer id) throws Exception {
        if (id != null) {
            return officeService.getOfficeById(id);
        } else {
            throw new IllegalArgumentException("Missed id");
        }
    }

    @ApiOperation(value = "Получить список офисов по id организации", httpMethod = "POST")
    @PostMapping("/list/{orgId}")
    public List<OfficeView> getOfficeByOrg(@RequestBody OfficeView view, @PathVariable Integer orgId) throws Exception {
        if (orgId != null && view != null) {
            return officeService.getOfficeByOrg(view, orgId);
        } else {
            throw new IllegalArgumentException("Missed id of organization");
        }
    }

    @ApiOperation(value = "Обновить информацию об офисе", httpMethod = "POST")
    @PostMapping("/update")
    public ResultView updateOffice(@RequestBody OfficeView officeView) throws Exception {
        if (officeView != null) {
            return officeService.updateOffice(officeView);
        } else {
            throw new IllegalArgumentException("Missed request body");
        }
    }

    @ApiOperation(value = "Добавить новый офис", httpMethod = "POST")
    @PostMapping("/save")
    public ResultView addOffice(@RequestBody OfficeView officeView) throws Exception {
        if (officeView != null) {
            return officeService.addOffice(officeView);
        } else {
            throw new IllegalArgumentException("Missed request body");
        }
    }
}
