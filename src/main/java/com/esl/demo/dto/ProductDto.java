package com.esl.demo.dto;

import com.esl.demo.entity.ProductEntity;
import javax.validation.constraints.NotNull;

public class ProductDto {

    private Long id;

    @NotNull(message = "Product name can't be null.")
    private String name;

    @NotNull(message = "Product deleted status can't be null.")
    private Boolean deleted;

    public ProductDto() {
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

    public ProductEntity convertToEntity() {

        ProductEntity returnEntity = new ProductEntity();

        returnEntity.setId(this.id);
        returnEntity.setName(this.name);
        returnEntity.setDeleted(this.deleted);

        return returnEntity;
    }
}
