package com.esl.demo.entity.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinkId implements Serializable {

    @Column(name = "outlet_id")
    Long outletId;

    @Column(name = "product_id")
    Long productId;

    public LinkId() {
    }

    public LinkId(Long outletId, Long productId) {
        this.outletId = outletId;
        this.productId = productId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkId linkId = (LinkId) o;
        return Objects.equals(outletId, linkId.outletId) &&
                Objects.equals(productId, linkId.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outletId, productId);
    }
}
