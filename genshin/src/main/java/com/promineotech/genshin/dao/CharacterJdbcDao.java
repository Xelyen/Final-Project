package com.promineotech.genshin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.genshin.entity.CharacterEntity;
import com.promineotech.genshin.entity.CharacterInputEntity;
import com.promineotech.genshin.entity.ElementEntity;
import com.promineotech.genshin.entity.SkillEntity;

@Repository
public class CharacterJdbcDao implements CharacterDao {
  private NamedParameterJdbcTemplate provider;
  
  // Same as using @Autowired
  public CharacterJdbcDao(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
  }
  
  private CharacterEntity toCharacterEntity(ResultSet rs, int rowNum) {
    try {
      CharacterEntity character = new CharacterEntity(rs.getString("character_id"), rs.getString("character_name"))
          .setRegion(rs.getString("region"))
          .setWeapon(rs.getString("weapon"));
      return character;
    } catch (SQLException e) {
      return null;
    }
  }
  
  @Override
  public Stream<CharacterEntity> getAllCharacters() {
    
    String sql = "SELECT character_id,character_name,region,weapon FROM characters;";
    Map<String,Object> parameters = new HashMap<>();
    
    List<CharacterEntity> characters = provider.query(sql, parameters, (rs,rowNum) -> {
      CharacterEntity character = toCharacterEntity(rs,rowNum);
          return character;
    });
    
    return characters.stream();
  }
  
  @Override
  public Stream<SkillEntity> getAllSkill() {
    
    String sql = "SELECT skill_id, elemental_skill, elemental_burst FROM skill";
    Map<String,Object> parameters = new HashMap<>();
    
    List<SkillEntity> skills = provider.query(sql, parameters, (rs,rowNum) -> {
      SkillEntity skill = new SkillEntity(rs.getString("skill_id"), rs.getString("elemental_skill"), rs.getString("elemental_burst"));
          return skill;
    });
    
    return skills.stream();
  }
  
  @Override
  public Stream<ElementEntity> getAllElement() {
    
    String sql = "SELECT element_id, character_id, element_type FROM element";
    Map<String,Object> parameters = new HashMap<>();
    
    List<ElementEntity> elements = provider.query(sql, parameters, (rs,rowNum) -> {
      ElementEntity element = new ElementEntity(rs.getString("character_id"), rs.getString("element_id"), rs.getString("element_type"));
          return element;
    });
    
    return elements.stream();
  }

  @Override
  public Optional<CharacterEntity> getCharacter(String charId) {
    if ((charId != null) && (! charId.isEmpty())) {
      String sql = "SELECT character_id,character_name,region,weapon "
                 + "FROM characters "
                 + "WHERE character_id = :character_id;";
      Map<String,Object> parameters = new HashMap<>();
      parameters.put("character_id", charId);

      List<CharacterEntity> characters = provider.query(sql, parameters, (rs,rowNum) -> {
        return toCharacterEntity(rs,rowNum);
      });
      if (characters.size() >= 1) {
        return Optional.of(characters.get(0));
      }
    }
    return Optional.empty();
  }
  
  public Optional<CharacterEntity> createCharacter(CharacterInputEntity input) {
    if ((input != null) && (input.isValid())) {
      String sql = "INSERT INTO characters (character_id, character_name,region,weapon) "
                 + "VALUES (:character_id, :character_name, :region, :weapon)";
      Map<String,Object> parameters = new HashMap<>();
      parameters.put("character_id", input.getCharId());
      parameters.put("character_name", input.getCharName());
      parameters.put("region", input.getRegion());
      parameters.put("weapon", input.getWeapon());
      
      int rows = provider.update(sql, parameters);
      if (rows == 1) {
        return getCharacter(input.getCharId());
      }
    }
  return Optional.empty();
  }

  @Override
  public Optional<CharacterEntity> deleteCharacter(String charId) {
    Optional<CharacterEntity> existing = getCharacter(charId);
    if (existing.isPresent()) {
      String sql = "DELETE FROM characters WHERE character_id = :character_id";
      Map<String,Object> parameters = new HashMap<>();
      parameters.put("character_id", existing.get().getCharId());
      
      int rows = provider.update(sql, parameters);
      if (rows == 1) {
        return existing;
      }
    }
    return Optional.empty();
  }

}
