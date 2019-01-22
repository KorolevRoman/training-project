package training.training.dao.document;

import training.training.model.Document;

/**
 * ДАО для работы с документом
 */
public interface DocumentDAO {

    /**
     *  Получить документы по id сотрудника
     *
     * @param id
     * @return
     */
    Document LoadByEmployeeId(Integer id);

    /**
     * Сохранить документ в БД
     * @param document
     */
    void save(Document document);

    /**
     * Обновить документ в БД
     *
     * @param document
     */
    void update(Document document);
}
