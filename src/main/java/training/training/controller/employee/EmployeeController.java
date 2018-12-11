package training.training.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.training.service.employee.EmployeeService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/employee", produces = APPLICATION_JSON_VALUE)
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public String employee(@PathVariable Integer id){
        try {
            return "{\n\t\"data\":{\n\t\t" + employeeService.employee(id).toString() + "\n\t}\n}";
        } catch (Exception e){
            return "{\n\t\"error\":{\n\t\t" + e.getMessage() + "\n\t}\n}";
        }
    }
}
