package datastructures.stack;


import java.util.Stack;

public class ArrayStackMain {

    public static void main(String[] args) {

        String expression = "500+8*30-40";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        int index = 0;
        char ch = ' ';
        int count = 0;
        int res = 0;
        String str = "";
        while(index < expression.length()){
            ch = expression.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch)){//如果是运算符
               /* if(count > 1){
                    for (int i = 0; i < count; i++) {
                        res += (int)numStack.pop()*(Math.pow(10,i));
                    }
                    System.out.println(res);
                    numStack.push(res);
                }
                res = 0;
                count = 0;*/
                if(operStack.isEmpty()){//如果运算符栈为空
                    operStack.push(ch);
                }else{//不为空，比较两个运算符优先级
                    //如果此运算符的优先级小于等于运算符栈顶的运算符的优先级
                    if(operStack.priority(ch) <= operStack.priority((char)operStack.peek())){
                        //计算数字栈结果
                        int result = operStack.calculator((int) numStack.pop(), (int) numStack.pop(), (char) operStack.pop());
                        numStack.push(result);
                        operStack.push(ch);
                    }else{//此运算符优先级大于运算符栈顶的运算符的优先级
                        operStack.push(ch);
                    }
                }

            }else{//如果是数字
               /* count++;
                numStack.push(Integer.parseInt(String.valueOf(ch)));
                if(index == expression.length()-1 && count > 1){
                    for (int i = 0; i < count; i++) {
                        res += (int)numStack.pop()*(Math.pow(10,i));
                    }
                    numStack.push(res);
                }*/

               str += ch;

               if(index == expression.length()-1){
                   numStack.push(Integer.parseInt(str));
               }else{
                   if(numStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                       numStack.push(Integer.parseInt(str));
                       str = "";
                   }
               }

            }

            index ++;
        }

        while(!operStack.isEmpty()){
            int result = operStack.calculator((int) numStack.pop(), (int) numStack.pop(), (char) operStack.pop());
            numStack.push(result);
        }

        System.out.println("运算结果为："+numStack.pop());

    }

}
