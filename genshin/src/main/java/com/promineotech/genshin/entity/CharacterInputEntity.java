package com.promineotech.genshin.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CharacterInputEntity {
  private String charId;
  private String charName;
  private String region;
  private String weapon;
  
  public CharacterInputEntity(String charId, String charName) {
    setCharId(charId);
    setCharName(charName);
  }
  
  public String getCharId(){
    return charId;
  }
  
  public CharacterInputEntity setCharId(String charId) {
    this.charId = charId;
    return this;
  }
  
  public String getCharName() {
    return charName;
  }
  
  public CharacterInputEntity setCharName(String charName) {
    this.charName = charName;
    return this;
  }
  
  public String getRegion() {
    return region;
  }
  
  public CharacterInputEntity setRegion(String region) {
    this.region = region;
    return this;
  }
  
  public String getWeapon() {
    return weapon;
  }
  
  public CharacterInputEntity setWeapon(String weapon) {
    this.weapon = weapon;
    return this;
  }
  
  public boolean isValid() {
    return getCharId() != null && (! getCharId().isEmpty()) && getCharName() != null && (! getCharName().isEmpty());
  }
  

}
