package com.esl.demo.entity;

import com.esl.demo.dto.ProductsOutletsDto;
import com.esl.demo.entity.compositeKeys.ProductsOutletsLinkId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "products_outlets")
public class ProductsOutletsEntity {

    @EmbeddedId
    private ProductsOutletsLinkId productsOutletsId = new ProductsOutletsLinkId();

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @MapsId("outletId")
    @JoinColumn(name = "outlet_id")
    private OutletEntity outlet;

    @Column
    private Long price;

    @Column
    private Boolean deleted;

    public ProductsOutletsEntity() {
    }

    public ProductsOutletsLinkId getProductsOutletsId() {
        return productsOutletsId;
    }

    public void setProductsOutletsId(ProductsOutletsLinkId productsOutletsId) {
        this.productsOutletsId = productsOutletsId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public ProductsOutletsEntity setProduct(ProductEntity product) {
        this.product = product;
        return this;
    }

    public OutletEntity getOutlet() {
        return outlet;
    }

    public ProductsOutletsEntity setOutlet(OutletEntity outlet) {
        this.outlet = outlet;
        return this;
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
