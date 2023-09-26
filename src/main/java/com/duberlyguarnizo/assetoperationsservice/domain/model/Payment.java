/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.domain.model;

import com.duberlyguarnizo.assetoperationsservice.domain.enums.OperationChannel;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Payment {
  private UUID accountId;
  private Double amount;
  private OperationChannel operationChannel;
}
