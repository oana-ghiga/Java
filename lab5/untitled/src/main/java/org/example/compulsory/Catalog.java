package org.example.compulsory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.compulsory.DocumentNotFoundException;

public class Catalog {

    private List<Document> documents;
    private String name;

    public Catalog(String name) {
        this.name = name;
        this.documents = new ArrayList<Document>();
    }

    public void add(Document document) {
        documents.add(document);
    }

    public void remove(Document document) {
        documents.remove(document);
    }

    public Document searchByName(String name) throws DocumentNotFoundException {
        for (Document document : documents) {
            if (document.getName().equals(name)) {
                return document;
            }
        }
        throw new DocumentNotFoundException("Document with name " + name + " not found.");
    }

    public List<Document> searchByTag(String tagName, String tagValue) {
        List<Document> matchingDocuments = new ArrayList<Document>();
        for (Document document : documents) {
            if (document.getTagValue(tagName).equals(tagValue)) {
                matchingDocuments.add(document);
            }
        }
        return matchingDocuments;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Catalog: " + name + "\n");
        for (Document document : documents) {
            sb.append(document.toString() + "\n");
        }
        return sb.toString();
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public Document getDocumentById(String id) {
        for (Document document : documents) {
            if (document.getId().equals(id)) {
                return document;
            }
        }
        return null;
    }
}

