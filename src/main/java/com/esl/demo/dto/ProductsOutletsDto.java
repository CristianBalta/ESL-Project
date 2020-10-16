package com.esl.demo.dto;

import com.esl.demo.entity.ProductsOutletsEntity;
import com.esl.demo.entity.compositeKeys.LinkId;

public class ProductsOutletsDto {

    private Long productId;

    private Long outletId;

    private Boolean deleted = false;

    private Long price;

    public ProductsOutletsDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOutletId() {
        return outletId;
    }

    public void setOutletId(Long outletId) {
        this.outletId = outletId;
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

        returnEntity.setProductsOutletsId(new LinkId(this.productId, this.outletId));

        returnEntity.setPrice(this.price);

        returnEntity.setDeleted(this.deleted);

        return returnEntity;
    }

}
