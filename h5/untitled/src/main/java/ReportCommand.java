import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import freemarker.template.*;

public class ReportCommand implements Command {
    private Catalog catalog;

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws CommandException {
        List<Document> documents = catalog.getDocuments();
        if (documents.isEmpty()) {
            System.out.println("The catalog is empty.");
            return;
        }

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        String basePath = "src/main/java/com/lab5/";

        try {
            configuration.setDirectoryForTemplateLoading(new File(basePath + "templates"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
//        cfg.setClassForTemplateLoading(Main.class, "templates");

        configuration.setIncompatibleImprovements(new Version(2, 3, 20));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.US);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> input = new HashMap<>();

        fillInput(input, catalog);

        try {
            Template template = configuration.getTemplate("catalog.ftl");
            Writer consoleWriter = new FileWriter( basePath + "/temp/index.html");
            template.process(input, consoleWriter);
            Desktop.getDesktop().open(new File(basePath + "/temp/index.html"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void fillInput(Map<String, Object> input, Catalog catalog) {
        input.put("title", catalog.findById("title"));
        input.put("documents", catalog.getDocuments());
    }

}
//        configuration.setClassForTemplateLoading(ReportCommand.class, "D:\\mine\\New-Folder\\java4\\untitled\\src\\main\\resources\\report.ftl");
//        try {
//            Template template = configuration.getTemplate("report.ftl");
//            Map<String, Object> data = new HashMap<>();
//            data.put("documents", documents);
//            Writer out = new FileWriter("report.html");
//            template.process(data, out);
//            out.close();
//            System.out.println("Report generated: report.html");
//        } catch (IOException | TemplateException e) {
//            throw new CommandException("Failed to generate report: " + e.getMessage());

