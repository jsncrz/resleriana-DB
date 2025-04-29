package com.jcruz.reslerianadb.domain.service;

import com.jcruz.reslerianadb.common.exception.InternalServerError;
import com.jcruz.reslerianadb.common.util.TranslationHelper;
import com.jcruz.reslerianadb.domain.model.CharacterSkillResponse;
import com.jcruz.reslerianadb.domain.model.EffectResponse;
import com.jcruz.reslerianadb.domain.model.SkillResponse;
import com.jcruz.reslerianadb.domain.specification.CharacterSkillSpec;
import com.jcruz.reslerianadb.infrastructure.entity.CharacterSkill;
import com.jcruz.reslerianadb.infrastructure.entity.Skill;
import com.jcruz.reslerianadb.infrastructure.repository.CharacterSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class CharacterSkillService {

    private static final String SKILL_1 = "SKILL_1";
    private static final String SKILL_2 = "SKILL_2";
    private static final String BURST_SKILL = "BURST_SKILL";

    @Autowired
    private final CharacterSkillRepository characterSkillRepository;

    @Autowired
    private final TranslationHelper translationHelper;

    public CharacterSkillService(CharacterSkillRepository characterSkillRepository, TranslationHelper translationHelper) {
        this.characterSkillRepository = characterSkillRepository;
        this.translationHelper = translationHelper;
    }

    public CharacterSkillResponse getCharacterSkills(int id, String language) {
        List<CharacterSkill> allSkills;
        try {
            allSkills = this.characterSkillRepository.findAll(where(CharacterSkillSpec.characterIdIs(id)));


        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
        return new CharacterSkillResponse.Builder()
                .skill1(getSkillListAsSkillResponseList(language, SKILL_1, allSkills))
                .skill2(getSkillListAsSkillResponseList(language, SKILL_2, allSkills))
                .burstSkill(getSkillListAsSkillResponseList(language, BURST_SKILL, allSkills))
                .build();
    }

    private List<SkillResponse> getSkillListAsSkillResponseList(String language, String skillType, List<CharacterSkill> allSkills) {
        return allSkills.stream()
                .filter(characterSkill -> skillType.equals(characterSkill.getSkillType()))
                .map(characterSkill -> transformSkillEntityToSkillResponse(language, characterSkill)).toList();
    }

    private SkillResponse transformSkillEntityToSkillResponse(String language, CharacterSkill characterSkill) {
        Skill skill = characterSkill.getSkill();
        return new SkillResponse.Builder()
                .name(translationHelper.getTextForLang(
                        skill.getName(), language))
                .description(translationHelper.getTextForLang(
                        skill.getDescription(), language))
                .skillWait(skill.getSkillWait())
                .breakPower(skill.getBreakPower())
                .power(skill.getPower())
                .attribute(skill.getAttribute())
                .effectType(skill.getEffectType())
                .targetType(skill.getTargetType())
                .skillEffects(transformSkillEffectToEffectResponse(skill))
                .linkedSkill(skill.getLinkedSkill() != null ?
                        translationHelper.getTextForLang(
                                skill.getLinkedSkill().getName(), language) : null)
                .build();
    }

    private static List<EffectResponse> transformSkillEffectToEffectResponse(Skill skill) {
        return skill.getSkillEffects().stream()
                .map(skillEffect ->
                        new EffectResponse.Builder()
                                .value(skillEffect.getValue())
                                .effectIndex(skillEffect.getSkillEffectIndex())
                                .build())
                .toList();
    }

}
