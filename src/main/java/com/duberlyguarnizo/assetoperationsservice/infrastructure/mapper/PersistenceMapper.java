/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.infrastructure.mapper;

import com.duberlyguarnizo.assetoperationsservice.domain.model.CardExpense;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Loan;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Payment;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence.CardExpenseEntity;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence.LoanEntity;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence.PaymentEntity;
import java.time.Instant;

public class PersistenceMapper {
  public static Loan toDomain(LoanEntity entity) {
    return Loan.builder()
        .amount(entity.getAmount())
        .loanAccountId(entity.getLoanAccountId())
        .operationChannel(entity.getOperationChannel())
        .build();
  }

  public static LoanEntity toEntity(Loan domain) {
    return LoanEntity.builder()
        .amount(domain.getAmount())
        .loanAccountId(domain.getLoanAccountId())
        .operationChannel(domain.getOperationChannel())
        .createdAt(Instant.now())
        .build();
  }

  public static Payment toDomain(PaymentEntity entity) {
    return Payment.builder()
        .accountId(entity.getAccountId())
        .amount(entity.getAmount())
        .operationChannel(entity.getOperationChannel())
        .build();
  }

  public static PaymentEntity toEntity(Payment domain) {
    return PaymentEntity.builder()
        .accountId(domain.getAccountId())
        .amount(domain.getAmount())
        .operationChannel(domain.getOperationChannel())
        .createdAt(Instant.now())
        .build();
  }

  public static CardExpense toDomain(CardExpenseEntity entity) {
    return CardExpense.builder()
        .cardAccountId(entity.getCardAccountId())
        .amount(entity.getAmount())
        .build();
  }

  public static CardExpenseEntity toEntity(CardExpense domain) {
    return CardExpenseEntity.builder()
        .cardAccountId(domain.getCardAccountId())
        .amount(domain.getAmount())
        .createdAt(Instant.now())
        .build();
  }
}
