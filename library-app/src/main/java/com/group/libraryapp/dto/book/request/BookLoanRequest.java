package com.group.libraryapp.dto.book.request;

public class BookLoanRequest {

    public String getUserName() {
        return userName;
    }

    public String getBookName() {
        return BookName;
    }

    private String userName;
    private String BookName;
}
