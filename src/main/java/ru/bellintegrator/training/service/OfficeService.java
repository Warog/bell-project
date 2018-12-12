package ru.bellintegrator.training.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.training.view.OfficeView;
import javax.validation.Valid;
import java.util.List;

/**
 * Сервис
 */
@Validated
public interface OfficeService {

    /**
     * Добавить новый офис в БД
     *
     * @param office
     */
    void add(@Valid OfficeView office);

    /**
     * Получить список людей
     *
     * @return {@Offices}
     */
    List<OfficeView> offices();
}