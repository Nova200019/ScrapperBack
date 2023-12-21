package com.example.scrapperback;


import org.springframework.jpa.repository.JpaRepository;
import com.example.scrapperback.SearchResult;

public interface SearchRepository extends JpaRepository<SearchResult, Long> {
    // Define custom query methods if necessary
}