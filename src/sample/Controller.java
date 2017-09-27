package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {


    public TextField txtFldProdUpdt;
    public TextField txtFldProdShowFrom;
    public TextField txtFldProdShowTo;
    public TextField txtFldProdDelFrom;
    public TextField txtFldProdDelTo;
    public TextField txtFldProdName;
    public TextField txtFldProdPrice;
    public TextField txtFldProdCateg;
    public TextField txtFldProdDelivId;
    public TextField txtFldProdCharact;

    ProductsHelper prodHlp = new ProductsHelper();

    public void doProdUpdt(ActionEvent actionEvent) {
        String name = txtFldProdName.getText();
        int price;
        if (txtFldProdPrice.getText() == "") {
            price = 0;
        } else {
            price = Integer.parseInt(txtFldProdDelivId.getText());
        }
        String category = txtFldProdCateg.getText();
        int delivId;
        if (txtFldProdDelivId.getText() == "") {
            delivId = 0;
        } else {
            delivId = Integer.parseInt(txtFldProdDelivId.getText());
        }
        String charact = txtFldProdCharact.getText();
        int id = Integer.parseInt(txtFldProdUpdt.getText());
        prodHlp.update(name, price, category, delivId, charact, id);
    }

    public void doProdShowAll(ActionEvent actionEvent) {
    }

    public void doProdShowPart(ActionEvent actionEvent) {
    }

    public void doProdDelOne(ActionEvent actionEvent) {
        int idForDel = Integer.parseInt(txtFldProdDelFrom.getText());
        prodHlp.delete(idForDel);
    }

    public void doProdDelPart(ActionEvent actionEvent) {
        int from = Integer.parseInt(txtFldProdDelFrom.getText());
        int to = Integer.parseInt(txtFldProdDelTo.getText());
        prodHlp.deleteWithLimit(from, to);
    }

    public void doProdDelAll(ActionEvent actionEvent) {
        prodHlp.deleteAll();
    }

    public void doProdAdd(ActionEvent actionEvent) {
        String name = txtFldProdName.getText();
        int price = Integer.parseInt(txtFldProdPrice.getText());
        String category = txtFldProdCateg.getText();
        int delivId = Integer.parseInt(txtFldProdDelivId.getText());
        String charact = txtFldProdCharact.getText();
        prodHlp.preparedInsert(name, price, category, delivId, charact);
    }
}
