/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.domain.repository;

import com.duberlyguarnizo.assetoperationsservice.domain.model.CardExpense;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Loan;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Payment;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.UUID;

/**
 * Interface defining the methods for persistence operations related to assets.
 */
public interface AssetPersistence {
  public Single<Loan> takeLoan(Loan loan);

  public Observable<Loan> getLoansByAccountId(UUID accountId);

  public Single<Payment> payLoanOrCard(Payment payment);

  public Observable<Payment> getPaymentsByAccountId(UUID accountId);

  public Single<CardExpense> makeCardExpense(CardExpense expense);

  public Observable<CardExpense> getCardExpensesByAccountId(UUID accountId);
}
