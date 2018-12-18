package ru.bellintegrator.training.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.training.model.Client;
import ru.bellintegrator.training.view.ClientView;

import javax.validation.Valid;

/**
 * Сервис
 */
@Validated
@Service
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
    ClientView clientView();
}