package prototype.improve;

import prototype.improve.Sheep;

public class Client {

    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom",1,"white");
        Sheep friend = new Sheep("jack",2,"black");
        sheep.friend = friend;
        //浅拷贝 应用数据类型不拷贝 还是指向原来地址
        Sheep sheep1 = (Sheep)sheep.clone();
        Sheep sheep2 = (Sheep)sheep.clone();
        Sheep sheep3 = (Sheep)sheep.clone();
        System.out.println(sheep.friend == sheep1.friend);
    }

}
