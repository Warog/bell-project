package ru.bellintegrator.training.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

@ApiModel(description = "Офис")
public class OfficeView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название офиса", example = "Lays")
    public String name;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Адрес", example = "Тверская ул., 13")
    public String address;

    @Size(max = 20)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Телефон", example = "31231232")
    public String phone;

    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Статус", example = "TRUE")
    public Boolean isActive;

    @NotEmpty
    @ApiModelProperty(value = "Идентификатор организации", example = "1")
    public String orgId;

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";phone:" + phone + ";isActive:" + isActive + ";orgId:" + orgId + "}";
    }
}
