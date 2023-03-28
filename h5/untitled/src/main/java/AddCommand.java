public class AddCommand implements Command {
    private Catalog catalog;
    private Document document;

    public AddCommand(Catalog catalog, Document document) {
        this.catalog = catalog;
        this.document = document;
    }

    @Override
    public void execute() throws CommandException {
        if (catalog.findById(document.getId()) != null) {
            throw new CommandException("Document with ID " + document.getId() + " already exists in the catalog.");
        }
        catalog.addDocument(document);
    }
}