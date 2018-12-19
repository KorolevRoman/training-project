package training.training.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.training.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {
    private EntityManager em;

    @Autowired
    public OrganizationDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = em.createQuery("SELECT org FROM Organization org", Organization.class);
        return query.getResultList();
    }

    @Override
    public Organization loadById(Integer id) {
        return em.find(Organization.class, id);
    }

    @Override
    public Organization loadByNameAndInn(String name, String inn) {
        String queryString = String.format("SELECT org FROM Organization org WHERE org.name = :name AND org.inn = :inn AND org.isActive = true", name, inn);
        TypedQuery<Organization> query = em.createQuery(queryString, Organization.class);
        query.setParameter("name", name);
        query.setParameter("inn", inn);
        return query.getSingleResult();
    }

    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }
}
