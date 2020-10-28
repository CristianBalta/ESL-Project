package com.esl.demo.entity;

import com.esl.demo.dto.ESLLinkDto;
import com.esl.demo.entity.compositeKeys.ESLLinkId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "esl_links")
public class ESLLinkEntity {

    @EmbeddedId
    private ESLLinkId eslLinkId = new ESLLinkId();

    @NotNull(message = "ESL Link deleted status can't be null.")
    @Column
    private boolean deleted;

    @ManyToOne
    @MapsId("eslId")
    @JoinColumn(name = "esl_id")
    private ESLEntity esl;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @MapsId("outletId")
    @JoinColumn(name = "outlet_id")
    private OutletEntity outlet;

    public ESLLinkEntity() {
    }

    public ESLLinkId getEslLinkId() {
        return eslLinkId;
    }

    public void setEslLinkId(ESLLinkId eslLinkId) {
        this.eslLinkId = eslLinkId;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public ESLEntity getEsl() {
        return esl;
    }

    public void setEsl(ESLEntity esl) {
        this.esl = esl;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OutletEntity getOutlet() {
        return outlet;
    }

    public void setOutlet(OutletEntity outlet) {
        this.outlet = outlet;
    }

    public ESLLinkDto convertToDto() {

        ESLLinkDto returnDto = new ESLLinkDto();

        returnDto.setEslId(this.eslLinkId.getEslId());
        returnDto.setProductId(this.eslLinkId.getProductId());
        returnDto.setOutletId(this.eslLinkId.getOutletId());
        returnDto.setDeleted(this.deleted);

        return returnDto;
    }
}
