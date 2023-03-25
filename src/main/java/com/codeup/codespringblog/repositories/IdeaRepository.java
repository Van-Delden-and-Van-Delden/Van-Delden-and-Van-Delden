package com.codeup.codespringblog.repositories;

import com.codeup.codespringblog.models.Idea;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaRepository extends JpaRepository<Idea, Long> {
    Idea findIdeasById(Long id);
}
