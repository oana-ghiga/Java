import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ViewCommand implements Command {
    private Document document;

    public ViewCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() throws CommandException {
        String location = document.getLocation();
        try {
            if (location.startsWith("http")) {
                Desktop.getDesktop().browse(new URI(location));
            } else {
                Desktop.getDesktop().open(document.getDocument().toFile());
            }
        } catch (IOException | URISyntaxException e) {
            throw new CommandException("Failed to view doc: " + e.getMessage());
        }
    }
}
