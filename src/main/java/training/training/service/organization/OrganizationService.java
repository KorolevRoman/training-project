package training.training.service.organization;

import org.springframework.validation.annotation.Validated;
import training.training.view.OrganizationView;

import java.util.List;

/**
 * Сервис
 */
public interface OrganizationService {
    /**
     * Получить список организаций
     *
     * @return {@Organization}
     */
    List<OrganizationView> organizations(String name);

    /**
     * Получить организацию по id
     *
     * @return {@Organization}
     * @param id
     */
    OrganizationView getOrganization(Integer id) throws Exception;

    /**
     * Добавить новую организацию
     *
     *
     * @return {@String}
     * @param view
     */
    String addOrganization(OrganizationView view) throws Exception;
}
