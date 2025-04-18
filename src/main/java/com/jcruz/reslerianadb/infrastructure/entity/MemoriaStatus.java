package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "MEMORIA_STATUS")
public class MemoriaStatus extends BaseEntity implements Serializable {

    @Id
    @Column(name = "MEMORIA_ID")
    private Integer id;

    @OneToOne
    @MapsId("memoriaId")
    @JoinColumn(name = "MEMORIA_ID", referencedColumnName = "EXT_ID")
    private Memoria memoria;

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

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
