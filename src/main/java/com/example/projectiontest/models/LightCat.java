package com.example.projectiontest.models;

import java.time.Instant;

public interface LightCat {
  Long getId();

  String getName();
  Breed getBreed();

  Person getOwner();

  Instant getFound();

  interface Person {
    String getName();
  }
}
