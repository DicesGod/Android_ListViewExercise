package model;

public class Student extends Person {
    private String studentId;
    private String program;


    public Student(String name, int age, String studentId, String program) {
        //super(name, age);
        this.studentId = studentId;
        this.program = program;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "\t" + getName();
    }
}
