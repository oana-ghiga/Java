import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
    private List<Document> documents;

    public Catalog() {
        this.documents = new ArrayList<>();
    }

    // Getter for documents

    public List<Document> getDocuments() {
        return documents;
    }

    // Methods to add and remove documents

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void removeDocument(Document document) {
        documents.remove(document);
    }

    // Method to find doc by ID

    public Document findById(String id) {
        for (Document document : documents) {
            if (document.getId().equals(id)) {
                return document;
            }
        }
        return null;
    }

    // Method to generate HTML report

    public String generateHtmlReport() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(Catalog.class, "/");
        try {
            Template template = cfg.getTemplate("template/report.ftl");
            Map<String, Object> data = new HashMap<>();
            data.put("documents", documents);
            StringWriter out = new StringWriter();
            template.process(data, out);
            return out.toString();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "documents=" + documents +
                '}';
    }

}
