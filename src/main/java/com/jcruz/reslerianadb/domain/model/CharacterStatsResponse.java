package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CharacterStatsResponse(
        @JsonProperty("attack") int attack,
        @JsonProperty("defense") int defense,
        @JsonProperty("hp") int hp,
        @JsonProperty("magic") int magic,
        @JsonProperty("mental") int mental,
        @JsonProperty("speed") int speed
        ) {

    public static final class Builder {

        int attack;
        int defense;
        int hp;
        int magic;
        int mental;
        int speed;

        public Builder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder defense(int defense) {
            this.defense = defense;
            return this;
        }

        public Builder hp(int hp) {
            this.hp = hp;
            return this;
        }

        public Builder magic(int magic) {
            this.magic = magic;
            return this;
        }

        public Builder mental(int mental) {
            this.mental = mental;
            return this;
        }

        public Builder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public CharacterStatsResponse build() {
            return new CharacterStatsResponse(
                    attack,
                    defense,
                    hp,
                    magic,
                    mental,
                    speed);
        }
    }
}
