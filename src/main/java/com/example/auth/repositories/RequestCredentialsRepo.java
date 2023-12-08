package com.example.auth.repositories;

import com.example.auth.entities.RequestCredentials;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface RequestCredentialsRepo extends JpaRepository<RequestCredentials, Long> {
    @Query("SELECT c FROM RequestCredentials c WHERE (:query IS NULL OR c.body IS NULL OR c.body LIKE %:query%) AND c.deleted=FALSE")
    Page<RequestCredentials> search(
            @Param("query") String query,
            Pageable pageable
    );

    @Query("SELECT COUNT(c) FROM RequestCredentials c WHERE c.invalidated=:invalidated " +
            " AND c.ip=:ip AND (c.createdAt BETWEEN :from AND :to)")
    int count(
            @Param("ip") String ip,
            @Param("invalidated") boolean invalidated,
            @Param("from") Instant fromDate,
            @Param("to") Instant toDate
    );

    @Modifying
    @Query("UPDATE RequestCredentials c SET c.invalidated=TRUE WHERE c.ip=:ip AND (c.createdAt BETWEEN :from AND :to)")
    int invalidate(
            @Param("ip") String ip,
            @Param("from") Instant fromDate,
            @Param("to") Instant toDate
    );
}
