package com.example.projectiontest.models;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import java.io.Serializable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
public class Cat implements Serializable {
  @Id
  private Long id;

  private Long referenceId;

  private String name;

  private Instant found;

  private Breed breed;

  private Person owner;
}
