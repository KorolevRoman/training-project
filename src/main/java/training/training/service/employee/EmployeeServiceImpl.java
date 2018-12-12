package training.training.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.training.view.EmployeeView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<EmployeeView> employeeViewList = new ArrayList<>();

    @Autowired
    public EmployeeServiceImpl() {
        employeeViewList.add(new EmployeeView(1, "Иванов", "Иван", "Иванович", "менеджер",
                "89273451234", "паспорт РФ", "5623 545323", new Date(), 643, "Россия"));
        employeeViewList.add(new EmployeeView(2, "Петров", "Иван", "Иванович", "менеджер",
                "89273451313", "паспорт РФ", "5623 234432", new Date(), 643, "Россия"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeView getEmployee(Integer id) throws Exception {
        EmployeeView returnedView = new EmployeeView();
        for (EmployeeView view : employeeViewList) {
            if(id == view.id){
                returnedView = view;
            }
        }
        if(returnedView.id != null) {
            return returnedView;
        } else {
            throw new Exception("Not found id");
        }
    }
}
