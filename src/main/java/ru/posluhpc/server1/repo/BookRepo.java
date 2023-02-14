package ru.posluhpc.server1.repo;


import org.springframework.data.repository.CrudRepository;
import ru.posluhpc.server1.entity.BookEntity;

public interface BookRepo extends CrudRepository<BookEntity, Long> {

}
