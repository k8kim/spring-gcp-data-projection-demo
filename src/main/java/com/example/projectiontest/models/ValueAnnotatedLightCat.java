package com.example.projectiontest.models;

import java.time.Instant;
import org.springframework.beans.factory.annotation.Value;

public interface ValueAnnotatedLightCat {

  Long getId();

  String getName();
  Breed getBreed();

  @Value("#{target.owner.name}")
  Person getOwnerName();

  Instant getFound();
}
