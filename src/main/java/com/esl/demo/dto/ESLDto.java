package com.esl.demo.dto;

import com.esl.demo.entity.ESLEntity;
import com.esl.demo.entity.compositeKeys.LinkId;

import java.util.HashSet;
import java.util.Set;

public class ESLDto {

    private Long id;

    private String size;

    private Boolean deleted = false;

    private Set<LinkId> eslLinks = new HashSet<>();

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

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Set<LinkId> getEslLinks() {
        return eslLinks;
    }

    public void setEslLinks(Set<LinkId> eslLinks) {
        this.eslLinks = eslLinks;
    }

    public ESLEntity convertToEntity() {

        ESLEntity returnEntity = new ESLEntity();

        returnEntity.setId(this.id);

        returnEntity.setEslLinks(this.eslLinks);

        returnEntity.setDeleted(this.deleted);

        returnEntity.setSize(this.size);

        return returnEntity;
    }
}
