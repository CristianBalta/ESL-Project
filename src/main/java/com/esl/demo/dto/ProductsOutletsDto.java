package com.esl.demo.dto;

import com.esl.demo.entity.ProductsOutletsEntity;
import com.esl.demo.entity.compositeKeys.LinkId;

public class ProductsOutletsDto {

    private LinkId productsOutletsId;

    private Boolean deleted = false;

    private Long price;

    public ProductsOutletsDto() {
    }

    public LinkId getProductsOutletsId() {
        return productsOutletsId;
    }

    public void setProductsOutletsId(LinkId productsOutletsId) {
        this.productsOutletsId = productsOutletsId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public ProductsOutletsEntity convertToEntity() {

        ProductsOutletsEntity returnEntity = new ProductsOutletsEntity();

        returnEntity.setProductsOutletsId(this.productsOutletsId);

        returnEntity.setPrice(this.price);

        returnEntity.setDeleted(this.deleted);

        return returnEntity;
    }

}
