package com.jcruz.reslerianadb.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "character")
public class Character extends BaseEntityWithId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "character_name", referencedColumnName = "id")
    private TranslationKey name;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "another_name", referencedColumnName = "id")
    private TranslationKey anotherName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "full_name", referencedColumnName = "id")
    private TranslationKey fullName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "acquisition_text", referencedColumnName = "id")
    private TranslationKey acquisitionText;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "character_description", referencedColumnName = "id")
    private TranslationKey description;

    @Column(nullable = false, name = "is_alchemist")
    private boolean alchemist;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(nullable = false, name = "initial_rarity")
    private int initialRarity;

    @Column(nullable = false, name = "max_rarity")
    private int maxRarity;

    @Column(nullable = false, name = "character_role")
    private String role;

    @Column(nullable = false, name = "attack_attribute")
    private String attackAttribute;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "character_tag",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> characterTags;

    public TranslationKey getName() {
        return name;
    }

    public void setName(TranslationKey name) {
        this.name = name;
    }

    public TranslationKey getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(TranslationKey anotherName) {
        this.anotherName = anotherName;
    }

    public TranslationKey getFullName() {
        return fullName;
    }

    public void setFullName(TranslationKey fullName) {
        this.fullName = fullName;
    }

    public TranslationKey getAcquisitionText() {
        return acquisitionText;
    }

    public void setAcquisitionText(TranslationKey acquisitionText) {
        this.acquisitionText = acquisitionText;
    }

    public TranslationKey getDescription() {
        return description;
    }

    public void setDescription(TranslationKey description) {
        this.description = description;
    }

    public boolean isAlchemist() {
        return alchemist;
    }

    public void setAlchemist(boolean alchemist) {
        this.alchemist = alchemist;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getInitialRarity() {
        return initialRarity;
    }

    public void setInitialRarity(int initialRarity) {
        this.initialRarity = initialRarity;
    }

    public int getMaxRarity() {
        return maxRarity;
    }

    public void setMaxRarity(int maxRarity) {
        this.maxRarity = maxRarity;
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
