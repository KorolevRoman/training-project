package training.training.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.training.view.EmployeeView;

import java.util.Date;

/**
 * {@inheritDoc}
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    public EmployeeServiceImpl() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeView employee(Integer id) {
        if (id == 1){
            return new EmployeeView(1, "Иванов", "Иван", "Иванович", "менеджер",
                    "89273451234", "паспорт РФ", "5623 545323", new Date(), 643, "Россия");
        } else {
            return new EmployeeView();
        }
    }
}
