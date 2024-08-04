package com.anz.JournalH2.Repository;

import com.anz.JournalH2.Entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Journalrepo extends JpaRepository<Journal,Integer> {
}
