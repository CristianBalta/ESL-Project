package com.esl.demo.dto;

import com.esl.demo.entity.OutletEntity;

public class OutletDto {

    private Long id;

    private String name;

    private Boolean deleted = false;

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
