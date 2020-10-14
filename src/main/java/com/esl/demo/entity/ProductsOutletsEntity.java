package com.esl.demo.entity;

import com.esl.demo.dto.ProductsOutletsDto;
import com.esl.demo.entity.compositeKeys.LinkId;

import javax.persistence.*;

@Entity
@Table(name = "products_outlets")
public class ProductsOutletsEntity {

    @EmbeddedId
    private LinkId productsOutletsId;

    @Column
    private Long price;

    @Column
    private Boolean deleted = false;

    public ProductsOutletsEntity() {
    }

    public LinkId getProductsOutletsId() {
        return productsOutletsId;
    }

    public void setProductsOutletsId(LinkId productsOutletsId) {
        this.productsOutletsId = productsOutletsId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public ProductsOutletsDto convertToDto() {

        ProductsOutletsDto returnDto = new ProductsOutletsDto();

        returnDto.setProductsOutletsId(this.productsOutletsId);

        returnDto.setDeleted(this.deleted);

        returnDto.setPrice(this.price);

        return returnDto;
    }

}
