package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "\"CHARACTER_STATS\"")
public class CharacterStats extends BaseEntityWithExtId implements Serializable {

    @Column(nullable = false, name = "ATTACK")
    private int attack;

    @Column(nullable = false, name = "DEFENSE")
    private int defense;

    @Column(nullable = false, name = "HP")
    private int hp;

    @Column(nullable = false, name = "MAGIC")
    private int magic;

    @Column(nullable = false, name = "MENTAL")
    private int mental;

    @Column(nullable = false, name = "SPEED")
    private int speed;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
