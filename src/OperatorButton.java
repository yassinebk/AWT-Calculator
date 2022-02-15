import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButton extends Button implements ActionListener {
    String operator;
    AppController appController;

    OperatorButton(String operator,AppController appController){
        super(operator);
        this.operator=operator  ;
        this.appController=appController;
        addActionListener(this);
    }

    OperatorButton(String operator,AppController appController,int xPos,int yPos){
        this.appController=appController;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

//    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        appController.handleOperatorEvent(this.operator);
    }

}
