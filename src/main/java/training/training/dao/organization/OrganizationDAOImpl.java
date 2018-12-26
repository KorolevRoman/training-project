package training.training.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.training.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public OrganizationDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Organization loadById(Integer id) {
        return em.find(Organization.class, id);
    }

    @Override
    public Organization loadByNameAndInn(String name, String inn, Boolean isActive) {
        String queryString = String.format("SELECT org FROM %s org WHERE org.name = :name AND org.inn = :inn AND org.isActive = :isActive",
                Organization.class.getSimpleName());
        TypedQuery<Organization> query = em.createQuery(queryString, Organization.class);
        query.setParameter("name", name);
        query.setParameter("inn", inn);
        query.setParameter("isActive", isActive);
        return query.getSingleResult();
    }

    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

    @Override
    public void update(Organization organization) {
        em.merge(organization);
        em.close();
    }
}
