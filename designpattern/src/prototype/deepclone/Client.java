package prototype.deepclone;

public class Client {

    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom",1,"white");
        Friend friend = new Friend();
        sheep.friend = friend;

        Sheep clone = (Sheep) sheep.deepClone();
        System.out.println(clone.friend == sheep.friend);
    }

}
