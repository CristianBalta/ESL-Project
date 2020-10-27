package com.esl.demo.dto;

import com.esl.demo.entity.ESLEntity;

public class ESLDto {

    private Long id;

    private String size;

    private Boolean deleted;

    public ESLDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String name) {
        this.size = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public ESLEntity convertToEntity() {

        ESLEntity returnEntity = new ESLEntity();

        returnEntity.setId(this.id);
        returnEntity.setSize(this.size);
        returnEntity.setDeleted(this.deleted);

        return returnEntity;
    }
}
