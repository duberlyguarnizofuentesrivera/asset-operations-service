/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.domain.service;

import com.duberlyguarnizo.assetoperationsservice.domain.messaging.InterServiceComms;
import com.duberlyguarnizo.assetoperationsservice.domain.model.CardExpense;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Loan;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Payment;
import com.duberlyguarnizo.assetoperationsservice.domain.repository.AssetPersistence;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * The AssetService class is responsible for managing assets such as loans,
 * payments, and card expenses.
 * It interacts with the AssetPersistence class to perform CRUD operations on the assets.
 */
@Service
public class AssetService {
  private final AssetPersistence assetPersistence;
  private final InterServiceComms interServiceComms;

  public AssetService(AssetPersistence assetPersistence, InterServiceComms interServiceComms) {
    this.assetPersistence = assetPersistence;
    this.interServiceComms = interServiceComms;
  }

  public Single<Loan> newLoan(Loan loan) {
    return assetPersistence.takeLoan(loan);
  }

  public Single<Payment> newPayment(Payment payment) {
    var accountId = payment.getAccountId();
    // payments do not count for monthly count of operations without commission
    var result = assetPersistence.payLoanOrCard(payment);
    interServiceComms.accountSubtractFromBalance(accountId, payment.getAmount());
    return result;
  }

  public Single<CardExpense> buyWithCard(CardExpense cardExpense) {
    if (interServiceComms.creditCardInsideCreditLimit(cardExpense.getCardAccountId(),
        cardExpense.getAmount())) {
      return assetPersistence.makeCardExpense(cardExpense);
    } else {
      return Single.error(new RuntimeException("Client does not have enough card credit"));
    }
  }

  public Observable<Loan> getLoansByAccountId(UUID accountId) {
    return assetPersistence.getLoansByAccountId(accountId);
  }

  public Observable<Payment> getPaymentsByAccountId(UUID accountId) {
    return assetPersistence.getPaymentsByAccountId(accountId);
  }

  public Observable<CardExpense> getCardExpensesByAccountId(UUID accountId) {
    return assetPersistence.getCardExpensesByAccountId(accountId);
  }

}
