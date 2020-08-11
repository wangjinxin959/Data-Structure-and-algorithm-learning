package datastructures.stack;


import java.util.*;

public class PolishNotaion {

    public static void main(String[] args) {
        //double v = polishCal("1 2 3 + 4 * + 5 -");
        //System.out.println(v);
        String nifix = "1+((2+3)*4)-5";
        /*List<String> list = nifixToList(nifix);
        for (String s : list) {
            System.out.print(s+" ");
        }*/

        String s = nifixTransSuffix(nifix);
        System.out.println(s);
    }

    public static List<String> nifixToList(String nifix){
        List<String> list = new ArrayList<>();
        int index = 0;
        char c = ' ';
        String str = "";
        while ( index < nifix.length()){
            if((c = nifix.charAt(index)) < 48 || (c = nifix.charAt(index)) > 57){
                list.add(c+"");
                index ++;
            }else{
                str = "";
                while(index < nifix.length() && (c = nifix.charAt(index)) >= 48 && (c=nifix.charAt(index)) <= 57){
                        str += c;
                        index++;
                }
                list.add(str);
            }

        }

        return list;
    }

    //将中缀表达式转换为后缀表达式 1+((2+3)*4)-5
    public static String nifixTransSuffix(String nifix){
        Stack<String> s = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        List<String> list = nifixToList(nifix);
        StringBuilder sb = new StringBuilder();

        for (String item : list) {
            if(item.matches("\\d+")){
                queue.offer(item);
            }else if(item.equals("(")){
                s.push(item);
            }else if(item.equals(")")){
                while(!s.peek().equals("(")){
                    queue.offer(s.pop());
                }
                s.pop();
            }else{
                while(s.size() > 0 && priority(item) <= priority(s.peek())){
                    queue.offer(s.pop());
                }
                s.push(item);
            }
        }

        while(s.size() > 0){
            queue.offer(s.pop());
        }

        while (!queue.isEmpty()){
            sb.append(queue.poll()+" ");
        }

        return sb.toString();
    }





    //计算逆波兰表达式的结果 "1 2 3 + 4 * + 5 -"
    public static double polishCal(String expression){

        String[] split = expression.split(" ");
        Stack<String> stack = new Stack<>();
        List<String> list = Arrays.asList(split);
        for (String s : list) {
            if(s.matches("\\d+")){
                stack.push(s);
            }else{
                double d1 = numCal(Double.parseDouble(stack.pop()), Double.parseDouble(stack.pop()), s);
                stack.push(String.valueOf(d1));
            }
        }
        return Double.parseDouble(stack.pop());
    }

    public static double numCal(double num1,double num2,String oper){
        double result = 0.0;
        switch (oper){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num2 / num1;
                break;
        }
        return result;

    }

    public static int priority(String oper){
        if(oper.equals("+") || oper.equals("-")){
            return 0;
        }
        if(oper.equals("*") || oper.equals("/")){
            return 1;
        }
        return -1;
    }

}


