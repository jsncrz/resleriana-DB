package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CharacterSkillResponse(
        @JsonProperty("skill1") List<SkillResponse> skill1,
        @JsonProperty("skill2") List<SkillResponse> skill2,
        @JsonProperty("burstSkill") List<SkillResponse> burstSkill
        ) {

    public static final class Builder {

        List<SkillResponse> skill1;
        List<SkillResponse> skill2;
        List<SkillResponse> burstSkill;

        public Builder skill1(List<SkillResponse> skill1) {
            this.skill1 = skill1;
            return this;
        }

        public Builder skill2(List<SkillResponse> skill2) {
            this.skill2 = skill2;
            return this;
        }

        public Builder burstSkill(List<SkillResponse> burstSkill) {
            this.burstSkill = burstSkill;
            return this;
        }

        public CharacterSkillResponse build() {
            return new CharacterSkillResponse(
                    skill1,
                    skill2,
                    burstSkill);
        }
    }
}
