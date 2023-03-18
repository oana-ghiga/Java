package org.example.compulsory;

public class InvalidDocumentException extends Exception {
    private static final long serialVersionUID = 1L;
    public InvalidDocumentException(String message) {
        super(message);
    }
}