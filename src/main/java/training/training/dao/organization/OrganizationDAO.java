package training.training.dao.organization;

import training.training.model.Organization;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDAO {
    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> all();

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Integer id);

    Organization loadByNameAndInn(String name, String inn);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(Organization organization);
}
