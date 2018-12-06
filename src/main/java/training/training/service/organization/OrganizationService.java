package training.training.service.organization;

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
    List<OrganizationView> organizations();

    OrganizationView organization(Integer id);
}
