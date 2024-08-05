package be.digitcom.streams.models;

public class Employee {
    public Employee(int id, String name, double fortune) {
        this.id = id;
        this.name = name;
        this.fortune = fortune;
    }

    private int id;
    private String name;
    private double fortune;

    public void salaryIncrement(double amount) {
        this.fortune += amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFortune() {
        return fortune;
    }

    public void setFortune(double fortune) {
        this.fortune = fortune;
    }
}
