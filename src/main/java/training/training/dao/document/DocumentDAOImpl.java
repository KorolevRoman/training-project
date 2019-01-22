package training.training.dao.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.training.model.Document;

import javax.persistence.EntityManager;

@Repository
public class DocumentDAOImpl implements DocumentDAO {
    private EntityManager em;

    @Autowired
    public DocumentDAOImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Получить документы по id сотрудника
     *
     * @param id
     * @return
     */
    @Override
    public Document LoadByEmployeeId(Integer id) {
        return null;
    }

    /**
     * Сохранить документ в БД
     *
     * @param document
     */
    @Override
    public void save(Document document) {
        em.persist(document);
    }

    @Override
    public void update(Document document) {
        em.merge(document);
    }
}
