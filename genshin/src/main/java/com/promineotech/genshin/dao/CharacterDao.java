package com.promineotech.genshin.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import com.promineotech.genshin.entity.CharacterEntity;
import com.promineotech.genshin.entity.CharacterInputEntity;
import com.promineotech.genshin.entity.ElementEntity;
import com.promineotech.genshin.entity.SkillEntity;

public interface CharacterDao {
  Stream<CharacterEntity> getAllCharacters();

  Optional<CharacterEntity> getCharacter(String charId);
  
  Optional<CharacterEntity> createCharacter(CharacterInputEntity input);

  Optional<CharacterEntity> deleteCharacter(String charId);

  Stream<SkillEntity> getAllSkill();

  Stream<ElementEntity> getAllElement();
  

}
