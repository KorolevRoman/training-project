package training.training.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import training.training.service.employee.EmployeeService;
import training.training.view.EmployeeView;
import training.training.view.ResultView;

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
    public ResultView addEmployee(@RequestBody EmployeeView view){
        return null;
    }

    @PostMapping("/update")
    public ResultView updateEmployee(@RequestBody EmployeeView view){
        return null;
    }

    @PostMapping("/list")
    public EmployeeView getEmployeeByFilter(@RequestBody EmployeeView view){
        return null;
    }

    @GetMapping("/{id}")
    public EmployeeView getEmployeeById(@PathVariable Integer id){
        return null;
    }
}
