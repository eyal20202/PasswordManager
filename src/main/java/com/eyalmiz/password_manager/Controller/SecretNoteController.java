package com.eyalmiz.password_manager.Controller;

import com.eyalmiz.password_manager.Entity.SecretNote;
import com.eyalmiz.password_manager.Service.SecretNoteService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "SecretNoteController", description = "Crud Rest Api SecretNotes")
@RestController
@RequestMapping("/api/secret-notes")
@Api(value = "Secret Note API", description = "CRUD operations for secret notes")
public class SecretNoteController {
    private final SecretNoteService secretNoteService;

    @Autowired
    public SecretNoteController(SecretNoteService secretNoteService) {
        this.secretNoteService = secretNoteService;
    }

    @GetMapping
    @ApiResponse(description = "Get all secret notes", responseCode = "200")
    public List<SecretNote> getAllSecretNotes() {
        return secretNoteService.getAllSecretNotes();
    }

    @PostMapping
    @ApiResponse(description = "Create a new secret note", responseCode = "200")
    public SecretNote createSecretNote(@RequestBody SecretNote secretNote) {
        return secretNoteService.createSecretNote(secretNote);
    }

    @PutMapping("/{id}")
    @ApiResponse(description = "Update an existing secret note", responseCode = "200")
    public SecretNote updateSecretNote(@PathVariable Long id, @RequestBody SecretNote updatedSecretNote) {
        return secretNoteService.updateSecretNote(id, updatedSecretNote);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(description = "Delete a secret note", responseCode = "200")
    public ResponseEntity<?> deleteSecretNote(@PathVariable Long id) {
        secretNoteService.deleteSecretNote(id);
        return ResponseEntity.ok().build();
    }
}