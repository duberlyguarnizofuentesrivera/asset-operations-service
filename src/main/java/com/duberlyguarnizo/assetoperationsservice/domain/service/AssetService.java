/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.domain.service;

import com.duberlyguarnizo.assetoperationsservice.domain.model.CardExpense;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Loan;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Payment;
import com.duberlyguarnizo.assetoperationsservice.domain.repository.AssetPersistence;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
  private final AssetPersistence assetPersistence;

  public AssetService(AssetPersistence assetPersistence) {
    this.assetPersistence = assetPersistence;
  }

  public Single<Loan> newLoan(Loan loan) {
    return assetPersistence.takeLoan(loan);
  }

  public Single<Payment> newPayment(Payment payment) {
    return assetPersistence.PayLoanOrCard(payment);
  }

  public Single<CardExpense> buyWithCard(CardExpense cardExpense) {
    return assetPersistence.makeCardExpense(cardExpense);
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
