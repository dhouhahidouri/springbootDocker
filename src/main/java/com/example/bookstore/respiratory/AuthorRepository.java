package com.example.bookstore.respiratory;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}
