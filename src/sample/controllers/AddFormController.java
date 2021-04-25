package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodTextRun;
import javafx.stage.Stage;
import sample.models.Order;
import sample.models.OrderModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AddFormController implements Initializable {

    public TextField txtOrderName;
    public TextField txtOrderAuthor;
    public TextField txtOrderPublisher;
    public TextField txtOrderGenre;
    public TextField txtOrderType;
    public TextField txtOrderSection;
    private boolean modalResult = false;
    public OrderModel orderModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    // обработчик нажатия на кнопку Сохранить
    public void onSaveClick(ActionEvent actionEvent) {
        // вызываем метод добавить модели, и передаем в него еду с формы
        this.orderModel.add(getOrder());
        // а это так и оставляем
        ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
    }

    public void onCancelClick(ActionEvent actionEvent) {
        this.modalResult = false; // ставим результат модального окна на false
        // закрываем окно к которому привязана кнопка
        ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
    }

    // геттер для резальтата модального окна
    public Boolean getModalResult() {
        return modalResult;
    }


    public Order getOrder(){

        Order result = null;
        String name = this.txtOrderName.getText();
        String author = this.txtOrderAuthor.getText();
        String publisher = this.txtOrderPublisher.getText();
        String genre = this.txtOrderGenre.getText();
        String type = this.txtOrderType.getText();
        Integer section = Integer.parseInt(this.txtOrderSection.getText());

        result = new Order(name,author,publisher,genre,type,section);

        return result;

    }



}
