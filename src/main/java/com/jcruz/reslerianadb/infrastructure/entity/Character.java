package com.jcruz.reslerianadb.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "`CHARACTER`")
public class Character extends BaseEntityWithExtId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NAME", referencedColumnName = "TL_ID")
    private Translation name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ANOTHER_NAME", referencedColumnName = "TL_ID")
    private Translation anotherName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "FULL_NAME", referencedColumnName = "TL_ID")
    private Translation fullName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ACQUISITION_TEXT", referencedColumnName = "TL_ID")
    private Translation acquisitionText;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DESCRIPTION", referencedColumnName = "TL_ID")
    private Translation description;

    @Column(nullable = false, name = "IS_ALCHEMIST")
    private boolean alchemist;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(nullable = false, name = "INITIAL_RARITY")
    private int initialRarity;

    @Column(nullable = false, name = "ROLE")
    private String role;

    @Column(nullable = false, name = "ATTACK_ATTRIBUTE")
    private String attackAttribute;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "CHARACTER_TAG",
            joinColumns = @JoinColumn(name = "CHARACTER_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
    private Set<Tag> characterTags;

    public Translation getName() {
        return name;
    }

    public void setName(Translation name) {
        this.name = name;
    }

    public Translation getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(Translation anotherName) {
        this.anotherName = anotherName;
    }

    public Translation getFullName() {
        return fullName;
    }

    public void setFullName(Translation fullName) {
        this.fullName = fullName;
    }

    public Translation getAcquisitionText() {
        return acquisitionText;
    }

    public void setAcquisitionText(Translation acquisitionText) {
        this.acquisitionText = acquisitionText;
    }

    public Translation getDescription() {
        return description;
    }

    public void setDescription(Translation description) {
        this.description = description;
    }

    public boolean isAlchemist() {
        return alchemist;
    }

    public void setAlchemist(boolean alchemist) {
        this.alchemist = alchemist;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getInitialRarity() {
        return initialRarity;
    }

    public void setInitialRarity(int initialRarity) {
        this.initialRarity = initialRarity;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAttackAttribute() {
        return attackAttribute;
    }

    public void setAttackAttribute(String attackAttribute) {
        this.attackAttribute = attackAttribute;
    }

    public Set<Tag> getCharacterTags() {
        return characterTags;
    }

    public void setCharacterTags(Set<Tag> characterTags) {
        this.characterTags = characterTags;
    }
}
