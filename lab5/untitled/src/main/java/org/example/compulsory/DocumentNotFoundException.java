package org.example.compulsory;

public class DocumentNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;
    public DocumentNotFoundException(String message) {
        super(message);
    }
}
