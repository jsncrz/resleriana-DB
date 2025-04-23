package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MemoriaGrowthDTO(
        @JsonProperty("level") int level,
        @JsonProperty("value") int value
        ) {

    public static final class Builder {

        int level;
        int value;

        public Builder level(int level) {
            this.level = level;
            return this;
        }

        public Builder value(int value) {
            this.value = value;
            return this;
        }

        public MemoriaGrowthDTO build() {
            return new MemoriaGrowthDTO(
                    level,
                    value);
        }
    }
}
