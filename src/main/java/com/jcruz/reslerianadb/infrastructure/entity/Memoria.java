package com.jcruz.reslerianadb.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.Filter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "MEMORIA")
public class Memoria extends BaseEntityWithExtId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "NAME", referencedColumnName = "TL_ID")
    @Filter(
            name="translationByLanguage",
            condition = "LANGUAGE = :language"
    )
    private Translation name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DESCRIPTION", referencedColumnName = "TL_ID")
    @Filter(
            name="translationByLanguage",
            condition = "LANGUAGE = :language"
    )
    private Translation description;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(nullable = false, name = "RARITY")
    private int rarity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "MEMORIA_ABILITY",
            joinColumns = @JoinColumn(name = "MEMORIA_ID"),
            inverseJoinColumns = @JoinColumn(name = "ABILITY_ID"))
    private Set<Ability> memoriaAbility;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="MEMORIA_ID", referencedColumnName="EXT_ID")
    private Set<MemoriaRole> roles;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="MEMORIA_ID", referencedColumnName="EXT_ID")
    private Set<MemoriaAttribute> attributes;

    public Translation getName() {
        return name;
    }

    public void setName(Translation name) {
        this.name = name;
    }

    public Translation getDescription() {
        return description;
    }

    public void setDescription(Translation description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public Set<Ability> getMemoriaAbility() {
        return memoriaAbility;
    }

    public void setMemoriaAbility(Set<Ability> memoriaAbility) {
        this.memoriaAbility = memoriaAbility;
    }

    public Set<MemoriaRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<MemoriaRole> roles) {
        this.roles = roles;
    }

    public Set<MemoriaAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<MemoriaAttribute> attributes) {
        this.attributes = attributes;
    }
}
