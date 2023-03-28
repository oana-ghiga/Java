import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String name;
    private String pathOrUrl;
    private Map<String, String> tags;

    public Document(String id, String name, String pathOrUrl) {
        this.id = id;
        this.name = name;
        this.pathOrUrl = pathOrUrl;
        this.tags = new HashMap<>();
    }

    // Getters and setters for all properties

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String pathOrUrl) {
        this.pathOrUrl = pathOrUrl;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    // Methods to add and remove tags

    public void addTag(String name, String value) {
        tags.put(name, value);
    }

    public void removeTag(String name) {
        tags.remove(name);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pathOrUrl='" + pathOrUrl + '\'' +
                ", tags=" + tags +
                '}';
    }

    public String getLocation() {
        return pathOrUrl;
    }

public Document getDocument() {
        return new Document(id, name, pathOrUrl);
    }


    public File toFile() {
        return new File(pathOrUrl);
    }
}
