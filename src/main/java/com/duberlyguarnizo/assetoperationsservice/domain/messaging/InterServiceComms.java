/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.domain.messaging;

import java.util.UUID;

public interface InterServiceComms {

  boolean accountHasFoundsForOperation(String accountId, double amount);

  double accountGetCurrentBalance(UUID accountId);

  int accountGetCurrentNumberOfOperations(UUID accountId);

  void accountAddToBalance(UUID accountId, double amount);

  void accountSubtractFromBalance(UUID accountId, double amount);

  boolean creditCardInsideCreditLimit(UUID accountId, double amount);

  boolean clientHasLoanGuarantee(UUID clientId);

}
