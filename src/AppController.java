
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class AppController {
    String label ;
    Label labelComp;
    ArrayList<String> passedOps;
    boolean toClearInput;
    final String[] operators = {"/", "+", "-", "%","="};
    AppController(){
        passedOps=new ArrayList<>();
        label="";
        labelComp = new Label();
        labelComp.setSize(150,60);

    }

    public void numericButtonEventHandler(NumberButton btn){
        if(label.length()!=0&& toClearInput){labelComp.setText("");label="";toClearInput=false;}
       label+=btn.getButtonValue();
        System.out.println("label+ "+label);
       labelComp.setText(label);
    }

    public void handleOperatorEvent(String operator) {
        if(Objects.equals(operator, "=")){parseLabelToResult();return;}
        if(label.length()==0&& !Objects.equals(operator, "-")) {handleError();return;}
        if(passedOps.size()==1){return;}
        label+=operator;
        labelComp.setText(label);
        passedOps.add(operator);
    }
    public void handleError(){
        labelComp.setText("ERROR");
    }

    public void parseLabelToResult(){
        StringBuilder temp= new StringBuilder();
        int firstOperand =0;
       for(int i=0 ;i<label.length();i++ ){
           if(Character.isDigit(label.charAt(i))) {
               temp.append(label.charAt(i));
           }
           else if(Character.toString(label.charAt(i)).equals(passedOps.get(0))){
               firstOperand=Integer.parseInt(temp.toString());
               temp.delete(0,temp.length()+1);
           }
      }

       int secondOperand=Integer.parseInt(temp.toString());

       switch(passedOps.get(0)){
           case "+":
               labelComp.setText(String.valueOf((firstOperand+secondOperand)));
               break;
           case "-":
               if(secondOperand==0)
                   labelComp.setText(String.valueOf((-firstOperand)));
               else
               labelComp.setText(String.valueOf((firstOperand+secondOperand)));
               break;
           case "/":
               if(secondOperand==0){handleError();}
               else{
                   labelComp.setText(String.valueOf(firstOperand/secondOperand));
               }
               System.out.printf("%s %d %d","here",firstOperand,secondOperand);
               break;
           case "%":
               labelComp.setText(String.valueOf(firstOperand%secondOperand));
               break;
           case "*":
               labelComp.setText(String.valueOf(firstOperand*secondOperand));
               break;
           default:
               handleError();
       }
       passedOps.clear();
       toClearInput=true;
    }

}
