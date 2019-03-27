package com.lasalle.listofpeople;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import model.Employee;
import model.Person;
import model.Student;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    TextView textViewId;
    TextView textViewAge;
    TextView textViewJob;
    TextView textViewSalary;
    TextView textViewProgram;
    Button buttonStudent;
    Button buttonEmployee;
    Button buttonAll;
    ListView listViewPeople;
    ArrayList<Student> listStudents;
    ArrayList<Employee> listEmployees;
    ArrayList<Person> listPerson;
    ArrayAdapter<Person> personArrayAdapter;
    ArrayAdapter<Employee> employeeArrayAdapter;
    ArrayAdapter<Student> studentArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    private void initialize() {
        textViewId = findViewById(R.id.textViewShowId);
        textViewAge = findViewById(R.id.textViewShowAge);
        textViewJob = findViewById(R.id.textViewShowJob);
        textViewSalary = findViewById(R.id.textViewShowSalary);
        textViewProgram = findViewById(R.id.textViewShowProgram);
        buttonStudent = findViewById(R.id.buttonStudent);
        buttonEmployee = findViewById(R.id.buttonEmployee);
        buttonAll = findViewById(R.id.buttonAll);
        buttonStudent.setOnClickListener(this);
        buttonEmployee.setOnClickListener(this);
        buttonAll.setOnClickListener(this);
        listViewPeople = findViewById(R.id.listViewPeople);
        listViewPeople.setOnItemClickListener(this);
        listStudents = new ArrayList<>();
        listEmployees = new ArrayList<>();
        listPerson = new ArrayList<>();
        fillUpStudent();
        fillUpEmployee();

    }


    @Override
    public void onClick(View v) {
        cleanTextViews();
        switch(v.getId()){
            case R.id.buttonStudent:
                studentArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listStudents);
                listViewPeople.setAdapter(studentArrayAdapter);
                break;
            case R.id.buttonEmployee:
                employeeArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listEmployees);
                listViewPeople.setAdapter(employeeArrayAdapter);
                break;
            case R.id.buttonAll:
                personArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listPerson);
                listViewPeople.setAdapter(personArrayAdapter);
                break;
            default:
                break;
        }

    }



    private void fillUpStudent() {
        listStudents.add(new Student("Philip",22,"ad1234","Marketing"));
        listStudents.add(new Student("Stefan",24,"ad4353","Computers Science"));
        listStudents.add(new Student("Loise",20,"ad3322","Medicine"));
        listStudents.add(new Student("Carlos",19,"ad5632","Marketing"));
        listStudents.add(new Student("Emilie",28,"ad15555","Marketing"));
        listStudents.add(new Student("Nicole",35,"ad7865","Computer Science"));
        listPerson.addAll(listStudents);
    }


    private void fillUpEmployee() {
        listEmployees.add(new Employee("Andrew", 22, "tt1234", "Engineer", 100000));
        listEmployees.add(new Employee("Julian", 45, "tt4353", "Networking", 70000));
        listEmployees.add(new Employee("Brandon", 20, "tt3322", "Medicine", 150000));
        listEmployees.add(new Employee("Carlos", 19, "tt5632", "Engineer", 90000));
        listEmployees.add(new Employee("Camila", 28, "tt15555", "Engineer", 95000));
        listEmployees.add(new Employee("Jaime", 35, "tt7865", "Carpenter", 70000));
        listPerson.addAll(listEmployees);

    }

    private void cleanTextViews(){
        textViewId.setText("");
        textViewAge.setText("");
        textViewProgram.setText("");
        textViewId.setText("");
        textViewJob.setText("");
        textViewSalary.setText("");
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("------------->",parent.getAdapter().getItem(position).getClass().toString());
        if (parent.getAdapter().getItem(position).getClass().equals(Student.class)){
            textViewId.setText(listStudents.get(position).getStudentId());
            textViewAge.setText(String.valueOf(listStudents.get(position).getAge()));
            textViewProgram.setText(listStudents.get(position).getProgram());
        }else if (parent.getAdapter().getItem(position).getClass().equals(Employee.class)){
            textViewId.setText(listPerson.get(position).getId());
            textViewAge.setText(String.valueOf(listPerson.get(position).getAge()));
            textViewJob.setText(listPerson.get(position).getJob());
            textViewSalary.setText(String.valueOf(listPerson.get(position).getSalary()));
        }


    }
}
