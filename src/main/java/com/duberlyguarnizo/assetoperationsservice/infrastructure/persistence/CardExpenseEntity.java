/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a card expense entity in a data store.
 */
@Builder
@Getter
@Setter
@Document
public class CardExpenseEntity {
  @Id
  private String id;
  private UUID cardAccountId;
  private Double amount;
  private Instant createdAt;
}
