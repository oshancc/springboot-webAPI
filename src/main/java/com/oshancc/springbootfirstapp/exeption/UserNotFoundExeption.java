package com.oshancc.springbootfirstapp.exeption;

public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption(String message) {
        super(message);
    }
}
