package com.esl.demo.entity;

import com.esl.demo.dto.ESLDto;
import com.esl.demo.entity.compositeKeys.LinkId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "esls")
public class ESLEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String size;

    @Column
    private Boolean deleted = false;

    @Column
    @ElementCollection
    private Set<LinkId> eslLinks = new HashSet<>();

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

    public Set<LinkId> getEslLinks() {
        return eslLinks;
    }

    public void setEslLinks(Set<LinkId> eslLinks) {
        this.eslLinks = eslLinks;
    }

    public ESLDto convertToDto() {

        ESLDto returnDto = new ESLDto();

        returnDto.setId(this.id);

        returnDto.setEslLinks(this.eslLinks);

        returnDto.setDeleted(this.deleted);

        returnDto.setSize(this.size);

        return returnDto;
    }

}
