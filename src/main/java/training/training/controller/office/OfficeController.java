package training.training.controller.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import training.training.service.office.OfficeService;
import training.training.view.OfficeView;
import training.training.view.ResultView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/{id}")
    public OfficeView getOfficeById(@PathVariable Integer id) throws Exception {
        return officeService.getOfficeById(id);
    }

    @PostMapping("/list/{orgId}")
    public List<OfficeView> getOfficeByOrg(@PathVariable Integer orgId) throws Exception {
        return  officeService.getOfficeByOrg(orgId);
    }

    @PostMapping("/update")
    public ResultView updateOffice(@RequestBody OfficeView officeView) throws Exception {
        return officeService.updateOffice(officeView);
    }

    @PostMapping("/save")
    public ResultView addOffice(@RequestBody OfficeView officeView) throws Exception {
        return officeService.addOffice(officeView);
    }
}
