package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CharacterResistResponse(
        @JsonProperty("fire") int fire,
        @JsonProperty("ice") int ice,
        @JsonProperty("bolt") int bolt,
        @JsonProperty("air") int air,
        @JsonProperty("slash") int slash,
        @JsonProperty("strike") int strike,
        @JsonProperty("stab") int stab
        ) {

    public static final class Builder {

        int fire;
        int ice;
        int bolt;
        int air;
        int slash;
        int strike;
        int stab;

        public Builder fire(int fire) {
            this.fire = fire;
            return this;
        }

        public Builder ice(int ice) {
            this.ice = ice;
            return this;
        }

        public Builder bolt(int bolt) {
            this.bolt = bolt;
            return this;
        }

        public Builder air(int air) {
            this.air = air;
            return this;
        }

        public Builder slash(int slash) {
            this.slash = slash;
            return this;
        }

        public Builder strike(int strike) {
            this.strike = strike;
            return this;
        }

        public Builder stab(int stab) {
            this.stab = stab;
            return this;
        }

        public CharacterResistResponse build() {
            return new CharacterResistResponse(
                    fire,
                    ice,
                    bolt,
                    air,
                    slash,
                    strike,
                    stab);
        }
    }
}
