package training.training.dao.organization;

import training.training.model.Organization;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDAO {
    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Integer id);

    /**
     * Получить Organization соответствующую фильтру
     *
     * @param name
     * @param inn
     * @param isActive
     * @return @Organization
     */
    Organization loadByNameAndInn(String name, String inn, Boolean isActive);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(Organization organization);


    /**
     * Обновить Organization
     *
     * @param organization
     */
    void update(Organization organization);
}
