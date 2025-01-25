package com.Bookmyshow.db.Book_My_Show_db.repository;

import com.Bookmyshow.db.Book_My_Show_db.models.Threater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface  ThreaterRepository extends JpaRepository<Threater, UUID> {
}
