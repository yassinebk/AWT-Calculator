import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends Button implements ActionListener {
    AppController appController;
    int buttonValue;

    public int getButtonValue() {
        return buttonValue;
    }


    public void setButtonValue(int buttonValue) {
        this.buttonValue = buttonValue;
    }

    NumberButton(String buttonLabel,AppController appController){
        super(buttonLabel);
        this.appController= appController;
        this.addActionListener(this);
        setButtonValue(Integer.parseInt(buttonLabel));
        setSize(300,200);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }


//    @Override
//    protected void processActionEvent(ActionEvent actionEvent) {
//        this.appController.numericButtonEventHandler(this);
//    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("button clicked");
        this.appController.numericButtonEventHandler(this);
    }
}
