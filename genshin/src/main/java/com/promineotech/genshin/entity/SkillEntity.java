package com.promineotech.genshin.entity;

public class SkillEntity {
  private String skillId;
  private String elementalSkill;
  private String elementalBurst;
  
  public SkillEntity(String skillId, String elementalSkill, String elementalBurst) {
    setSkillId(skillId);
    setElementalSkill(elementalSkill);
    setElementalBurst(elementalBurst);
  }

  public String getSkillId() {
    return skillId;
  }
  
  public void setSkillId(String skillId) {
    this.skillId = skillId;
  }
  
  public String getElementalSkill() {
    return elementalSkill;
  }
  
  public void setElementalSkill(String elementalSkill) {
    this.elementalSkill = elementalSkill;
  }
  
  public String getElementalBurst() {
    return elementalBurst;
  }
  
  public void setElementalBurst(String elementalBurst) {
    this.elementalBurst = elementalBurst;
  }
  


}
