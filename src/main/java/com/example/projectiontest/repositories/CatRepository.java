package com.example.projectiontest.repositories;

import com.example.projectiontest.models.Cat;
import com.example.projectiontest.models.LightCat;
import com.example.projectiontest.models.ValueAnnotatedLightCat;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import java.time.Instant;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CatRepository extends DatastoreRepository<Cat, Long> {

  List<LightCat> findLightCatByReferenceIdAndFoundGreaterThanEqualAndFoundLessThanEqualOrderByFoundDesc(@NonNull Long referenceId, @NonNull
      Instant fromTime, @NonNull Instant toTime);


  List<ValueAnnotatedLightCat> findValueAnnotatedLightCatByReferenceIdAndFoundGreaterThanEqualAndFoundLessThanEqualOrderByFoundDesc(@NonNull Long referenceId, @NonNull
  Instant fromTime, @NonNull Instant toTime);

  List<Cat> findAllByReferenceIdAndFoundGreaterThanEqualAndFoundLessThanEqualOrderByFoundDesc(@NonNull Long referenceId, @NonNull Instant from, @NonNull Instant to);
}
