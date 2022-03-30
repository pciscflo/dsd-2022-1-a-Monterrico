package com.example.appmanytomany.taller.repositorio;

import com.example.appmanytomany.taller.entidades.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author,Long> {
}
