/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence;

import io.reactivex.rxjava3.core.Observable;
import java.util.UUID;
import org.springframework.data.repository.reactive.RxJava3SortingRepository;

/**
 * A repository interface for accessing and managing PaymentEntity objects.
 */
public interface PaymentEntityRepository extends RxJava3SortingRepository<PaymentEntity, String> {
  Observable<PaymentEntity> findByAccountId(UUID loanId);
}
