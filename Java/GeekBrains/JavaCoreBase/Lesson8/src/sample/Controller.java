package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller {
private static int random = (int) (Math.random() * 10);
private static int  i = 3;
        @FXML
        private TextField inputNumber;

        @FXML
        private Label text;

        @FXML
        void exit(ActionEvent event) {
                System.exit(0);
        }

        @FXML
        void reset(ActionEvent event) {
                random = (int) (Math.random() * 10);
                i = 3;
                text.setText("");
        }

        @FXML
        void startAction(ActionEvent event) {
                int number = Integer.parseInt(inputNumber.getText());
                if ( (i > 1) && (number == random)){
                                text.setText("Вы отгадали, поздравляем)");
                              }
                else if ((i > 1) && (number != random)){
                                text.setText("Осталось "+i+" попытки");
                        i--;}
                else{
                if (i==1)  text.setText("Вы проиграли( \nПравильный ответ - "+random);}
        }



}
