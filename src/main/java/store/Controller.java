package store;

import Entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import util.DbConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView<Product> tableProduct;
    @FXML
    private TableColumn<Product, Integer> C1;
    @FXML
    private TableColumn<Product, String> C2;
    @FXML
    private TableColumn<Product, String> C3;
    @FXML
    private TableColumn<Product, Integer> C4;
    @FXML
    private TableColumn<Product, Integer> C5;
    @FXML
    private TableColumn<Product, Calendar> C6;
    @FXML
    private TableColumn<Product, Integer> C7;

    private ObservableList<Product> data;

    @FXML
    private ResourceBundle resource;
    @FXML
    private URL location;
    private DbConnection dc;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dc = new DbConnection();
    }

    @FXML
    public void pressBtnCom() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/coming.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    public void pressBtnSel() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/selling.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    public void pressBtnAD() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/addd.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    public void pressBtnLoad() {
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("select * from store.products");
            while (rs.next()) {
                data.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        C1.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id_prod"));
        C2.setCellValueFactory(new PropertyValueFactory<Product, String>("group"));
        C3.setCellValueFactory(new PropertyValueFactory<Product, String>("prodname"));
        C4.setCellValueFactory(new PropertyValueFactory<Product, Integer>("cost1"));
        C5.setCellValueFactory(new PropertyValueFactory<Product, Integer>("cost2"));
        C6.setCellValueFactory(new PropertyValueFactory<Product, Calendar>("sheltime"));
        C7.setCellValueFactory(new PropertyValueFactory<Product, Integer>("count"));

        tableProduct.setItems(null);
        tableProduct.setItems(data);
    }

    public void pressBtnDel() {
        try {
            Connection conn = dc.Connect();
            Product product = tableProduct.getSelectionModel().getSelectedItem();
            String sql1 = "SET FOREIGN_KEY_CHECKS = 0";
            String sql2 = "insert into store.ss (date, type) values (now(), 'Расход')";
            String sql3 = "insert into store.selling (count, cost, PRODUCTS_id, PRODUCTS_GROUP_id, SS_idSS) " +
                    "values ((select count from store.products where id = ?), (select cost2 from store.products where id = ?), ?, " +
                    "(select GROUP_id from store.products where id = ?)," +
                    "(select max(idSS) from store.ss))";
            String sql4 = "delete from store.products where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.executeUpdate();
            ps = conn.prepareStatement(sql2);
            ps.executeUpdate();
            ps = conn.prepareStatement(sql3);
            ps.setString(1, product.getId_prod());
            ps.setString(2, product.getId_prod());
            ps.setString(3, product.getId_prod());
            ps.setString(4, product.getId_prod());
            ps.executeUpdate();
            ps = conn.prepareStatement(sql4);
            ps.setString(1, product.getId_prod());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
