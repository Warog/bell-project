package ru.bellintegrator.training.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

@ApiModel(description = "Клиент")
public class ClientView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @NotEmpty
    @ApiModelProperty(value = "Версия", hidden = true, example = "1")
    public String version;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String name;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Должность", example = "Артист")
    public String post;

    @Size(max = 20)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Телефон", example = "31231232")
    public String phone;

    @Size(max = 10)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "идентификатор гражданства", example = "10")
    public String citizenship_id;

    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Статус", example = "TRUE")
    public Boolean isIdentified;

    @Override
    public String toString() {
            return "{id:" + id + ";name:" + name + ";secondName:" + secondName + ";middleName:" + middleName + ";post:" + post + ";phone:" + phone + ";citizenship_id:" + citizenship_id + ";isActive:" + isIdentified + "}";
        }
}
