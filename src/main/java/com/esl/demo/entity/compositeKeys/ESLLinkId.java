package com.esl.demo.entity.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ESLLinkId implements Serializable {

    @Column(name = "esl_id")
    Long eslId;

    @Column(name = "product_id")
    Long productId;

    @Column(name = "outlet_id")
    Long outletId;

    public ESLLinkId() {
    }

    public ESLLinkId(Long eslId, Long productId, Long outletId) {
        this.eslId = eslId;
        this.productId = productId;
        this.outletId = outletId;
    }

    public Long getOutletId() {
        return outletId;
    }

    public Long getEslId() {
        return eslId;
    }

    public void setEslId(Long eslId) {
        this.eslId = eslId;
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
        ESLLinkId eslLinkId = (ESLLinkId) o;

        return Objects.equals(eslId, eslLinkId.eslId) &&
                Objects.equals(productId, eslLinkId.productId) &&
                Objects.equals(outletId, eslLinkId.outletId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(eslId, productId, outletId);
    }
}
