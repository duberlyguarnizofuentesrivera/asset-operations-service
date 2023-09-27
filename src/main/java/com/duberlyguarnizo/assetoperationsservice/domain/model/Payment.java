/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.domain.model;

import com.duberlyguarnizo.assetoperationsservice.architecture.DomainModel;
import com.duberlyguarnizo.assetoperationsservice.domain.enums.OperationChannel;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a payment made by a customer.
 *
 * @since 1.0.0
 */
@Builder
@Getter
@ToString
@DomainModel
public class Payment {
  private UUID accountId;
  private Double amount;
  private OperationChannel operationChannel;
}
