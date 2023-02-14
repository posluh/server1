package ru.posluhpc.server1.service;

import org.springframework.stereotype.Service;
import ru.posluhpc.server1.entity.BookEntity;
import ru.posluhpc.server1.repo.BookRepo;
import ru.posluhpc.server1.utils.ValidationAllBook;

import javax.xml.bind.ValidationException;


@Service
public class BookService {
    private final BookRepo repo;
    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public void  save(BookEntity book) throws ValidationException {
        ValidationAllBook.validationAllBook(book);
        repo.save(book);
    }
    public  void delete(Long id) {
        repo.deleteById(id);
    }
    public Iterable<BookEntity> getAll(){
        return repo.findAll();
    }



}
