package edu.imdadia.alumnus.config;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Will load the FXML hierarchy as specified in the load method and register Spring as the FXML
 * Controller Factory. Allows Spring and Java FX to coexist once the Spring Application context has
 * been bootstrapped.
 */
@Component
@RequiredArgsConstructor
public class SpringFXMLLoader {

  private final ResourceBundle resourceBundle;
  private final ApplicationContext context;

  public Parent load(final String fxmlPath) throws IOException {
    final FXMLLoader loader = getFxmlLoader(fxmlPath);
    return loader.load();
  }

  public FXMLLoader getFxmlLoader(final String fxmlPath) {
    final FXMLLoader loader = new FXMLLoader();
    loader.setControllerFactory(context::getBean); //Spring now FXML Controller Factory
    loader.setResources(resourceBundle);
    loader.setLocation(getClass().getResource(fxmlPath));
    return loader;
  }
}