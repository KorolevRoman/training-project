package training.training.service.employee;

import org.springframework.stereotype.Service;
import training.training.view.EmployeeView;
import training.training.view.ResultView;

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
    EmployeeView getEmployeeById(Integer id) throws Exception;

    /**
     * Получить сотрудника по фильтру
     *
     * @param view
     * @return {@Employee}
     */
    EmployeeView getEmployeeById(EmployeeView view) throws Exception;

    /**
     * Добавить нового сотрудника
     *
     * @param view
     * @return {@ResultView}
     */
    ResultView addEmployee(EmployeeView view) throws Exception;

    /**
     * Изменить данные сотрудника
     *
     * @param view
     * @return {@ResultView}
     */
    ResultView updateEmployee(EmployeeView view) throws Exception;
}
