package com.example.projectiontest.configuration;

import com.google.cloud.Timestamp;
import com.google.cloud.spring.data.datastore.core.convert.DatastoreCustomConversions;
import java.time.Instant;
import java.util.Arrays;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

/**
 * Custom Datastore type converters for entity projection. Datastore forcibly converts Date into
 * Long when a projection is done on an entity with a Date-typed field, causing issues. Custom
 * converters removes this friction
 */
@Configuration
@Data
@Slf4j
@NoArgsConstructor
public class DatastoreConverterConfiguration {

  private final Converter<Long, Instant> MICROSECONDS_TO_INSTANT_CONVERTER =
      new Converter<Long, Instant>() {
        @Override
        public Instant convert(Long microseconds) {
          return Instant.ofEpochMilli(microseconds / 1000);
        }
      };

  private final Converter<Instant, Long> INSTANT_TO_MICROSECONDS_CONVERTER =
      new Converter<Instant, Long>() {
        @Override
        public Long convert(Instant instant) {
          return instant.toEpochMilli() * 1000;
        }
      };

  private final Converter<Timestamp, Instant> TIMESTAMP_TO_INSTANT_CONVERTER =
      new Converter<Timestamp, Instant>() {
        @Override
        public Instant convert(Timestamp source) {
          return source.toDate().toInstant();
        }
      };

  private final Converter<Instant, Timestamp> INSTANT_TO_TIMESTAMP_CONVERTER =
      new Converter<Instant, Timestamp>() {
        @Override
        public Timestamp convert(Instant source) {
          return Timestamp.ofTimeMicroseconds(source.toEpochMilli() * 1000);
        }
      };

  @Bean
  public DatastoreCustomConversions datastoreCustomConversions() {
    return new DatastoreCustomConversions(
        Arrays.asList(
            MICROSECONDS_TO_INSTANT_CONVERTER,
            INSTANT_TO_MICROSECONDS_CONVERTER,
            TIMESTAMP_TO_INSTANT_CONVERTER,
            INSTANT_TO_TIMESTAMP_CONVERTER));
  }
}