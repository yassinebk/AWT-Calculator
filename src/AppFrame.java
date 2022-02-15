import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class AppFrame extends Frame implements ActionListener, WindowListener {

  final String[] operators = {"/", "+", "-", "%","*","=",};
  ArrayList<NumberButton> numberButtons;
  ArrayList<OperatorButton> operatorButtons;
  AppController appController;
  Label label;
  ArrayList<Panel> calculatorPanels;
  Panel mainPanel;


  AppFrame() {
    addWindowListener(this);
    calculatorPanels = new ArrayList<>();
    appController=new AppController();
    numberButtons =new ArrayList<>();
    mainPanel=new Panel();
    mainPanel.setLayout(new GridLayout(7,1));



    for (int i = 0; i < 10; i++) {
      if(i%3==0){
        Panel panel = new Panel();
        panel.setLayout(new FlowLayout());
        int i1 = i / 3;
        System.out.println("i1"+i1);
        panel.setVisible(true);
        calculatorPanels.add(panel);
      }
      NumberButton btn = new NumberButton(Integer.toString(i),appController);

      numberButtons.add(btn);
      calculatorPanels.get(calculatorPanels.size()-1).add(btn);
    }

    calculatorPanels.add(new Panel());
    for (String operator : operators) {
      operatorButtons= new ArrayList<>();
      OperatorButton btn = new OperatorButton(operator,appController);
      operatorButtons.add(btn);
      calculatorPanels.get(calculatorPanels.size()-1).add(btn);
    }

    for (Panel panel: calculatorPanels){
      mainPanel.add(panel);
    }

    Font font = new Font("Arial Black",Font.PLAIN,30);
    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    setFont(font);
    this.add(mainPanel);
    this.add(appController.labelComp);
    this.setLocationRelativeTo(null);
    this.setSize(900,750);
    this.setResizable(true);
    this.setVisible(true);
  }

    private void setWindowKeyListener(){}

    @Override
    public void actionPerformed(ActionEvent actionEvent) {}

    @Override
    public void windowOpened(WindowEvent windowEvent) {}

    @Override
    public void windowClosing(WindowEvent windowEvent) {
    dispose();
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {}

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {}

    @Override
    public void windowActivated(WindowEvent windowEvent) {}

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {}
  }
