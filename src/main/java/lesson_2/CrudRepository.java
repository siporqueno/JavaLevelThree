package lesson_2;

import java.sql.*;
import java.util.List;

public class CrudRepository {
    // CREATE, READ (SELECT), UPDATE (INSERT, UPDATE), DELETE
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

// CREATE operations
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS students (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                "    name  TEXT,\n" +
                "    score INTEGER);";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Failed to create table students!");
            e.printStackTrace();
        }
    }

    //    READ operations
    public static int findAll() {
        String sqlSelectAll = "SELECT * FROM students;";
        try {
            int counter = 0;
            ResultSet rs = stmt.executeQuery(sqlSelectAll);
            System.out.println();
            while (rs.next()) {
                counter++;
                System.out.printf("[ id = %d, name = %s, score = %d]\n", rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
            System.out.println();
            return counter;
        } catch (SQLException e) {
            System.out.println("Failed to select all!");
            e.printStackTrace();
            return -1;
        }
    }

    public static int findById(int id) {
        String sqlSelectById = String.format("SELECT * FROM students WHERE id=%d;", id);
        try {
            int counter = 0;
            ResultSet rs = stmt.executeQuery(sqlSelectById);
            if (rs.next()) {
                counter++;
                System.out.printf("[ id = %d, name = %s, score = %d]\n", rs.getInt(1), rs.getString(2), rs.getInt(3));
            } else System.out.printf("No entries with id = %s !\n", id);
            return counter;
        } catch (SQLException e) {
            System.out.println("Failed to select by id!");
            e.printStackTrace();
            return -1;
        }
    }

    //    UPDATE operations
    public static int save(String nam, int scor) {
        String sqlInsert = String.format("INSERT INTO students(name, score) VALUES('%s', %d);", nam, scor);
        try {
            return stmt.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            System.out.println("Failed to insert!");
            e.printStackTrace();
            return -1;
        }
    }

    public static int saveAll(List<Student> students) {
        String sqlInsert = "INSERT INTO students(name, score) VALUES(?, ?);";
        try {
            int counter = 0;
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement(sqlInsert);
            for (Student a : students) {
                pstmt.setString(1, a.getName());
                pstmt.setInt(2, a.getScore());
                pstmt.addBatch();
                counter++;
            }
            pstmt.executeBatch();
            connection.setAutoCommit(true);
            return counter;
        } catch (SQLException e) {
            System.out.println("Failed to insert students");
            e.printStackTrace();
            return -1;
        }
    }

    public static int updateNameById(int id, String name) {
        String sqlUpdateNameById = String.format("UPDATE students SET name='%s'WHERE id=%d;", name, id);
        try {
            return stmt.executeUpdate(sqlUpdateNameById);
        } catch (SQLException e) {
            System.out.println("Failed to update name by id");
            e.printStackTrace();
            return -1;
        }
    }


    //    DELETE operations
    public static void dropTable() {
        String sql = "DROP TABLE IF EXISTS students;";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Failed to drop table students!");
            e.printStackTrace();
        }
    }

    public static void deleteAll() {
        String sqlDeleteAll = "DELETE FROM students";
        try {
            stmt.executeUpdate(sqlDeleteAll);
        } catch (SQLException e) {
            System.out.println("Failed to delete all!");
            e.printStackTrace();
        }
    }

    public static void deleteById(int id) {
        String sqlDeleteById = String.format("DELETE FROM students WHERE id = %d", id);
        try {
            stmt.executeUpdate(sqlDeleteById);
        } catch (SQLException e) {
            System.out.println("Failed to delete all!");
            e.printStackTrace();
        }
    }

    // connect and disconnect from database
    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\resources\\DbHomeWorkLessTwo.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to count total number of rows in the table students
    public static int count() {
        String sqlCount = "SELECT COUNT (*) FROM students;";
        try {
            return stmt.executeQuery(sqlCount).getInt(1);
        } catch (SQLException e) {
            System.out.println("Failed to count rows in the table students!");
            e.printStackTrace();
            return -1;
        }
    }
}
