package Entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
    public final StringProperty id_prod;
    public final StringProperty group;
    public final StringProperty prodname;
    public final StringProperty cost1;
    public final StringProperty cost2;
    public final StringProperty sheltime;
    public final StringProperty count;


    public Product(String id_prod, String group, String prodname, String cost1, String cost2, String sheltime, String count) {
        this.id_prod = new SimpleStringProperty(id_prod);
        this.group = new SimpleStringProperty(group);
        this.prodname = new SimpleStringProperty(prodname);
        this.cost1 = new SimpleStringProperty(cost1);
        this.cost2 = new SimpleStringProperty(cost2);
        this.sheltime = new SimpleStringProperty(sheltime);
        this.count = new SimpleStringProperty(count);
    }

    public String getId_prod() {
        return id_prod.get();
    }

    public StringProperty id_prodProperty() {
        return id_prod;
    }

    public void setId_prod(String id_prod) {
        this.id_prod.set(id_prod);
    }

    public String getGroup() {
        return group.get();
    }

    public StringProperty groupProperty() {
        return group;
    }

    public void setGroup(String group) {
        this.group.set(group);
    }

    public String getProdname() {
        return prodname.get();
    }

    public StringProperty prodnameProperty() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname.set(prodname);
    }

    public String getCost1() {
        return cost1.get();
    }

    public StringProperty cost1Property() {
        return cost1;
    }

    public void setCost1(String cost1) {
        this.cost1.set(cost1);
    }

    public String getCost2() {
        return cost2.get();
    }

    public StringProperty cost2Property() {
        return cost2;
    }

    public void setCost2(String cost2) {
        this.cost2.set(cost2);
    }

    public String getSheltime() {
        return sheltime.get();
    }

    public StringProperty sheltimeProperty() {
        return sheltime;
    }

    public void setSheltime(String sheltime) {
        this.sheltime.set(sheltime);
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
}
