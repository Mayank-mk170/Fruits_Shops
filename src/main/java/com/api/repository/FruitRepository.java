package com.api.repository;

import com.api.entity.Fruits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruits, Long> {
}
