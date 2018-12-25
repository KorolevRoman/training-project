package training.training.service.organization;

import org.springframework.validation.annotation.Validated;
import training.training.view.OrganizationView;
import training.training.view.ResultView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис
 */
@Validated
public interface OrganizationService {
    /**
     * Получить список организаций
     *
     * @return {@Organization}
     */
   OrganizationView getOrganization(OrganizationView name) throws Exception;

    /**
     * Получить организацию по id
     *
     * @return {@Organization}
     * @param id
     */
    OrganizationView getOrganizationById(Integer id) throws Exception;

    /**
     * Добавить новую организацию
     *
     *
     * @return {@String}
     * @param view
     */
    ResultView addOrganization(@Valid OrganizationView view) throws Exception;

    /**
     * Изменение данных организации
     *
     * @return {@String}
     * @param view
     */
    ResultView updateOrganization(@Valid OrganizationView view) throws Exception;

}
