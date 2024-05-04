package com.eyalmiz.password_manager.repository;

import com.eyalmiz.password_manager.Entity.SecretNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SecretNoteRepository extends JpaRepository<SecretNote, Long> {
}
