package ru.bellintegrator.training.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.training.view.ClientView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис
 */
@Validated
public interface ClientService {

    /**
     * Добавить нового клиента в БД
     *
     * @param client
     */
    void add(@Valid ClientView client);

    /**
     * Получить список людей
     *
     * @return {@Client}
     */
    List<ClientView> clients();
}