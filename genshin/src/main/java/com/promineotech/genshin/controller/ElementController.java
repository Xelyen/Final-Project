package com.promineotech.genshin.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.genshin.entity.ElementEntity;
import com.promineotech.genshin.service.GenshinService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Element")
@OpenAPIDefinition(info = @Info(title = "Element"))
@RestController
public class ElementController {
  private GenshinService service;

  public ElementController(GenshinService service) {
    this.service = service;
  }
  
  @Operation(summary = "Gets all the Element of all Characters")
  @GetMapping(value = "/element")
  public List<ElementEntity> all() {
    List<ElementEntity> elements = service.getElement();
    return elements;

  }
  
}
