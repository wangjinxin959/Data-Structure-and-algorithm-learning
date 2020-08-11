package datastructures.hashtab;

public class HashTab {

    private Integer size;
    private EmpLinkedList[] empLinkedListsArray;

    public HashTab(int size) {
        this.size = size;
        empLinkedListsArray = new EmpLinkedList[size];
        for (int i = 0; i < size ; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    public void add(Employee employee){
        int num = hashFun(employee);
        empLinkedListsArray[num].add(employee);
    }

    public void addByOrder(Employee employee){
        int num = hashFun(employee);
        empLinkedListsArray[num].addByOrder(employee);
    }

    public void deleteByid(int id){
        int num = hashFun(new Employee(id,""));
        empLinkedListsArray[num].deleteById(id);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i].list(i);
        }
    }

    public int hashFun(Employee employee){
        return employee.getId() % size;
    }

    public void findById(int id){
        int no = id % size;
        empLinkedListsArray[no].findById(id,no);
    }

    public void reverset(){
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i].reverset();
        }
    }
}
