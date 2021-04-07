package sample;

import java.lang.Math;
public class Model {
    public Model() {
    }
    public  Model(long n1, long n2, String operator){

    }

    public float calculate(float n1, float n2, String operator)
    {
        switch (operator)
        {
            case"+":
                return  n1+n2;
            case "-":
                return n1-n2;
            case "/":
                if (n2==0){
                    return  0;
                }
                return  n1/n2;
            case"*":
                return n1*n2;
            case"√":
                return (float) Math.sqrt(n1);
            case"%":
                return (float) n1/100;
            case"1/x":
                return (float) 1/n1;
            default:
                return  0;

        }
    }
}
