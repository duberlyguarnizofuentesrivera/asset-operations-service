/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.application.delegate;

import com.duberlyguarnizo.assetoperationsservice.application.dto.CardExpenseCreationDto;
import com.duberlyguarnizo.assetoperationsservice.application.dto.LoanCreationDto;
import com.duberlyguarnizo.assetoperationsservice.application.dto.PaymentCreationDto;
import com.duberlyguarnizo.assetoperationsservice.application.request.AssetsApiDelegate;
import com.duberlyguarnizo.assetoperationsservice.application.rest.RestService;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.adapter.rxjava.RxJava3Adapter;
import reactor.core.publisher.Mono;

@Service
public class AssetApiDelegateImp implements AssetsApiDelegate {

  private final RestService restService;

  public AssetApiDelegateImp(RestService restService) {
    this.restService = restService;
  }

  /**
   * POST /assets/card-expenses/{accountId}.
   *
   * @param accountId The account UUID to make the deposit on. (required)
   * @param dto       (optional)
   * @param exchange  the request and response exchange
   * @return Loan created (status code 201)
   */
  @Override
  public Mono<ResponseEntity<Void>> registerCardExpense(UUID accountId,
                                                        Mono<CardExpenseCreationDto> dto,
                                                        ServerWebExchange exchange) {
    exchange.getResponse().setStatusCode(HttpStatus.CREATED);
    return RxJava3Adapter.singleToMono(restService.createCardExpense(RxJava3Adapter.monoToSingle(dto),
        accountId));
  }

  /**
   * POST /assets/loans/{accountId}.
   *
   * @param accountId       The account UUID to make the deposit on. (required)
   * @param loanCreationDto (optional)
   * @param exchange        the request and response exchange
   * @return Loan created (status code 201)
   */
  @Override
  public Mono<ResponseEntity<Void>> registerLoan(UUID accountId,
                                                 Mono<LoanCreationDto> loanCreationDto,
                                                 ServerWebExchange exchange) {
    exchange.getResponse().setStatusCode(HttpStatus.CREATED);
    return RxJava3Adapter.singleToMono(restService.createLoan(RxJava3Adapter.monoToSingle(loanCreationDto),
        accountId));


  }

  /**
   * POST /assets/payments/{accountId}.
   *
   * @param accountId          The account UUID to make the deposit on. (required)
   * @param paymentCreationDto (optional)
   * @param exchange           the request and response exchange
   * @return Loan created (status code 201)
   */
  @Override
  public Mono<ResponseEntity<Void>> registerPayment(UUID accountId,
                                                    Mono<PaymentCreationDto> paymentCreationDto,
                                                    ServerWebExchange exchange) {
    exchange.getResponse().setStatusCode(HttpStatus.CREATED);
    return RxJava3Adapter.singleToMono(restService.createPayment(RxJava3Adapter.monoToSingle(paymentCreationDto),
        accountId));

  }
}
