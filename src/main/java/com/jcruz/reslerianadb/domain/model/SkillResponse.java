package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record SkillResponse(
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("effects") List<EffectResponse> skillEffects,
        @JsonProperty("power") Integer power,
        @JsonProperty("breakPower") Integer breakPower,
        @JsonProperty("skillWait") Integer skillWait,
        @JsonProperty("attribute") String attribute,
        @JsonProperty("effectType") String effectType,
        @JsonProperty("targetType") String targetType
        ) {

    public static final class Builder {

        String name;
        String description;
        List<EffectResponse> skillEffects;
        Integer power;
        Integer breakPower;
        Integer skillWait;
        String attribute;
        String effectType;
        String targetType;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder skillEffects(List<EffectResponse> skillEffects) {
            this.skillEffects = skillEffects;
            return this;
        }

        public Builder power(Integer power) {
            this.power = power;
            return this;
        }

        public Builder breakPower(Integer breakPower) {
            this.breakPower = breakPower;
            return this;
        }

        public Builder skillWait(Integer skillWait) {
            this.skillWait = skillWait;
            return this;
        }

        public Builder attribute(String attribute) {
            this.attribute = attribute;
            return this;
        }

        public Builder effectType(String effectType) {
            this.effectType = effectType;
            return this;
        }

        public Builder targetType(String targetType) {
            this.targetType = targetType;
            return this;
        }

        public SkillResponse build() {
            return new SkillResponse(
                    name,
                    description,
                    skillEffects,
                    power,
                    breakPower,
                    skillWait,
                    attribute,
                    effectType,
                    targetType);
        }
    }
}
