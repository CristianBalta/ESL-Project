package com.esl.demo.dto;

import com.esl.demo.entity.ESLLinkEntity;
import com.esl.demo.entity.compositeKeys.ESLLinkId;

public class ESLLinkDto {

    private Long eslId;

    private Long productId;

    private Long outletId;

    private Boolean deleted;

    public ESLLinkDto() {
    }

    public Long getEslId() {
        return eslId;
    }

    public void setEslId(Long eslId) {
        this.eslId = eslId;
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

    public ESLLinkEntity convertToEntity() {

        ESLLinkEntity returnEntity = new ESLLinkEntity();
        returnEntity.setEslLinkId(new ESLLinkId(this.eslId, this.productId, this.outletId));
        returnEntity.setDeleted(this.deleted);

        return returnEntity;
    }
}
