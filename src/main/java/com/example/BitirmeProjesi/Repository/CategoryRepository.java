package com.example.BitirmeProjesi.Repository;

import com.example.BitirmeProjesi.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}
