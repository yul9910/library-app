package com.group.libraryapp.domain.user.loanhistory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private long userid;

    private String bookName;

    private boolean isReturn;

    protected UserLoanHistory(){
    }


    public UserLoanHistory(long userid, String bookName) {
        this.userid = userid;
        this.bookName = bookName;
        this.isReturn = false;
    }
}
