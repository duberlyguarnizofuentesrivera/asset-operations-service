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

/**
 * The PersistenceMapper class provides static methods for converting between domain objects and
 * their corresponding persistence entities.
 *
 * <p>This class should not be instantiated, as it only contains static methods.
 */
public final class PersistenceMapper {
  PersistenceMapper() {
    throw new UnsupportedOperationException("This class is not meant to be instantiated");
  }

  /**
   * Converts a LoanEntity object to a Loan domain object.
   *
   * @param entity the LoanEntity object to be converted
   * @return the converted Loan domain object
   */
  public static Loan toDomain(LoanEntity entity) {
    return Loan.builder()
        .amount(entity.getAmount())
        .loanAccountId(entity.getLoanAccountId())
        .operationChannel(entity.getOperationChannel())
        .build();
  }

  /**
   * Converts a PaymentEntity object to a Payment object.
   *
   * @param entity the PaymentEntity object to be converted
   * @return the converted Payment object
   */
  public static Payment toDomain(PaymentEntity entity) {
    return Payment.builder()
        .accountId(entity.getAccountId())
        .amount(entity.getAmount())
        .operationChannel(entity.getOperationChannel())
        .build();
  }

  /**
   * Converts a CardExpenseEntity object to a CardExpense object.
   *
   * @param entity the CardExpenseEntity object to be converted
   * @return the converted CardExpense object
   */
  public static CardExpense toDomain(CardExpenseEntity entity) {
    return CardExpense.builder()
        .cardAccountId(entity.getCardAccountId())
        .amount(entity.getAmount())
        .build();
  }

  /**
   * Converts a Loan object to a LoanEntity object.
   *
   * @param domain the Loan object to be converted
   * @return the converted LoanEntity object
   */
  public static LoanEntity toEntity(Loan domain) {
    return LoanEntity.builder()
        .amount(domain.getAmount())
        .loanAccountId(domain.getLoanAccountId())
        .operationChannel(domain.getOperationChannel())
        .createdAt(Instant.now())
        .build();
  }


  /**
   * Converts a Payment object to a PaymentEntity object.
   *
   * @param domain the Payment object to be converted
   * @return the converted PaymentEntity object
   */
  public static PaymentEntity toEntity(Payment domain) {
    return PaymentEntity.builder()
        .accountId(domain.getAccountId())
        .amount(domain.getAmount())
        .operationChannel(domain.getOperationChannel())
        .createdAt(Instant.now())
        .build();
  }


  /**
   * Converts a CardExpense object to a CardExpenseEntity object.
   *
   * @param domain the CardExpense object to be converted
   * @return the converted CardExpenseEntity object
   */
  public static CardExpenseEntity toEntity(CardExpense domain) {
    return CardExpenseEntity.builder()
        .cardAccountId(domain.getCardAccountId())
        .amount(domain.getAmount())
        .createdAt(Instant.now())
        .build();
  }
}
