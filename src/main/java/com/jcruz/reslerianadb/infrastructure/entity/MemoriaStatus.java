package com.jcruz.reslerianadb.infrastructure.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "MEMORIA_STATUS")
public class MemoriaStatus extends BaseEntity implements Serializable {

    @Id
    @Column(name = "memoria_id")
    private Integer id;

    @OneToOne
    @MapsId("id")
    @JoinColumn(name = "memoria_id", referencedColumnName = "id")
    private Memoria memoria;

    @ManyToOne
    @JoinColumn(name = "attack", referencedColumnName = "id", insertable = false, updatable = false)
    private MemoriaGrowthKey attack;

    @ManyToOne
    @JoinColumn(name = "defense", referencedColumnName = "id", insertable = false, updatable = false)
    private MemoriaGrowthKey defense;

    @ManyToOne
    @JoinColumn(name = "hp", referencedColumnName = "id", insertable = false, updatable = false)
    private MemoriaGrowthKey hp;

    @ManyToOne
    @JoinColumn(name = "magic", referencedColumnName = "id", insertable = false, updatable = false)
    private MemoriaGrowthKey magic;

    @ManyToOne
    @JoinColumn(name = "mental", referencedColumnName = "id", insertable = false, updatable = false)
    private MemoriaGrowthKey mental;

    @ManyToOne
    @JoinColumn(name = "speed", referencedColumnName = "id", insertable = false, updatable = false)
    private MemoriaGrowthKey speed;

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    public MemoriaGrowthKey getAttack() {
        return attack;
    }

    public void setAttack(MemoriaGrowthKey attack) {
        this.attack = attack;
    }

    public MemoriaGrowthKey getDefense() {
        return defense;
    }

    public void setDefense(MemoriaGrowthKey defense) {
        this.defense = defense;
    }

    public MemoriaGrowthKey getHp() {
        return hp;
    }

    public void setHp(MemoriaGrowthKey hp) {
        this.hp = hp;
    }

    public MemoriaGrowthKey getMagic() {
        return magic;
    }

    public void setMagic(MemoriaGrowthKey magic) {
        this.magic = magic;
    }

    public MemoriaGrowthKey getMental() {
        return mental;
    }

    public void setMental(MemoriaGrowthKey mental) {
        this.mental = mental;
    }

    public MemoriaGrowthKey getSpeed() {
        return speed;
    }

    public void setSpeed(MemoriaGrowthKey speed) {
        this.speed = speed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
