package com.codegym.readwritestudents;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILE_PATH =
            "D:\\codegym\\module-02-advanced-programming-with-java" +
            "\\sources\\lesson-17-io-binary-file-serialization\\students.bin";

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Tý", "Hà Nội"));
        students.add(new Student(2, "Tèo", "Sài Gòn"));
        students.add(new Student(3, "Tồ", "Đà Nẵng"));
        students.add(new Student(4, "Bin", "Quảng Trị"));
        students.add(new Student(5, "Bo", "Cần Thơ"));

        writeToFile(FILE_PATH, students);

        List<Student> studentDataFromFile = readDataFromFile(FILE_PATH);
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }

    public static void writeToFile(String path, List<Student> students) {
        File file = new File(path);

        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
