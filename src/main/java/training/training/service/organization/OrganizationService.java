package training.training.service.organization;

import training.training.model.Organization;
import training.training.view.OrganizationView;

import java.util.List;

/**
 * Сервис
 */
public interface OrganizationService {
    /**
     * Получить список людей
     *
     * @return {@Organization}
     */
    List<OrganizationView> organizations();
}
