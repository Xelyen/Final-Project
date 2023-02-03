package com.promineotech.genshin.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.genshin.entity.CharacterEntity;
import com.promineotech.genshin.entity.CharacterInputEntity;
import com.promineotech.genshin.entity.ElementEntity;
import com.promineotech.genshin.entity.SkillEntity;

public interface GenshinService {
  
  List<CharacterEntity> getCharacters();
  
  List<SkillEntity> getSkill();

  List<ElementEntity> getElement();

  CharacterEntity getCharacter(String charId);
  
  CharacterEntity createCharacter(CharacterInputEntity input);

  CharacterEntity deleteCharacter(String charId);


  
  
}
