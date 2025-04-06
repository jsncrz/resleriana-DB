package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CharacterResponse(
        @JsonProperty("id") Integer id,
        @JsonProperty("name") String name,
        @JsonProperty("anotherName") String anotherName,
        @JsonProperty("fullName") String fullName,
        @JsonProperty("acquisitionText") String acquisitionText,
        @JsonProperty("description") String description,
        @JsonProperty("initialRarity") int initialRarity,
        @JsonProperty("attackAttribute") String attackAttribute,
        @JsonProperty("role") String role,
        @JsonProperty("alchemist") boolean alchemist) {

    public static final class Builder {
        Integer id;
        String name;
        String anotherName;
        String fullName;
        String acquisitionText;
        String description;
        String attackAttribute;
        String role;
        int initialRarity;
        boolean alchemist;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder anotherName(String anotherName) {
            this.anotherName = anotherName;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder initialRarity(int initialRarity) {
            this.initialRarity = initialRarity;
            return this;
        }

        public Builder attackAttribute(String attackAttribute) {
            this.attackAttribute = attackAttribute;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder alchemist(boolean alchemist) {
            this.alchemist = alchemist;
            return this;
        }

        public Builder acquisitionText(String acquisitionText) {
            this.acquisitionText = acquisitionText;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public CharacterResponse build() {
            return new CharacterResponse(
                    id,
                    name,
                    anotherName,
                    fullName,
                    acquisitionText,
                    description,
                    initialRarity,
                    attackAttribute,
                    role,
                    alchemist);
        }
    }
}
