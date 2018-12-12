package ru.bellintegrator.training.dao.office;

import ru.bellintegrator.training.model.Office;

import java.util.List;

/**
 * DAO для работы с Office
 */
public interface OfficeDao {
    /**
     * Получить все объекты Office
     *
     * @return
     */
    List<Office> allWithId(Long id);

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return
     */
    List<Office> allWithOrgId(Long id);

    /**
     * обновить office
     *
     * @param office
     */
    void update(Office office) throws Exception;

    /**
     * Сохранить office
     *
     * @param office
     */
    void save(Office office);
}
