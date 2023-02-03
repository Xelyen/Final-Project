package com.promineotech.genshin.entity;

public class ElementEntity {
  private String elementId;
  private String charId;
  private String elementType;
  
  public ElementEntity(String elementId, String charId, String elementType) {
    setElementId(elementId);
    setCharId(charId);
    setElementType(elementType);
  }
  
  public String getElementId() {
    return elementId;
  }
  
  public void setElementId(String elementId) {
    this.elementId = elementId;
  }
  
  public String getCharId() {
    return charId;
  }
  
  public void setCharId(String charId) {
    this.charId = charId;
  }
  
  public String getElementType() {
    return elementType;
  }
  
  public void setElementType(String elementType) {
    this.elementType = elementType;
  }
  

}
