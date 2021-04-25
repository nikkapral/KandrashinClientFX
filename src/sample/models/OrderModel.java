package sample.models;

import java.util.ArrayList;

public class OrderModel {
    ArrayList<Order> ordersList = new ArrayList<>();
    private ArrayList<DataChangedListener> dataChangedListeners = new ArrayList<>();

    public interface DataChangedListener {
        void dataChanged(ArrayList<Order> ordersList);
    }

    public void addDataChangedListener(DataChangedListener listener) {
        // ну просто его в список добавляем
        this.dataChangedListeners.add(listener);
    }

    // добавил метод
    public void load() {
        ordersList.clear();

        // скопипастили код из контроллера
        ordersList.add(new Order(1, "Отцы и курсач", "Кандрашин", "Милованов", "Хоррор", "Книга", 1));
        ordersList.add(new Order(2, "Тестим", "Капралов", "2x2", "Фантастика", "Журнал", 2));

        // а тут добавляем
        // если кто-нибудь слушает наш класс
        this.emitDataChanged();

    }


    public void add(Order order) {
        // просто добавили еду в список
        this.ordersList.add(order);

        // оповестили всех слушателей что данные изменились
        for (DataChangedListener listener: dataChangedListeners) {
            listener.dataChanged(ordersList);
        }
    }

    private void emitDataChanged() {
        for (DataChangedListener listener: dataChangedListeners) {
            listener.dataChanged(ordersList);
        }
    }

    public void delete(int id)
    {
        for (int i = 0; i< this.ordersList.size(); ++i) {
            // ищем в цикле еду с данным айдишником
            if (this.ordersList.get(i).id == id) {
                // если нашли то удаляем
                this.ordersList.remove(i);
                break;
            }
        }

        // оповещаем об изменениях
        this.emitDataChanged();
    }





















}
