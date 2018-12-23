package training.training.dao.employee;

import training.training.model.Employee;

/**
 * DAO для работы с Employee
 */
public interface EmployeeDAO {
    /**
     * Получить employee по фильтру
     *
     * @param employee
     * @return Employee
     */
    Employee loadByFilter(Employee employee);

    /**
     * Получить Employee по идентификатору
     *
     * @param id
     * @return Employee
     */
    Employee loadById(Integer id);

    /**
     * Сохранить Employee
     *
     * @param employee
     */
    void save(Employee employee);

    /**
     *Обновить Employee
     *
     * @param employee
     */
    void update(Employee employee) throws Exception;
}
