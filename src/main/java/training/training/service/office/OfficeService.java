package training.training.service.office;

import org.springframework.validation.annotation.Validated;
import training.training.model.Office;
import training.training.view.OfficeView;
import training.training.view.ResultView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис
 */
@Validated
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
     *
     * @param view
     * @param orgId
     * @return {@List<Office>}
     */
    List<OfficeView> getOfficeByOrg(OfficeView view, Integer orgId) throws Exception;

    /**
     * Добавить новый офис
     *
     *
     * @return {@ResultView}
     * @param view
     */

    ResultView addOffice(@Valid OfficeView view) throws Exception;

    /**
     * Изменение данных офиса
     *
     * @return {@SResultView}
     * @param view
     */
    ResultView updateOffice(@Valid OfficeView view) throws Exception;
}
