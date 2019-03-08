package Entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sell {
    public final StringProperty id_sell;
    public final StringProperty count;
    public final StringProperty cost;
    public final StringProperty prod_id;
    public final StringProperty group_id;
    public final StringProperty type_id;

    public Sell(String id_sell, String count, String cost, String prod_id, String group_id, String type_id) {
        this.id_sell = new SimpleStringProperty(id_sell);
        this.count = new SimpleStringProperty(count);
        this.cost = new SimpleStringProperty(cost);
        this.prod_id = new SimpleStringProperty(prod_id);
        this.group_id = new SimpleStringProperty(group_id);
        this.type_id = new SimpleStringProperty(type_id);
    }

    public String getId_sell() {
        return id_sell.get();
    }

    public StringProperty id_sellProperty() {
        return id_sell;
    }

    public void setId_sell(String id_sell) {
        this.id_sell.set(id_sell);
    }

    public String getCount() {
        return count.get();
    }

    public StringProperty countProperty() {
        return count;
    }

    public void setCount(String count) {
        this.count.set(count);
    }

    public String getCost() {
        return cost.get();
    }

    public StringProperty costProperty() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost.set(cost);
    }

    public String getProd_id() {
        return prod_id.get();
    }

    public StringProperty prod_idProperty() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id.set(prod_id);
    }

    public String getGroup_id() {
        return group_id.get();
    }

    public StringProperty group_idProperty() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id.set(group_id);
    }

    public String getType_id() {
        return type_id.get();
    }

    public StringProperty type_idProperty() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id.set(type_id);
    }
}
