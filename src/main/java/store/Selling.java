package store;

import Entity.Sell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.DbConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Selling implements Initializable {
    @FXML
    private TableView<Sell> tableSelling;
    @FXML
    private TableColumn<Sell, Integer> C1;
    @FXML
    private TableColumn<Sell, Integer> C2;
    @FXML
    private TableColumn<Sell, Integer> C3;
    @FXML
    private TableColumn<Sell, Integer> C4;
    @FXML
    private TableColumn<Sell, Integer> C5;

    private ObservableList<Sell> data;

    private DbConnection dc;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dc = new DbConnection();
    }

    public void pressBtnLoad() {
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("select * from store.selling");
            while (rs.next()) {
                data.add(new Sell(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        C1.setCellValueFactory(new PropertyValueFactory<Sell, Integer>("id_sell"));
        C4.setCellValueFactory(new PropertyValueFactory<Sell, Integer>("count"));
        C3.setCellValueFactory(new PropertyValueFactory<Sell, Integer>("cost"));
        C2.setCellValueFactory(new PropertyValueFactory<Sell, Integer>("prod_id"));
        C5.setCellValueFactory(new PropertyValueFactory<Sell, Integer>("group_id"));

        tableSelling.setItems(null);
        tableSelling.setItems(data);
    }
}
