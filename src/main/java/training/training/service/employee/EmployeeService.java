package training.training.service.employee;

import training.training.view.EmployeeView;

/**
 * Сервис
 */
public interface EmployeeService {
    /**
     * Получить сотрудника по id
     *
     * @return {@Employee}
     */
    EmployeeView employee(Integer id);
}
