/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.domain.repository;

import com.duberlyguarnizo.assetoperationsservice.domain.model.CardExpense;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Loan;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Payment;
import java.util.List;
import java.util.UUID;

public interface AssetPersistence {
  public void takeLoan(Loan loan);

  public List<Loan> getLoansByAccountId(UUID accountId);

  public void PayLoanOrCard(Payment payment);

  public List<Payment> getPaymentsByAccountId(UUID accountId);

  public void makeCardExpense(CardExpense expense);

  public List<CardExpense> getCardExpensesByAccountId(UUID accountId);
}
