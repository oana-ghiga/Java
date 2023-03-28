import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class CatalogApplication {
    public static void main(String[] args) throws IOException, TemplateException {
        // Create a new catalog object
        Catalog catalog = new Catalog();

        // Add some documents to the catalog
        Document doc1 = new Document("doc001", "Example Document", "D:\\mine\\New-Folder\\java4\\untitled\\src\\main\\resources\\doc");
        doc1.addTag("author", "Riya");
        doc1.addTag("year", "2019");
        catalog.addDocument(doc1);

        Document doc2 = new Document("doc002", "Another Example Document", "http://example.com/document");
        doc2.addTag("title", "That");
        doc2.addTag("author", "Shaan");
        doc2.addTag("year", "2023");
        catalog.addDocument(doc2);

        // Generate the HTML report using FreeMarker
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
//        configuration.setClassForTemplateLoading(CatalogApplication.class, "D:\\mine\\New-Folder\\java4\\untitled\\src\\main\\resources\\report.ftl");
        configuration.setDirectoryForTemplateLoading(new File("D:\\mine\\New-Folder\\java4\\untitled\\src\\main\\resources\\template"));
        Template template = configuration.getTemplate("template/report.ftl");
        Map<String, Object> data = new HashMap<>();
        data.put("catalog", catalog);
        Writer writer = new FileWriter("report.html");
        template.process(data, writer);
        writer.close();
    }
}

