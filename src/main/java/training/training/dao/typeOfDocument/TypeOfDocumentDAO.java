package training.training.dao.typeOfDocument;

import training.training.model.TypeOfDocument;

public interface TypeOfDocumentDAO {
    /**
     * получить тип документа удостоверяющего личность по коду
     * @param code - код документа удостоверяющего личность
     * @return
     */
    TypeOfDocument loadByCode(Integer code);
}
