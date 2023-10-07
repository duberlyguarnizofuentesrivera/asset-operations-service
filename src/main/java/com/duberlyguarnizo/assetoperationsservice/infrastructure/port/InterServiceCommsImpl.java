/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.infrastructure.port;

import com.duberlyguarnizo.assetoperationsservice.architecture.Port;
import com.duberlyguarnizo.assetoperationsservice.domain.messaging.InterServiceComms;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Port
@Service
public class InterServiceCommsImpl implements InterServiceComms {
  @Override
  public boolean accountHasFoundsForOperation(String accountId, double amount) {
    return false;
  }

  @Override
  public double accountGetCurrentBalance(UUID accountId) {
    return 0;
  }

  @Override
  public int accountGetCurrentNumberOfOperations(UUID accountId) {
    return 0;
  }

  @Override
  public void accountAddToBalance(UUID accountId, double amount) {

  }

  @Override
  public void accountSubtractFromBalance(UUID accountId, double amount) {

  }

  @Override
  public boolean creditCardInsideCreditLimit(UUID accountId, double amount) {
    return false;
  }

  @Override
  public boolean clientHasLoanGuarantee(UUID clientId) {
    return false;
  }
}
