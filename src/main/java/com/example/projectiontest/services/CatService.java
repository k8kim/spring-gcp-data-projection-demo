package com.example.projectiontest.services;

import com.example.projectiontest.models.Breed;
import com.example.projectiontest.models.Cat;
import com.example.projectiontest.models.LightCat;
import com.example.projectiontest.models.ValueAnnotatedLightCat;
import com.example.projectiontest.models.Person;
import com.example.projectiontest.repositories.CatRepository;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CatService {
  private final CatRepository catRepository;
  public Cat addCat(String name, String ownerName) {
    return catRepository.save(
        new Cat().setBreed(Breed.AMERICAN_SHORTHAIR)
            .setName(name)
            .setFound(Instant.now())
            .setOwner(new Person().setName(ownerName).setAddress("Canada"))
            .setReferenceId(100L));
  }

  public List<LightCat> getLightCats() {
    Instant from = Instant.parse("2023-11-01T18:35:24.00Z");
    Instant to = Instant.now();
    List<LightCat> lightCats= catRepository.findLightCatByReferenceIdAndFoundGreaterThanEqualAndFoundLessThanEqualOrderByFoundDesc(100L,
        from, to);
    log.info("light cats: {} found from {} to {}", lightCats, from, to);
    return lightCats;
  }


  public List<ValueAnnotatedLightCat> getValueAnnotatedLightCats() {
    Instant from = Instant.parse("2023-11-01T18:35:24.00Z");
    Instant to = Instant.now();
    List<ValueAnnotatedLightCat> lightCats= catRepository.findValueAnnotatedLightCatByReferenceIdAndFoundGreaterThanEqualAndFoundLessThanEqualOrderByFoundDesc(100L,
        from, to);
    log.info("light cats: {} found from {} to {}", lightCats, from, to);
    return lightCats;
  }


  public List<Cat> getCats() {
    Instant from = Instant.parse("2023-11-01T18:35:24.00Z");
    Instant to = Instant.now();
    List<Cat> cats = catRepository.findAllByReferenceIdAndFoundGreaterThanEqualAndFoundLessThanEqualOrderByFoundDesc(100L, from, to);
    log.info("cats: {} found from {} to {}", cats, from, to);
    return cats;
  }
}
