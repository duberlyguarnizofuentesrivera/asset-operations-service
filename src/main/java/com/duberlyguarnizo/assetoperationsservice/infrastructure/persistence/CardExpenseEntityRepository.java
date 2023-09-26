/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice.infrastructure.persistence;

import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardExpenseEntityRepository extends MongoRepository<CardExpenseEntity, String> {
  List<CardExpenseEntity> findByCardAccountId(UUID cardAccountId);
}
