package ru.posluhpc.server1.response;

import ru.posluhpc.server1.entity.BookEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookListResponse extends BaseResponse {

    public BookListResponse(Iterable<BookEntity> data) {
        super(true, "Список книг");
        this.data = data;
    }

    private Iterable<BookEntity> data;
}