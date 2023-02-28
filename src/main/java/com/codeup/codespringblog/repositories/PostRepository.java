package com.codeup.codespringblog.repositories;

import com.codeup.codespringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostsById(Long id);
}
