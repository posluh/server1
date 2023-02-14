package ru.posluhpc.server1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.posluhpc.server1.entity.BookEntity;
import ru.posluhpc.server1.response.BaseResponse;
import ru.posluhpc.server1.response.BookListResponse;
import ru.posluhpc.server1.service.BookService;


@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service;
    private BookController(BookService service){
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }
    @PostMapping("/add")
    public ResponseEntity <BaseResponse> registration(@Validated @RequestBody BookEntity data){
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"Книга добавлена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
    @PostMapping("/update")
    public ResponseEntity <BaseResponse> update(@Validated @RequestBody BookEntity data){
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"В книгу внесены изменения"));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <BaseResponse> delete(@PathVariable Long id){
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true,"Книга удалена"));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}

