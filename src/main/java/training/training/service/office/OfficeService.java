package training.training.service.office;

import training.training.model.Office;
import training.training.view.OfficeView;
import training.training.view.ResultView;

import java.util.List;

/**
 * Сервис
 */
public interface OfficeService {
    /**
     * Получить офис по id
     *
     * @param id
     * @return {@Office}
     */
    OfficeView getOfficeById(Integer id) throws Exception;

    /**
     *  Получить список офисов организации
     * @param orgId
     * @return {@List<Office>}
     */
    List<OfficeView> getOfficeByOrg(Integer orgId) throws Exception;

    /**
     * Добавить новый офис
     *
     *
     * @return {@ResultView}
     * @param view
     */

    ResultView addOffice(OfficeView view) throws Exception;

    /**
     * Изменение данных офиса
     *
     * @return {@SResultView}
     * @param view
     */
    ResultView updateOffice(OfficeView view) throws Exception;
}
