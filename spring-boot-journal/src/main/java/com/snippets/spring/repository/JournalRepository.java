package com.snippets.spring.repository;

import com.snippets.spring.domain.JournalEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<JournalEntryEntity, Long> {}
