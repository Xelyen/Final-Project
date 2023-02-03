package com.promineotech.genshin.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import com.promineotech.genshin.dao.CharacterDao;
import com.promineotech.genshin.entity.CharacterEntity;
import com.promineotech.genshin.entity.CharacterInputEntity;
import com.promineotech.genshin.entity.ElementEntity;
import com.promineotech.genshin.entity.SkillEntity;

@Service
public class DefaultGenshinService implements GenshinService {
  private CharacterDao characterDao;
  
  // Same as @Autowired
  public DefaultGenshinService(CharacterDao characterDao) {
    this.characterDao = characterDao;
  }

  @Override
  public List<CharacterEntity> getCharacters() {
    Stream<CharacterEntity> characters = characterDao.getAllCharacters();
    return characters.toList();
  }
  
  @Override
  public List<SkillEntity> getSkill() {
    Stream<SkillEntity> skill = characterDao.getAllSkill();
    return skill.toList();
  }

  @Override
  public List<ElementEntity> getElement() {
    Stream<ElementEntity> element = characterDao.getAllElement();
    return element.toList();
  }

  @Override
  public CharacterEntity getCharacter(String charId) {
    if ((charId != null) && (! charId.isEmpty())) {
      Optional<CharacterEntity> character = characterDao.getCharacter(charId);
      if (character.isPresent()) {
        return character.get();
      }
    }
    return null;
  }

  @Override
  public CharacterEntity createCharacter(CharacterInputEntity input) {
    if ((input != null) && (input.isValid())) {
      Optional<CharacterEntity> character = characterDao.createCharacter(input);
      if (character.isPresent()) {
        return character.get();
      }
    }
    return null;
  }

  @Override
  public CharacterEntity deleteCharacter(String charId) {
    if ((charId != null) && (! charId.isEmpty())) {
      Optional<CharacterEntity> character = characterDao.deleteCharacter(charId);
      if (character.isPresent()) {
        return character.get();
      }
    }
    return null;
  }
  

}
