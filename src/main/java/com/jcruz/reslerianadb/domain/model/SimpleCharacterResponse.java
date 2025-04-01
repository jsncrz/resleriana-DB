package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SimpleCharacterResponse(@JsonProperty("name") String name,
                                      @JsonProperty("another_name") String anotherName,
                                      @JsonProperty("initial_rarity") int initialRarity,
                                      @JsonProperty("attack_attribute") String attackAttribute,
                                      @JsonProperty("alchemist") boolean alchemist) {

    public static final class Builder {
        String name;
        String anotherName;
        String attackAttribute;
        int initialRarity;
        boolean alchemist;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder anotherName(String anotherName) {
            this.anotherName = anotherName;
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


        public Builder alchemist(boolean alchemist) {
            this.alchemist = alchemist;
            return this;
        }

        public SimpleCharacterResponse build() {
            return new SimpleCharacterResponse(name,
                    anotherName,
                    initialRarity,
                    attackAttribute,
                    alchemist);
        }
    }
}
