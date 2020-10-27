package com.esl.demo.dto;

import com.esl.demo.entity.ESLLinkEntity;
import com.esl.demo.entity.compositeKeys.ESLLinkId;

import javax.validation.constraints.NotNull;

public class ESLLinkDto {

    @NotNull(message = "ESL Link eslId can't be null.")
    private Long eslId;

    @NotNull(message = "ESL Link productId can't be null.")
    private Long productId;

    @NotNull(message = "ESL Link outletId can't be null.")
    private Long outletId;

    @NotNull(message = "ESL Link deleted status can't be null.")
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
