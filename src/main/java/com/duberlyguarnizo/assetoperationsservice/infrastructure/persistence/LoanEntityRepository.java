/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence;

import io.reactivex.rxjava3.core.Observable;
import java.util.UUID;
import org.springframework.data.repository.reactive.RxJava3SortingRepository;

public interface LoanEntityRepository extends RxJava3SortingRepository<LoanEntity, String> {
  Observable<LoanEntity> findByLoanAccountId(UUID accountId);
}
