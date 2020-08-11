package datastructures.hashtab;

import java.util.Scanner;

public class HashTabMain {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(6);
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true){
            System.out.println("add:添加员工");
            System.out.println("list:显示员工列表");
            System.out.println("del:删除员工信息");
            System.out.println("find:查找员工信息");
            System.out.println("exit:退出");
            key = sc.next();
            switch (key){
                case "add":
                    System.out.println("员工id:");
                    int id = sc.nextInt();
                    System.out.println("员工姓名:");
                    String name = sc.next();
                    hashTab.addByOrder(new Employee(id,name));
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "del":
                    System.out.println("员工id:");
                    int id2 = sc.nextInt();
                    hashTab.deleteByid(id2);
                    break;
                case "find":
                    System.out.println("员工id:");
                    int id3 = sc.nextInt();
                    hashTab.findById(id3);
                    break;
                case "reverset":
                    hashTab.reverset();
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                    default:
                        break;
            }

        }
    }

}
