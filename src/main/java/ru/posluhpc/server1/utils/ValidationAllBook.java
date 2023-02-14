package ru.posluhpc.server1.utils;

import org.springframework.validation.annotation.Validated;
import ru.posluhpc.server1.entity.BookEntity;

import javax.xml.bind.ValidationException;

@Validated
public class ValidationAllBook {
    public static void validationAllBook (BookEntity book) throws ValidationException{

        String bookValidationTitle = book.getTitle();
        String bookValidationAuthor = book.getAuthor();
        String bookValidationPublishing = book.getPublishing();
        String bookValidationKind = book.getKind();
        Integer bookValidationYear = book.getYear();

        if (bookValidationTitle == null | bookValidationTitle.isBlank() | !bookValidationTitle.matches("[\\sA-Za-zА-Яа-я]{2,100}"))
            throw new ValidationException("Ошибка Title");
        if (bookValidationAuthor == null | bookValidationAuthor.isBlank() | !bookValidationAuthor.matches("[\\sA-Za-zА-Яа-я]{2,100}"))
            throw new ValidationException("Ошибка Author");
        if (bookValidationPublishing == null | bookValidationPublishing.isBlank() | !bookValidationPublishing.matches("[\\sA-Za-zА-Яа-я]{2,55}"))
            throw new ValidationException("Ошибка Publishing");
        if (bookValidationKind == null | bookValidationKind.isBlank() | !bookValidationKind.matches("[\\sA-Za-zА-Яа-я]{4,30}"))
            throw new ValidationException("Ошибка Kind");
        if (bookValidationYear == null | bookValidationYear == 0 | bookValidationYear < 1000 && bookValidationYear > 2023)
            throw new ValidationException("Ошибка4");
    }
}
