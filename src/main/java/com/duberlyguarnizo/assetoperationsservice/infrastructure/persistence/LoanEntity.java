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
 * The LoanEntity class represents a loan entity in the system.
 * It encapsulates the properties and behaviors of a loan.
 */
@Builder
@Getter
@Setter
@Document
public class LoanEntity {
  @Id
  private String id;
  private UUID loanAccountId;
  private Double amount;
  private OperationChannel operationChannel;
  private Instant createdAt;
}
