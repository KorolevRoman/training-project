package training.training.service.employee;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import training.training.view.EmployeeView;
import training.training.view.ResultView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис
 */
@Validated
public interface EmployeeService {
    /**
     * Получить сотрудника по id
     *
     * @param id
     * @return {@Employee}
     */
    EmployeeView getEmployeeById(Integer id) throws Exception;

    /**
     * Получить сотрудников по фильтру
     *
     * @param view
     * @return {@Employee}
     */
    List<EmployeeView> getEmployeeByFilter(EmployeeView view) throws Exception;

    /**
     * Добавить нового сотрудника
     *
     * @param view
     * @return {@ResultView}
     */
    ResultView addEmployee(@Valid EmployeeView view) throws Exception;

    /**
     * Изменить данные сотрудника
     *
     * @param view
     * @return {@ResultView}
     */
    ResultView updateEmployee(EmployeeView view) throws Exception;
}
