package com.snippets.spring.repository;

import com.snippets.spring.domain.JournalEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface JournalRepository extends JpaRepository<JournalEntryEntity, Long> {

    List<JournalEntryEntity> findByCreatedAfter(@Param("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date date);
    List<JournalEntryEntity> findByCreatedBetween(@Param("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date after, @Param("before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date before);
    List<JournalEntryEntity> findByTitleContaining(@Param("word") String word);
    List<JournalEntryEntity> findBySummaryContaining(@Param("word") String word);


}
