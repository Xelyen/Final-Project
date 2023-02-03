package com.promineotech.genshin.entity;

public class CharacterEntity {
  private String charId;
  private String charName;
  private String region;
  private String weapon;
  
  public CharacterEntity(String charId, String charName) {
    setCharId(charId);
    setCharName(charName);
  }
  
  public String getCharId() {
    return charId;
  }
  
  public CharacterEntity setCharId(String charId) {
    this.charId = charId;
    return this;
  }
  
  public String getCharName() {
    return charName;
  }
  
  public CharacterEntity setCharName(String charName) {
    this.charName = charName;
    return this;
  }
  
  public String getRegion() {
    return region;
  }
  
  public CharacterEntity setRegion(String region) {
    this.region = region;
    return this;
  }
  
  public String getWeapon() {
    return weapon;
  }
  
  public CharacterEntity setWeapon(String weapon) {
    this.weapon = weapon;
    return this;
  }
  

}
