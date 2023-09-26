/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.domain.model;

import com.duberlyguarnizo.assetoperationsservice.domain.enums.OperationChannel;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CardExpense {
  private UUID cardAccountId;
  private Double amount;
  private OperationChannel operationChannel;
}
