package store;

import Entity.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import util.DbConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    @FXML
    private Button BtnAdd;

    @FXML
    private javafx.scene.control.TextField prodname;

    @FXML
    private javafx.scene.control.TextField group;

    @FXML
    private javafx.scene.control.TextField shelftime;

    @FXML
    private javafx.scene.control.TextField count;

    @FXML
    private javafx.scene.control.TextField cost1;

    @FXML
    private javafx.scene.control.TextField cost2;

    private DbConnection dc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dc = new DbConnection();
    }

    public void pressBtnAdd() {
        try {
            Connection conn = dc.Connect();
            String sql1 = "insert into store.products (prodname, cost1, cost2, count, shelftime, GROUP_id) " +
                    "values(?, ?, ?, ?, ?, (select id from store.group where groupname = ?))";
            String sql2 = "insert into store.ss (date, type) values (?, 'Приход')";
            String sql3 = "insert into store.storage (count, cost, PRODUCTS_id, PRODUCTS_GROUP_id, SS_idSS) " +
                    "values (?, ?, (select max(id) from store.products), (select id from store.group where groupname = ?), (select max(idSS) from store.ss))";
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1, prodname.getText());
            ps.setInt(2, Integer.parseInt(cost1.getText()));
            ps.setInt(3, Integer.parseInt(cost2.getText()));
            ps.setInt(4, Integer.parseInt(count.getText()));
            ps.setDate(5, Date.valueOf(shelftime.getText()));
            ps.setString(6, group.getText());
            ps.executeUpdate();

            ps = conn.prepareStatement(sql2);
            ps.setDate(1, Date.valueOf(shelftime.getText()));
            ps.executeUpdate();

            ps = conn.prepareStatement(sql3);
            ps.setInt(1, Integer.parseInt(count.getText()));
            ps.setInt(2, Integer.parseInt(cost1.getText()));
            ps.setString(3, group.getText());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        BtnAdd.getScene().getWindow().hide();
    }
}
