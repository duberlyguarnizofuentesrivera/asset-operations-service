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

@Getter
@Builder
@ToString
@DomainModel
public class Loan {
  private UUID loanAccountId;
  private Double amount;
  private OperationChannel operationChannel;
}
