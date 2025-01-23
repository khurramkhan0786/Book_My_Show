package com.Bookmyshow.db.Book_My_Show_db.repository;

import com.Bookmyshow.db.Book_My_Show_db.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
}
