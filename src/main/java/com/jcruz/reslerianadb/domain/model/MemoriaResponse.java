package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MemoriaResponse(
        @JsonProperty("id") Integer id,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("rarity") int rarity,
        @JsonProperty("abilities") List<AbilityResponse> abilityResponse) {

    public static final class Builder {
        Integer id;
        String name;
        String description;
        int rarity;
        List<AbilityResponse> abilityResponse;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder rarity(int rarity) {
            this.rarity = rarity;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder abilityResponse(List<AbilityResponse> abilityResponse) {
            this.abilityResponse = abilityResponse;
            return this;
        }

        public MemoriaResponse build() {
            return new MemoriaResponse(
                    id,
                    name,
                    description,
                    rarity,
                    abilityResponse);
        }
    }
}
