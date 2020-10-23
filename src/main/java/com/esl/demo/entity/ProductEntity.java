package com.esl.demo.entity;

import com.esl.demo.dto.ProductDto;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Boolean deleted;

    public ProductEntity() {
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

    public ProductDto convertToDto() {

        ProductDto returnDto = new ProductDto();

        returnDto.setId(this.id);
        returnDto.setName(this.name);
        returnDto.setDeleted(this.deleted);
        return returnDto;
    }
}
