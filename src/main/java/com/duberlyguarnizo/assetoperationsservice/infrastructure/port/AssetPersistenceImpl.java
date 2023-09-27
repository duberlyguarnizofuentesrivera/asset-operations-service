/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.infrastructure.port;

import com.duberlyguarnizo.assetoperationsservice.architecture.Port;
import com.duberlyguarnizo.assetoperationsservice.domain.model.CardExpense;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Loan;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Payment;
import com.duberlyguarnizo.assetoperationsservice.domain.repository.AssetPersistence;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.mapper.PersistenceMapper;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence.CardExpenseEntityRepository;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence.LoanEntityRepository;
import com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence.PaymentEntityRepository;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Port
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
  public Single<Loan> takeLoan(Loan loan) {
    return loanRepository.save(PersistenceMapper.toEntity(loan))
        .map(PersistenceMapper::toDomain);

  }

  @Override
  public Observable<Loan> getLoansByAccountId(UUID accountId) {
    return loanRepository.findByLoanAccountId(accountId)
        .map(PersistenceMapper::toDomain);
  }

  @Override
  public Single<Payment> PayLoanOrCard(Payment payment) {
    return paymentRepository.save(PersistenceMapper.toEntity(payment))
        .map(PersistenceMapper::toDomain);

  }

  @Override
  public Observable<Payment> getPaymentsByAccountId(UUID accountId) {
    return paymentRepository.findByAccountId(accountId)
        .map(PersistenceMapper::toDomain);

  }

  @Override
  public Single<CardExpense> makeCardExpense(CardExpense expense) {
    return cardExpenseRepository.save(PersistenceMapper.toEntity(expense))
        .map(PersistenceMapper::toDomain);

  }

  @Override
  public Observable<CardExpense> getCardExpensesByAccountId(UUID accountId) {
    return cardExpenseRepository.findByCardAccountId(accountId)
        .map(PersistenceMapper::toDomain);
  }
}
