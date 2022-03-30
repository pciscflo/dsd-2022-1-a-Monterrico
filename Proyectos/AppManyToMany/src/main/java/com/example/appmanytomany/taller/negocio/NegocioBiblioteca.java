package com.example.appmanytomany.taller.negocio;

import com.example.appmanytomany.taller.entidades.Author;
import com.example.appmanytomany.taller.entidades.Book;
import com.example.appmanytomany.taller.repositorio.AuthorRepository;
import com.example.appmanytomany.taller.repositorio.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class NegocioBiblioteca {
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final AuthorRepository authorRepository;

    public NegocioBiblioteca(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Book registrar(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Author registrar(Author author) {
        return authorRepository.save(author);
    }
}
