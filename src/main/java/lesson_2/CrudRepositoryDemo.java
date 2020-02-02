package lesson_2;

import java.sql.SQLException;
import java.util.ArrayList;

public class CrudRepositoryDemo {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        try {
            CrudRepository.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CrudRepository.createTable();
        System.out.println("Number of entries: " + CrudRepository.count());
        CrudRepository.save("Ivan", 4);
        CrudRepository.save("Boris", 8);
        CrudRepository.findAll();
        System.out.println("Number of entries: " + CrudRepository.count());

        students.add(new Student("Andrey", 2));
        students.add(new Student("Sergey", 3));
        students.add(new Student("Natalya", 5));
        students.add(new Student("Svetlana", 4));
        students.add(new Student("Pavel", 6));
        CrudRepository.saveAll(students);
        CrudRepository.findAll();
        System.out.println("Number of entries: " + CrudRepository.count());

        System.out.println(CrudRepository.updateNameById(2, "Petr"));
        CrudRepository.findById(2);
        CrudRepository.deleteById(3);
        CrudRepository.findAll();
        System.out.println("Number of entries: " + CrudRepository.count());

//        CrudRepository.dropTable();
        CrudRepository.disconnect();
    }
}
