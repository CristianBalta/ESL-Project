package com.esl.demo.entity;

import com.esl.demo.dto.ESLDto;

import javax.persistence.*;

@Entity
@Table(name = "esls")
public class ESLEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String size;

    @Column
    private Boolean deleted;

    public ESLEntity() {
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

    public ESLDto convertToDto() {

        ESLDto returnDto = new ESLDto();

        returnDto.setId(this.id);
        returnDto.setSize(this.size);
        returnDto.setDeleted(this.deleted);
        return returnDto;
    }
}
