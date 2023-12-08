package com.example.auth.repositories;

import com.example.auth.entities.RequestCredentials;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestCredentialsRepo extends JpaRepository<RequestCredentials, Long> {
    @Query("SELECT c FROM RequestCredentials c WHERE (:query IS NULL OR c.body IS NULL OR c.body LIKE %:query%) AND c.deleted=FALSE")
    Page<RequestCredentials> search(
            @Param("query") String query,
            Pageable pageable
    );
}
