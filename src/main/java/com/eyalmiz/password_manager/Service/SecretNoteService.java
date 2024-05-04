package com.eyalmiz.password_manager.Service;

import com.eyalmiz.password_manager.Entity.SecretNote;
import com.eyalmiz.password_manager.repository.SecretNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretNoteService {
    private final SecretNoteRepository secretNoteRepository;
    private final EncryptionService encryptionService;

    @Autowired
    public SecretNoteService(SecretNoteRepository secretNoteRepository, EncryptionService encryptionService) {
        this.secretNoteRepository = secretNoteRepository;
        this.encryptionService = encryptionService;
    }

    public List<SecretNote> getAllSecretNotes() {
        List<SecretNote> secretNotes = secretNoteRepository.findAll();
        secretNotes.forEach(secretNote -> secretNote.setEncryptedPassword(encryptionService.decrypt(secretNote.getEncryptedPassword())));
        return secretNotes;
    }

    public SecretNote createSecretNote(SecretNote secretNote) {
        secretNote.setEncryptedPassword(encryptionService.encrypt(secretNote.getEncryptedPassword()));
        return secretNoteRepository.save(secretNote);
    }

    public SecretNote updateSecretNote(Long id, SecretNote updatedSecretNote) {
        SecretNote secretNote = secretNoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Secret note not found"));
        secretNote.setName(updatedSecretNote.getName());
        secretNote.setWebsite(updatedSecretNote.getWebsite());
        secretNote.setEmail(updatedSecretNote.getEmail());
        secretNote.setEncryptedPassword(encryptionService.encrypt(updatedSecretNote.getEncryptedPassword()));
        return secretNoteRepository.save(secretNote);
    }

    public void deleteSecretNote(Long id) {
        secretNoteRepository.deleteById(id);
    }
}