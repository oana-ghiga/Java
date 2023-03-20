package org.example.compulsory;

import java.io.IOException;



public class Main {

    public static void main(String[] args) {

        Catalog catalog = new Catalog("My Catalog");

        // add some documents to the catalog
        try {
            Document document1 = new Document("doc1", "Document 1", "C:\\Documents\\doc1.pdf");
            document1.setTagValue("Author", "John Doe");
            document1.setTagValue("Year", "2022");
            catalog.addDocument(document1);

            Document document2 = new Document("doc2", "Document 2", "http://www.dmmserver.com/Agart/978/057/9780575082441.pdf");
            document2.setTagValue("Author", "Jane Smith");
            document2.setTagValue("Year", "2021");
            catalog.addDocument(document2);
        } catch (InvalidDocumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // display the catalog
        System.out.println("Catalog:");
        System.out.println(catalog);

        // save the catalog to a file
        try {
            CatalogManager.saveCatalogToJson(catalog, "catalog.json");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // load the catalog from the file
        try {
            Catalog loadedCatalog = CatalogManager.loadCatalogFromJson("catalog.json");
            System.out.println("Loaded catalog:");
            System.out.println(loadedCatalog);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // get a document from the catalog
        Document document = catalog.getDocumentById("doc1");
        System.out.println("Document:");
        System.out.println(document);

    }

}
