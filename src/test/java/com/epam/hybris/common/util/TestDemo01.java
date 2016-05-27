package com.epam.hybris.common.util;

/**
 * Created by Nick_Nie on 5/25/2016.
 */
class StaticTest {
    static int i = 47;
}

class Incrementable {
    static void increment() { StaticTest.i++; }
}

class Cycle {
    public void move(){
        System.out.println("Cycle.move() is calling...");
    }
}

class Bicycle extends Cycle{
    @Override
    public void move(){

        System.out.println("Bicycle.move() is calling...");
    }
}

class Tricycle extends Cycle{
    @Override
    public void move(){
        super.move();
        System.out.println("Tricycle.move() is calling...");
    }
}

class Employee {
    public String test;
    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number) {
        System.out.println("Employee contructor");
        this.name = name;
        this.test = name;
        this.address = address;
        this.number = number;
    }
    public void mailCheck() {
        System.out.println("?????? " + this.name
                + " " + this.address);
    }
    public String toString() {
        return name + " " + address + " " + number;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    public int getNumber() {
        return number;
    }
}
public class TestDemo01 {
    void move(){
        System.out.println("TestDemo01.move() is calling...");
    }
    static void ride(Cycle c){
        c.move();
    }
    public static void main(String[] args) {
//        System.out.println("before: " + StaticTest.i);
//        Incrementable.increment();
//        System.out.println("after: " + StaticTest.i);
        ride(new Cycle());
        ride(new Bicycle());
        ride(new Tricycle());
        Employee empl = new Employee("nick","Addrs",12);
        System.out.println(empl.getName());
        System.out.println(empl.test);
    }
}
