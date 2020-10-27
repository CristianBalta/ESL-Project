package com.esl.demo.entity.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductsOutletsLinkId implements Serializable {

    @NotNull(message = "ProductsOutlets Link productId can't be null.")
    @Column(name = "product_id")
    Long productId;

    @NotNull(message = "ProductsOutlets Link outletId can't be null.")
    @Column(name = "outlet_id")
    Long outletId;

    public ProductsOutletsLinkId() {
    }

    public ProductsOutletsLinkId(Long outletId, Long productId) {
        this.productId = productId;
        this.outletId = outletId;

    }

    public Long getOutletId() {
        return outletId;
    }

    public void setOutletId(Long outletId) {
        this.outletId = outletId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsOutletsLinkId productsOutletsLinkId = (ProductsOutletsLinkId) o;

        return Objects.equals(productId, productsOutletsLinkId.productId) &&
                Objects.equals(outletId, productsOutletsLinkId.outletId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, outletId);
    }
}
