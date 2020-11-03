package com.esl.demo.dto;

import com.esl.demo.entity.OutletEntity;

import javax.validation.constraints.NotNull;

public class OutletDto {

    private Long id;

    @NotNull(message = "Outlet name can't be null.")
    private String name;

    @NotNull(message = "Outlet deleted status can't be null.")
    private Boolean deleted;

    @NotNull(message = "Outlet code can't be null.")
    private String code;

    public OutletDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OutletEntity convertToEntity() {

        OutletEntity returnEntity = new OutletEntity();

        returnEntity.setId(this.id);
        returnEntity.setName(this.name);
        returnEntity.setDeleted(this.deleted);
        returnEntity.setCode(this.code);

        return returnEntity;
    }
}
