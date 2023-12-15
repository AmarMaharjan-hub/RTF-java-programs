package newjavaprograms;
import java.util.Stack;
public class BracketBalance {

    public float processExpression(String expression) throws Exception {
        Stack stack=new Stack();
        for(int i=0; i < expression.length();i++){
            if(!stack.isEmpty()){
                if(expression.charAt(i) == ')' || expression.charAt(i) == '}' || expression.charAt(i) == ']'){
                    float firstOperand = Float.parseFloat(String.valueOf(stack.pop()));
                    char operator = (char) stack.pop();
                    float secondOperand = Float.parseFloat(String.valueOf(stack.pop()));
                    stack.pop();//popping opening bracket
                    float result = calculate(firstOperand, operator, secondOperand);
                    stack.push(result);
                    continue;
                }
            }
            stack.push(expression.charAt(i));
        }
        processRemainingExpressionSec(stack);
        return (float) stack.pop();
    }
    public float calculate(float number1, char operator, float number2) throws Exception {
        switch(operator){
            case '+':

                return(number2 + number1);

            case '-':

                return(number2 - number1);

            case '*':

                return(number2 * number1);

            case '/':

                return(number2 / number1);

            default :
                throw new Exception("operator not found");
        }
    }
    public void isBalance(Stack stack){
        if(stack.isEmpty()){
            System.out.println("Balanced");
        }else{
            System.out.println("Not Balanced");
        }
    }
    public void processRemainingExpressionSec(Stack stack) throws Exception {
        if(stack.size() == 3){
            float number2 = Float.parseFloat(String.valueOf(stack.pop()));
            char operator = (char)stack.pop();
            float number1 = Float.parseFloat(String.valueOf(stack.pop()));
//            stack.push('a');
            stack.push(calculate(number2,operator, number1));
//            stack = calculate(stack, Float.parseFloat(String.valueOf(stack.pop())), (char)stack.pop(), Float.parseFloat(String.valueOf(stack.pop())));
        }
    }
    public static void main(String[] args) throws Exception {
        BracketBalance balancer = new BracketBalance();
        
//        String expression="[{(2+2)+(5-4)}/5]";//ans 1
        String expression="[(7-3)*(4+4)]-[3+{(2/2)*(4+5)}]";//ans 20
//        String expression = "(5-3)+(3-2)";//ans 3
//        String expression = "[1+{1+(1+1)}]";//ans 4
//        String expression = "[{()}]";
//        String expression = "[(]";
//        String expression = "({[]})";
//        String expression = "[{}]";

//        String ex = "[" + expression + "]";

        System.out.println("Expression: " + expression);
        float result = balancer.processExpression(expression);
        System.out.println("Result: " + result);
//        balancer.isBalance(stack);
    }
}