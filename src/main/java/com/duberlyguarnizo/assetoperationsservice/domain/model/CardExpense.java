/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.domain.model;

import com.duberlyguarnizo.assetoperationsservice.architecture.DomainModel;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@DomainModel
public class CardExpense {
  private UUID cardAccountId;
  private Double amount;
}
