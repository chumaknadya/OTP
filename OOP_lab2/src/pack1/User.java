package pack1;

public class User {
    private String name;
    private String surname;
    private int age;
    public User(String _name,String _surname,int _age) {
        name = _name;
        surname = _surname;
        age = _age;
    }
    public User(String _name,String _surname) {
        name = _name;
        surname = _surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
