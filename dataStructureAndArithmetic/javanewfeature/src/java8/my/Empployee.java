package java8.my;

public class Empployee {
    private Integer age;
    private String name;
    private Double salary;
    private Status Status;

    public Empployee() {
    }

    public Empployee(Empployee.Status status) {
        Status = status;
    }

    public Empployee(Integer age) {
        this.age = age;
    }

    public Empployee(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Empployee.Status getStatus() {
        return Status;
    }

    public void setStatus(Empployee.Status status) {
        Status = status;
    }

    public enum Status{
        FREE,BUSY,HOLIDAY
    }

    @Override
    public String toString() {
        return "Empployee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
