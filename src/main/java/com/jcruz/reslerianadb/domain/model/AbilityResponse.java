package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AbilityResponse(
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("abilityEffects") List<AbilityEffectResponse> abilityEffect) {

    public static final class Builder {
        String name;
        String description;
        List<AbilityEffectResponse> abilityEffect;

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder abilityEffect(List<AbilityEffectResponse> abilityEffect) {
            this.abilityEffect = abilityEffect;
            return this;
        }

        public AbilityResponse build() {
            return new AbilityResponse(
                    name,
                    description,
                    abilityEffect);
        }
    }
}
