package com.esl.demo.entity;

import com.esl.demo.dto.ProductDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name can't be null.")
    @Column
    private String name;

    @NotNull(message = "Product deleted status can't be null.")
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
