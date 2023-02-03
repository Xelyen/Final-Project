package com.promineotech.genshin.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.genshin.entity.SkillEntity;
import com.promineotech.genshin.service.GenshinService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Skills")
@OpenAPIDefinition(info = @Info(title = "Skills"))
@RestController
public class SkillController {
  private GenshinService service;
  
  public SkillController(GenshinService service) {
    this.service = service;
  }
  
  @Operation(summary = "Gets all the Skills")
  @GetMapping(value = "/skill")
  public List<SkillEntity> all() {
    List<SkillEntity> skills = service.getSkill();
    return skills;
  }

}
