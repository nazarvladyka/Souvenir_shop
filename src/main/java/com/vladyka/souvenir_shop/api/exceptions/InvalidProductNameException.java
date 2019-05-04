package com.vladyka.souvenir_shop.api.exceptions;

public class InvalidProductNameException extends BaseException {

    public InvalidProductNameException(String message) {
        super(message);
    }
}