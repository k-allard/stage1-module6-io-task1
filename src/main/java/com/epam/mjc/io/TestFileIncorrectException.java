package com.epam.mjc.io;

public class TestFileIncorrectException extends RuntimeException {
    TestFileIncorrectException(String message) {
        super(message);
    }

    TestFileIncorrectException() {
        super();
    }
}
