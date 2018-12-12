package training.training.service.employee;

import org.springframework.stereotype.Service;
import training.training.view.EmployeeView;

/**
 * Сервис
 */
@Service
public interface EmployeeService {
    /**
     * Получить сотрудника по id
     *
     * @param id
     * @return {@Employee}
     */
    EmployeeView getEmployee(Integer id) throws Exception;
}
