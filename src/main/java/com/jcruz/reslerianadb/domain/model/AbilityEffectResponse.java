package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AbilityEffectResponse(
        @JsonProperty("value") int value) {

    public static final class Builder {
        int value;

        public Builder value(int value) {
            this.value = value;
            return this;
        }


        public AbilityEffectResponse build() {
            return new AbilityEffectResponse(value);
        }
    }
}
