/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence;

import com.duberlyguarnizo.assetoperationsservice.domain.enums.OperationChannel;
import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a payment entity in the database.
 * <p>
 * This class is annotated with {@link Document} to indicate that it is a MongoDB document.
 * </p>
 */
@Builder
@Getter
@Setter
@Document
public class PaymentEntity {
  @Id
  private String id;
  private UUID accountId;
  private Double amount;
  private OperationChannel operationChannel;
  private Instant createdAt;
}
