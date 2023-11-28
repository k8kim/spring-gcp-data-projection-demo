package com.example.projectiontest.controllers;

import com.example.projectiontest.models.Cat;
import com.example.projectiontest.models.LightCat;
import com.example.projectiontest.models.ValueAnnotatedLightCat;
import com.example.projectiontest.services.CatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CatController {
  private final CatService catService;

  @PostMapping("/cats")
  public Cat addCat(@RequestParam(value = "name") String name, @RequestParam(value="ownerName") String ownerName)
 {

    log.debug("->addCat: name: {} ownerName: {}", name, ownerName);

    return catService.addCat(name, ownerName);
  }


  @GetMapping("/cats")
  public List<Cat> getCats()
  {

    log.debug("->getCats");

    return catService.getCats();
  }


  @GetMapping("/light-cats")
  public List<LightCat> getLightCats()
  {

    log.debug("->getLightCats");

    return catService.getLightCats();
  }


  @GetMapping("/value-annotated-light-cats")
  public List<ValueAnnotatedLightCat> getValueAnnotatedLightCats()
  {

    log.debug("->getLightCats");

    return catService.getValueAnnotatedLightCats();
  }
}
