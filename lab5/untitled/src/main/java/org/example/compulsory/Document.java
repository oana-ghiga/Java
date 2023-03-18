package org.example.compulsory;

import java.util.HashMap;
import java.util.Map;

import org.example.compulsory.InvalidDocumentException;

public class Document {

    private String id;
    private String name;
    private String pathOrUrl;
    private Map<String, String> tags;

    public Document(String id, String name, String pathOrUrl) throws InvalidDocumentException {
        if (id == null || id.isEmpty() || name == null || name.isEmpty() || pathOrUrl == null || pathOrUrl.isEmpty()) {
            throw new InvalidDocumentException("Invalid document.");
        }
        this.id = id;
        this.name = name;
        this.pathOrUrl = pathOrUrl;
        this.tags = new HashMap<String, String>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPathOrUrl() {
        return pathOrUrl;
    }

    public String getTagValue(String tagName) {
        return tags.get(tagName);
    }

    public void setTagValue(String tagName, String tagValue) {
        tags.put(tagName, tagValue);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + id + "\n");
        sb.append("Name: " + name + "\n");
        sb.append("Path/URL: " + pathOrUrl + "\n");
        for (Map.Entry<String, String> entry : tags.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return sb.toString();
    }

    public String getLocation() {
        return pathOrUrl;
    }
}
