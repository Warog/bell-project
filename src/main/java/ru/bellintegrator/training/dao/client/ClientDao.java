package ru.bellintegrator.training.dao.client;

import ru.bellintegrator.training.model.Client;
import java.util.List;

/**
 * DAO для работы с Office
 */
public interface ClientDao {
    /**
     * Получить все объекты Client
     *
     * @return
     */
    List<Client> allWithId(Long id);

    /**
     * Получить Client по идентификатору
     *
     * @param id
     * @return
     */
    List<Client> allWithOfficeId(Long id);

    /**
     * обновить client
     *
     * @param client
     */
    void update(Client client) throws Exception;

    /**
     * Сохранить client
     *
     * @param client
     */
    void save(Client client);
}
