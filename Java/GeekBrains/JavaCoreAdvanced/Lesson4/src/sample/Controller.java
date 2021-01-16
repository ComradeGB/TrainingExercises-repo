package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;

public class Controller {

    @FXML
    private TextField textMessage;

    @FXML
    private TextArea textChat;

    public void textMessageAction(ActionEvent actionEvent) {
        buttonSendAction(actionEvent);
    }

    public void buttonRemoveAction(ActionEvent actionEvent) {
        textChat.setText(null);
    }

    public void buttonSendAction(ActionEvent actionEvent) {
        textChat.appendText(textMessage.getText()+"\n"+"------------------"+"\n");
        textMessage.setText(null);
    }
}
