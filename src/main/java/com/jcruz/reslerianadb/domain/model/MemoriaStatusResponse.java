package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public record MemoriaStatusResponse(
        @JsonProperty("attack") List<MemoriaGrowthDTO> attack,
        @JsonProperty("defense") List<MemoriaGrowthDTO> defense,
        @JsonProperty("hp") List<MemoriaGrowthDTO> hp,
        @JsonProperty("magic") List<MemoriaGrowthDTO> magic,
        @JsonProperty("mental") List<MemoriaGrowthDTO> mental,
        @JsonProperty("speed") List<MemoriaGrowthDTO> speed
) {
    public static final class Builder {

        List<MemoriaGrowthDTO> attack;
        List<MemoriaGrowthDTO> defense;
        List<MemoriaGrowthDTO> hp;
        List<MemoriaGrowthDTO> magic;
        List<MemoriaGrowthDTO> mental;
        List<MemoriaGrowthDTO> speed;

        public Builder attack(List<MemoriaGrowthDTO> attack) {
            this.attack = attack;
            return this;
        }

        public Builder defense(List<MemoriaGrowthDTO> defense) {
            this.defense = defense;
            return this;
        }

        public Builder hp(List<MemoriaGrowthDTO> hp) {
            this.hp = hp;
            return this;
        }

        public Builder magic(List<MemoriaGrowthDTO> magic) {
            this.magic = magic;
            return this;
        }

        public Builder mental(List<MemoriaGrowthDTO> mental) {
            this.mental = mental;
            return this;
        }

        public Builder speed(List<MemoriaGrowthDTO> speed) {
            this.speed = speed;
            return this;
        }

        public MemoriaStatusResponse build() {
            return new MemoriaStatusResponse(
                    attack,
                    defense,
                    hp,
                    magic,
                    mental,
                    speed);
        }
    }
}
