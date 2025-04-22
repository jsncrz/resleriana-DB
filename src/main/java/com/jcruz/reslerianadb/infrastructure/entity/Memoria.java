package com.jcruz.reslerianadb.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.Filter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "memoria")
public class Memoria extends BaseEntityWithId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "memoria_name", referencedColumnName = "id")
    private TranslationKey name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "memoria_description", referencedColumnName = "id")
    private TranslationKey description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(nullable = false, name = "rarity")
    private int rarity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "memoria_ability",
            joinColumns = @JoinColumn(name = "memoria_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id"))
    private Set<Ability> memoriaAbility;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="memoria_id", referencedColumnName="id")
    private Set<MemoriaRole> roles;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="memoria_id", referencedColumnName="id")
    private Set<MemoriaAttribute> attributes;

    public TranslationKey getName() {
        return name;
    }

    public void setName(TranslationKey name) {
        this.name = name;
    }

    public TranslationKey getDescription() {
        return description;
    }

    public void setDescription(TranslationKey description) {
        this.description = description;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
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
