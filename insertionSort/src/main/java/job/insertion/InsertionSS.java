package job.insertion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertionSS {
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j;
            for (j = i - 1; j >=0 && array[j] > key; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 0};
        array = insertionSort(array);
        for (int j : array) {
            System.out.print(j);
        }
    }

    public void f() {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/myDb", "user1", "pass")) {
            Statement statement = con.createStatement();
            String query = "SELECT * FROM LAPTOP WHERE NAME = 'asdasdasd\' or 1 = 1 and \'\' = \''";
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            statement.executeQuery(query + s + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // asdasdasd\' or 1 = 1 and '' = '


    }
}