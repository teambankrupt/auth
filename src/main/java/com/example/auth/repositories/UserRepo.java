package com.example.auth.repositories;

import com.example.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username=:username AND u.deleted=false")
    Optional<User> find(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.id=:id AND u.deleted=false")
    Optional<User> find(@Param("id") Long id);

    @Query("SELECT u FROM User u WHERE u.id IN :ids AND u.deleted=false")
    Set<User> findByIds(@Param("ids") Set<Long> ids);

}
