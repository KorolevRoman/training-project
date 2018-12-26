package training.training.dao.citizenship;

import training.training.model.Citizenship;

/**
 * ДАО для работы с Citizenship
 */
public interface CitizenshipDAO {
    /**
     * Получить гражданство по коду
     *
     * @param code
     * @return @Citizenship
     */
    Citizenship loadByCode(Integer code);
}
