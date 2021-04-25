package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.models.Order;
import sample.models.OrderModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public TableView mainTable;
    public TableColumn idColumn;
    public TableColumn nameColumn;
    public TableColumn authorColumn;
    public TableColumn publisherColumn;
    public TableColumn genreColumn;
    public TableColumn typeColumn;
    public TableColumn sectionColumn;



    OrderModel orderModel = new OrderModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        sectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));


        // теперь вызываем метод, вместо прямого присваивания
        // прям как со всякими кнопочками
        orderModel.addDataChangedListener(orders -> {
            mainTable.setItems(FXCollections.observableArrayList(orders));
        });

        orderModel.load();
        // ...
    }



    public void onAddClick(ActionEvent event) throws IOException {

        // эти три строчки создюат форму из fxml файлика
        // в принципе можно было бы обойтись
        // Parent root = FXMLLoader.load(getClass().getResource("FoodForm.fxml"));
        // но дальше вот это разбиение на три строки упростит нам жизнь
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/views/addorder.fxml"));
        Parent root = loader.load();

        // ну а тут создаем новое окно
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        // указываем что оно модальное
        stage.initModality(Modality.WINDOW_MODAL);
        // указываем что оно должно блокировать главное окно
        // ну если точнее, то окно, на котором мы нажали на кнопку
        stage.initOwner(this.mainTable.getScene().getWindow());

        AddFormController controller = loader.getController();
        controller.orderModel =orderModel;
        stage.showAndWait();


    }

    public void onDeleteClick(ActionEvent actionEvent) {
        Order order = (Order) this.mainTable.getSelectionModel().getSelectedItem();
        this.mainTable.getItems().remove(order);
    }

}
