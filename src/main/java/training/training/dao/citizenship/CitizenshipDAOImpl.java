package training.training.dao.citizenship;

import org.springframework.stereotype.Repository;
import training.training.model.Citizenship;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CitizenshipDAOImpl implements CitizenshipDAO {
    @PersistenceContext
    private EntityManager em;

    public CitizenshipDAOImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Получить гражданство по коду
     *
     * @param code
     * @return @Citizenship
     */
    @Override
    public Citizenship loadByCode(Integer code) {
        return em.find(Citizenship.class, code);
    }
}
