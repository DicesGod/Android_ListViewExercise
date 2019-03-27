package model;

public class Employee extends Person {
    private  String empolyeeId;
    private String job;
    private int salary;

    public Employee(String name, int age, String empolyeeId, String job, int salary) {
        //super(name, age);
        this.empolyeeId = empolyeeId;
        this.job = job;
        this.salary = salary;
    }

    public String getEmpolyeeId() {
        return empolyeeId;
    }

    public void setEmpolyeeId(String empolyeeId) {
        this.empolyeeId = empolyeeId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\t" + getName();
    }
}
