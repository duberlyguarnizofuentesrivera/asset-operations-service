/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence;

import io.reactivex.rxjava3.core.Observable;
import java.util.UUID;
import org.springframework.data.repository.reactive.RxJava3SortingRepository;

/**
 * The CardExpenseEntityRepository interface provides methods for accessing and manipulating
 * card expense entity data in a repository.
 */
public interface CardExpenseEntityRepository extends RxJava3SortingRepository<CardExpenseEntity,
    String> {
  Observable<CardExpenseEntity> findByCardAccountId(UUID cardAccountId);
}
