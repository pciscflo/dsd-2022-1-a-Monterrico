package com.example.appmanytomany.taller.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.appmanytomany.taller.entidades.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
