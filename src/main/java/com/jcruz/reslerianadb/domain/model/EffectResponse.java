package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EffectResponse(
        @JsonProperty("value") int value,
        @JsonProperty("effectIndex") Integer effectIndex
        ) {

    public static final class Builder {
        int value;
        Integer effectIndex;

        public Builder value(int value) {
            this.value = value;
            return this;
        }

        public Builder effectIndex(Integer effectIndex) {
            this.effectIndex = effectIndex;
            return this;
        }

        public EffectResponse build() {
            return new EffectResponse(value,effectIndex);
        }
    }
}
