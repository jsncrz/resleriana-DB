package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DetailedCharacterResponse(@JsonProperty("name") String name,
                                        @JsonProperty("anotherName") String anotherName,
                                        @JsonProperty("fullName") String fullName,
                                        @JsonProperty("acquisitionText") String acquisitionText,
                                        @JsonProperty("description") String description,
                                        @JsonProperty("alchemist") boolean alchemist) {

    public static final class Builder {
        String name;
        String anotherName;
        String fullName;
        String acquisitionText;
        String description;
        boolean alchemist;

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

        public Builder acquisitionText(String acquisitionText) {
            this.acquisitionText = acquisitionText;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder alchemist(boolean alchemist) {
            this.alchemist = alchemist;
            return this;
        }

        public DetailedCharacterResponse build() {
            return new DetailedCharacterResponse(name,
                            anotherName,
                    fullName,
                    acquisitionText,
                    description,
                    alchemist);
        }
    }
}
