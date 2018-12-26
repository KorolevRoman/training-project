package training.training.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.training.model.Office;
import training.training.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OfficeDAOImpl implements OfficeDAO {
    private EntityManager em;

    @Autowired
    public OfficeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Office> loadByOrgId(Office office) {
        String queryString = String.format("SELECT off FROM %s off JOIN off.organization org ON org.id = :org" +
                " WHERE off.name = :name OR off.phone = :phone OR off.isActive = :isActive", Office.class.getSimpleName());
        TypedQuery<Office> query = em.createQuery(queryString, Office.class);
        query.setParameter("org", office.getOrganization().getId());
        query.setParameter("name", office.getName());
        query.setParameter("phone", office.getPhone());
        query.setParameter("isActive", office.getIsActive());
        return query.getResultList();
    }

    @Override
    public Office loadById(Integer id) {
        return em.find(Office.class, id);
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }

    @Override
    public void update(Office office){
        em.merge(office);
    }
}
