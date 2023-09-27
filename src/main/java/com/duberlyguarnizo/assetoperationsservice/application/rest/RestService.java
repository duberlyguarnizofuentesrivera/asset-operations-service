/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.application.rest;

import com.duberlyguarnizo.assetoperationsservice.application.dto.CardExpenseCreationDto;
import com.duberlyguarnizo.assetoperationsservice.application.dto.LoanCreationDto;
import com.duberlyguarnizo.assetoperationsservice.application.dto.PaymentCreationDto;
import com.duberlyguarnizo.assetoperationsservice.domain.enums.OperationChannel;
import com.duberlyguarnizo.assetoperationsservice.domain.model.CardExpense;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Loan;
import com.duberlyguarnizo.assetoperationsservice.domain.model.Payment;
import com.duberlyguarnizo.assetoperationsservice.domain.service.AssetService;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RestService {
  private final AssetService assetService;

  public RestService(AssetService assetService) {
    this.assetService = assetService;
  }

  public Single<ResponseEntity<Void>> createCardExpense(Single<CardExpenseCreationDto> dtoSingle,
                                                        UUID accountId) {
    dtoSingle.subscribe(dto -> assetService.newPayment(Payment.builder()
        .accountId(accountId)
        .amount(dto.getAmount())
        .build())).dispose();
    //Not returning a body because we are not using a controller
    return Single.just(new ResponseEntity<Void>(HttpStatus.CREATED));
  }

  public Single<ResponseEntity<Void>> createLoan(Single<LoanCreationDto> dtoSingle,
                                                 UUID accountId) {
    dtoSingle.subscribe(dto -> assetService.newLoan(Loan.builder()
        .loanAccountId(accountId)
        .amount(dto.getAmount())
        .operationChannel(OperationChannel.valueOf(dto.getTransactionMedia().name()))
        .build())).dispose();
    return Single.just(new ResponseEntity<Void>(HttpStatus.CREATED));
  }

  public Single<ResponseEntity<Void>> createPayment(Single<PaymentCreationDto> dtoSingle,
                                                    UUID accountId) {
    dtoSingle.subscribe(dto -> assetService.newPayment(Payment.builder()
        .accountId(accountId)
        .amount(dto.getAmount())
        .operationChannel(OperationChannel.valueOf(dto.getTransactionMedia().name()))
        .build())).dispose();
    return Single.just(new ResponseEntity<Void>(HttpStatus.CREATED));
  }

  public Observable<Payment> getPaymentsByAccountId(UUID accountId) {
    return assetService.getPaymentsByAccountId(accountId);
  }

  public Observable<Loan> getLoansByAccountId(UUID accountId) {
    return assetService.getLoansByAccountId(accountId);
  }

  public Observable<CardExpense> getCardExpensesByAccountId(UUID accountId) {
    return assetService.getCardExpensesByAccountId(accountId);
  }

}
