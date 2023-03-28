import java.util.List;

public class ListCommand implements Command {
    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws CommandException {
        List<Document> documents = catalog.getDocuments();
        if (documents.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            System.out.println("Documents in the catalog:");
            for (Document document : documents) {
                System.out.println("- " + document.getName() + " (" + document.getId() + ")");
            }
        }
    }
}
