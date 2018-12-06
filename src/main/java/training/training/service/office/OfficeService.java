package training.training.service.office;

import training.training.view.OfficeView;

import java.util.List;

/**
 * Сервис
 */
public interface OfficeService {
    /**
     * Получить список оффисов
     *
     * @return {@Office}
     */
    List<OfficeView> offices();

    /**
     * Получить оффис по id
     *
     * @return {@Office}
     */
    OfficeView office(Integer id);
}