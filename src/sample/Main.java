package sample;

// просто импорты
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// важное отличие, класс Main должен наследовать Application
public class Main extends Application {

    // это метод который вызывается при запуске javafx приложения
    // в нем принято прописывать инициализацию приложения
    @Override
    public void start(Stage primaryStage) throws Exception {
        // этой строчкой просим создать интерфейс из sample.fxml
        Parent root = FXMLLoader.load(getClass().getResource("/sample/views/mainform.fxml"));

        // primaryStage -- это по сути главное окно приложения
        // оно уже создано до нас где-то внутри Application
        // мы указываем окну имя Hello World
        primaryStage.setTitle("Hello World");

        // а тут привязываем интерфейс, который мы загрузили
        // и положили в переменную root, к нашему окну
        // плюс указываем размеры окна 300x275
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);

        // ну и показываем окно пользователю
        primaryStage.show();
    }


    public static void main(String[] args) {
        // это обыкновенный main, только тут вызываем метод launch
        // который инициализирует создание окна JavaFX приложения
        // и заодно вызывает метод start (который выше)
        launch(args);
    }
}