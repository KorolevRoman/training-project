package training.training.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import training.training.service.employee.EmployeeService;
import training.training.view.EmployeeView;
import training.training.view.ResultView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/employee", produces = APPLICATION_JSON_VALUE)
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResultView addEmployee(@RequestBody EmployeeView view) throws Exception {
        if (view != null) {
            return employeeService.addEmployee(view);
        } else {
            throw new IllegalArgumentException("Missed request body");
        }
    }

    @PostMapping("/update")
    public ResultView updateEmployee(@RequestBody EmployeeView view) throws Exception {
        return employeeService.updateEmployee(view);
    }

    @PostMapping("/list")
    public List<EmployeeView> getEmployeeByFilter(@RequestBody EmployeeView view) throws Exception {
        return employeeService.getEmployeeByFilter(view);
    }

    @GetMapping("/{id}")
    public EmployeeView getEmployeeById(@PathVariable Integer id) throws Exception {
        if (id != null) {
            return employeeService.getEmployeeById(id);
        } else {
            throw new IllegalArgumentException("Missed id");
        }
    }
}
