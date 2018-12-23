package training.training.dao.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.training.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Employee loadByFilter(Employee employee) {
        String queryString = String.format("SELECT emp FROM %s emp" +
                        " JOIN emp.citizenship ctz ON ctz.code = :ctzCode" +
                        " WHERE emp.firstName = :firstName" +
                        " AND emp.secondName = :secondName" +
                        " AND emp.middleName = :middleName" +
                        " AND emp.position = :position",
                Employee.class.getSimpleName());
        TypedQuery<Employee> query = em.createQuery(queryString, Employee.class);
        query.setParameter("firstName", employee.getFirstName());
        query.setParameter("secondName", employee.getSecondName());
        query.setParameter("middleName", employee.getMiddleName());
        query.setParameter("position", employee.getPosition());
        return query.getSingleResult();
    }

    @Override
    public Employee loadById(Integer id) {
        return em.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        em.persist(employee);
    }

    @Override
    public void update(Employee employee) throws Exception {
        em.merge(employee);
    }
}
