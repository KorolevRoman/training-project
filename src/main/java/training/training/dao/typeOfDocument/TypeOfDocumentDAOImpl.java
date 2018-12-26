package training.training.dao.typeOfDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.training.model.TypeOfDocument;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TypeOfDocumentDAOImpl implements TypeOfDocumentDAO {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public TypeOfDocumentDAOImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * получить тип документа удостоверяющего личнось по коду
     *
     * @param code
     * @return
     */
    @Override
    public TypeOfDocument loadByCode(Integer code) {
        return em.find(TypeOfDocument.class, code);
    }
}
