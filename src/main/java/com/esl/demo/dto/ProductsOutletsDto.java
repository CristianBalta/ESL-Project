package com.esl.demo.dto;

import com.esl.demo.entity.ProductsOutletsEntity;
import com.esl.demo.entity.compositeKeys.ProductsOutletsLinkId;
import javax.validation.constraints.NotNull;

public class ProductsOutletsDto {

    @NotNull(message = "ProductsOutlets Link productId can't be null.")
    private Long productId;

    @NotNull(message = "ProductsOutlets Link outletId can't be null.")
    private Long outletId;

    @NotNull(message = "ProductsOutlets deleted status can't be null.")
    private Boolean deleted;

    @NotNull(message = "ProductsOutlets price can't be null.")
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

        returnEntity.setProductsOutletsId(new ProductsOutletsLinkId(this.productId, this.outletId));
        returnEntity.setPrice(this.price);
        returnEntity.setDeleted(this.deleted);

        return returnEntity;
    }
}
