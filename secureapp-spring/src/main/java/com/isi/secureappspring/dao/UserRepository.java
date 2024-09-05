package com.isi.secureappspring.dao;


import com.isi.secureappspring.entities.AccountUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AccountUserEntity, Long> {
    Optional<AccountUserEntity> findByEmail(String email);
}
