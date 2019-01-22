package training.training.dao.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.training.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> loadByFilter(Employee employee) {
        String queryString = String.format("SELECT emp FROM %s emp" +
                        " JOIN emp.office off ON off.id = :offId" +
                        " JOIN emp.citizenship ctz ON ctz.code = :ctzCode" +
                        " WHERE emp.firstName = :firstName" +
                        " OR emp.secondName = :secondName" +
                        " OR emp.middleName = :middleName" +
                        " OR emp.position = :position",
                Employee.class.getSimpleName());
        TypedQuery<Employee> query = em.createQuery(queryString, Employee.class);
        query.setParameter("offId", employee.getOffice().getId());
        query.setParameter("ctzCode", employee.getCitizenship().getCode());
        query.setParameter("firstName", employee.getFirstName());
        query.setParameter("secondName", employee.getSecondName());
        query.setParameter("middleName", employee.getMiddleName());
        query.setParameter("position", employee.getPosition());
        return query.getResultList();
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
