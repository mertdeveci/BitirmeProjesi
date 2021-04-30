package com.example.BitirmeProjesi.Repository;

import com.example.BitirmeProjesi.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
}
