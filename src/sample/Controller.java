package sample;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller {
    @FXML
    private Label label;
    private float number1;
    private float number2;
    private float   output=0;
    private boolean getOut=false;
    private String  operator="";
    private boolean start=false;
    Model   model=new Model();
    @FXML
    public void processClear(ActionEvent event) {
        String  input=((Button)event.getSource()).getText();
        if(input.equals("OFF")){
            start=false;
            label.setText("");
            number1=0;
            number2=0;
            operator="";
        }
        else if(input.equals("C")){
            label.setText("0");
            number1=0;
            number2=0;
            operator="";
            start=false;

        }
        else if(input.equals("CE")){
            label.setText("0");
            number1=0;
            number2=0;
            operator="";
        }

    }
    @FXML
    public void processChange(ActionEvent event) {
        String  input=((Button)event.getSource()).getText();
        float   temp=Float.parseFloat(label.getText());
        if(input.equals("+/-")){
            if(temp>0 || temp<0){
               temp= model.calculate(temp,-1,"*");
                label.setText(String.valueOf(temp));
            }
            else {
                label.setText(String.valueOf(temp));
            }

        }
        else if(input.equals("√")){
            temp= model.calculate(temp,1,"√");
            label.setText(String.valueOf(temp));
        }
        else if(input.equals("%")){
            temp= model.calculate(temp,1,"%");
            label.setText(String.valueOf(temp));
        }
        else if(input.equals("1/x")){
            temp= model.calculate(temp,1,"1/x");
            label.setText(String.valueOf(temp));
        }


    }

    @FXML
    private void processNumbers(ActionEvent event) {
        if(start==false){
            label.setText("");
            start=true;
        }
            String value = ((Button) event.getSource()).getText();
            label.setText(label.getText() + value);
    }

    @FXML
    private void processOperators(ActionEvent event) {
        String  value=((Button)event.getSource()).getText();
        if(value.equals("=")==false){
            if(operator.equals("")==false){
                return;
            }
            operator=value;

            number1=Float.parseFloat(label.getText());
            label.setText("");

        }
        else {
            if(operator.equals("")){
                return;
            }
            number2=Float.parseFloat(label.getText());
           output= model.calculate(number1,number2,operator);
            //getOut=true;
            label.setText(String.valueOf(output));
            operator="";
        }

    }

    public long calculate(long n1,long n2,String operator)
    {
        switch (operator)
        {
            case"+":
                return n1+n2;

            case "-":
                return n1-n2;
            case "/":
                if (n2==0){
                    return 0;//
                }
                else {
                    return n1/n2;
                }
            case"*":
                return n1*n2;
            default:
                return 0;
        }
    }



}

