package com.promineotech.genshin.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.genshin.entity.CharacterEntity;
import com.promineotech.genshin.entity.CharacterInputEntity;
import com.promineotech.genshin.service.GenshinService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Characters")
@OpenAPIDefinition(info = @Info(title = "Characters"))
@RestController
public class CharacterController {
  private GenshinService service;
  
  // Same as @Autowired
  public CharacterController(GenshinService service) {
    this.service = service;
  }
  
  @Operation(summary = "Gets all the Characters")
  @GetMapping(value = "/characters")
  public List<CharacterEntity> all() {
    List<CharacterEntity> characters = service.getCharacters();
    return characters;
  }
  
  @Operation(summary = "Gets a Character by Character ID.")
  @GetMapping(value = "/characters/{charId}")
  public CharacterEntity get(@PathVariable String charId) {
    if ((charId != null) && (! charId.isEmpty())) {
      CharacterEntity character = service.getCharacter(charId);
      if (character != null) {
        return character;
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found.");
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Character ID not provided");
  }
  
  @Operation(summary = "Creates a new Character")
  @PostMapping(value = "/characters")
  public CharacterEntity create(@RequestBody CharacterInputEntity input) {
    if ((input != null) && (input.isValid())) {
      CharacterEntity character = service.createCharacter(input);
      if (character != null) {
        return character;
      }
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Character not created.");
    }
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Character.");
  }
  
  @DeleteMapping(value = "/characters/{charId}")
  public CharacterEntity delete(@PathVariable String charId) {
    if ((charId != null) && (! charId.isEmpty())) {
      CharacterEntity character = service.deleteCharacter(charId);
      if (character != null) {
        return character;
    }
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unhandled Exception.");
  }
  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid ID.");
  }
}
