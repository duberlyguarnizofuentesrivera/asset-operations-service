/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.infrastructure.port;

import com.duberlyguarnizo.assetoperationsservice.domain.model.CardExpense;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Loan;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Payment;
import com.duberlyguarnizo.assetoperationsservice.domain.repository.AssetPersistence;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.mapper.PersistenceMapper;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence.CardExpenseEntityRepository;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence.LoanEntityRepository;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence.PaymentEntityRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class AssetPersistenceImpl implements AssetPersistence {
  private final LoanEntityRepository loanRepository;
  private final PaymentEntityRepository paymentRepository;
  private final CardExpenseEntityRepository cardExpenseRepository;

  public AssetPersistenceImpl(LoanEntityRepository loanRepository, PaymentEntityRepository paymentRepository, CardExpenseEntityRepository cardExpenseRepository) {
    this.loanRepository = loanRepository;
    this.paymentRepository = paymentRepository;
    this.cardExpenseRepository = cardExpenseRepository;
  }

  @Override
  public void takeLoan(Loan loan) {
    loanRepository.save(PersistenceMapper.toEntity(loan));
  }

  @Override
  public List<Loan> getLoansByAccountId(UUID accountId) {
    return loanRepository.findByLoanAccountId(accountId).stream()
        .map(PersistenceMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public void PayLoanOrCard(Payment payment) {
    paymentRepository.save(PersistenceMapper.toEntity(payment));
  }

  @Override
  public List<Payment> getPaymentsByAccountId(UUID accountId) {
    return paymentRepository.findByAccountId(accountId).stream()
        .map(PersistenceMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public void makeCardExpense(CardExpense expense) {
    cardExpenseRepository.save(PersistenceMapper.toEntity(expense));
  }

  @Override
  public List<CardExpense> getCardExpensesByAccountId(UUID accountId) {
    return cardExpenseRepository.findByCardAccountId(accountId).stream()
        .map(PersistenceMapper::toDomain)
        .collect(Collectors.toList());
  }
}
