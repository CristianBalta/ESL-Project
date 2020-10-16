package com.esl.demo.entity;

import com.esl.demo.dto.ProductsOutletsDto;
import com.esl.demo.entity.compositeKeys.LinkId;

import javax.persistence.*;

@Entity
@Table(name = "products_outlets")
public class ProductsOutletsEntity {

    @EmbeddedId
    @Column
    private LinkId productsOutletsId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("productId")
    private ProductEntity productEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("outletId")
    private OutletEntity outletEntity;

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

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public OutletEntity getOutletEntity() {
        return outletEntity;
    }

    public void setOutletEntity(OutletEntity outletEntity) {
        this.outletEntity = outletEntity;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public ProductsOutletsDto convertToDto() {

        ProductsOutletsDto returnDto = new ProductsOutletsDto();

        returnDto.setProductId(this.productsOutletsId.getProductId());

        returnDto.setOutletId(this.productsOutletsId.getOutletId());

        returnDto.setDeleted(this.deleted);

        returnDto.setPrice(this.price);

        return returnDto;
    }

}
