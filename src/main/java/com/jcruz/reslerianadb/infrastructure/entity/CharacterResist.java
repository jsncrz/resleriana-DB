package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "\"CHARACTER_RESIST\"")
public class CharacterResist extends BaseEntityWithExtId implements Serializable {

    @Column(nullable = false, name = "FIRE")
    private int fire;

    @Column(nullable = false, name = "ICE")
    private int ice;

    @Column(nullable = false, name = "AIR")
    private int air;

    @Column(nullable = false, name = "BOLT")
    private int bolt;

    @Column(nullable = false, name = "STRIKE")
    private int strike;

    @Column(nullable = false, name = "STAB")
    private int stab;

    @Column(nullable = false, name = "SLASH")
    private int slash;

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public int getIce() {
        return ice;
    }

    public void setIce(int ice) {
        this.ice = ice;
    }

    public int getAir() {
        return air;
    }

    public void setAir(int air) {
        this.air = air;
    }

    public int getBolt() {
        return bolt;
    }

    public void setBolt(int bolt) {
        this.bolt = bolt;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getStab() {
        return stab;
    }

    public void setStab(int stab) {
        this.stab = stab;
    }

    public int getSlash() {
        return slash;
    }

    public void setSlash(int slash) {
        this.slash = slash;
    }
}
