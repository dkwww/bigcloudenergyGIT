package com.yidu.domain;

import java.util.Date;

public class Spec {
    private String specId;

    private String specName;

    private String specTrait;

    private String specPurpose;

    private String specSize;

    private String specUse;

    private String specEffect;

    private String specTaboo;

    private String specNotice;

    private String specInteract;

    private String specDepot;

    private String specPack;

    private String specValidity;

    private String isva;

    private Date optime;

    private String oper;

    private String sort;

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public String getSpecTrait() {
        return specTrait;
    }

    public void setSpecTrait(String specTrait) {
        this.specTrait = specTrait == null ? null : specTrait.trim();
    }

    public String getSpecPurpose() {
        return specPurpose;
    }

    public void setSpecPurpose(String specPurpose) {
        this.specPurpose = specPurpose == null ? null : specPurpose.trim();
    }

    public String getSpecSize() {
        return specSize;
    }

    public void setSpecSize(String specSize) {
        this.specSize = specSize == null ? null : specSize.trim();
    }

    public String getSpecUse() {
        return specUse;
    }

    public void setSpecUse(String specUse) {
        this.specUse = specUse == null ? null : specUse.trim();
    }

    public String getSpecEffect() {
        return specEffect;
    }

    public void setSpecEffect(String specEffect) {
        this.specEffect = specEffect == null ? null : specEffect.trim();
    }

    public String getSpecTaboo() {
        return specTaboo;
    }

    public void setSpecTaboo(String specTaboo) {
        this.specTaboo = specTaboo == null ? null : specTaboo.trim();
    }

    public String getSpecNotice() {
        return specNotice;
    }

    public void setSpecNotice(String specNotice) {
        this.specNotice = specNotice == null ? null : specNotice.trim();
    }

    public String getSpecInteract() {
        return specInteract;
    }

    public void setSpecInteract(String specInteract) {
        this.specInteract = specInteract == null ? null : specInteract.trim();
    }

    public String getSpecDepot() {
        return specDepot;
    }

    public void setSpecDepot(String specDepot) {
        this.specDepot = specDepot == null ? null : specDepot.trim();
    }

    public String getSpecPack() {
        return specPack;
    }

    public void setSpecPack(String specPack) {
        this.specPack = specPack == null ? null : specPack.trim();
    }

    public String getSpecValidity() {
        return specValidity;
    }

    public void setSpecValidity(String specValidity) {
        this.specValidity = specValidity == null ? null : specValidity.trim();
    }

    public String getIsva() {
        return isva;
    }

    public void setIsva(String isva) {
        this.isva = isva == null ? null : isva.trim();
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper == null ? null : oper.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }
}