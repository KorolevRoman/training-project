package training.training.dao.office;

import training.training.model.Office;

import java.util.List;

/**
 * DAO для работы с Office
 */
public interface OfficeDAO {
    /**
     * Получить все объекты office по одной organization
     *
     * @return
     */
    List<Office> loadByOrgId(Integer orgId);

    /**
     * Получить office по идентификатору
     *
     * @param id
     * @return Office
     */
    Office loadById(Integer id);

    /**
     * Сохранить office
     *
     * @param office
     */
    void save(Office office);

    /**
     *Обновить Office
     *
     * @param office
     */
    void update(Office office) throws Exception;
}
