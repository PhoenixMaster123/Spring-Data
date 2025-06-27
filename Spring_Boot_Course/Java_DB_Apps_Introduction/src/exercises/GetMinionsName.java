package exercises;

import java.sql.*;
import java.util.Scanner;

public class GetMinionsName {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db",
                "root",
                "12345"
        );
        PreparedStatement statement = connection.prepareStatement(
                """
                        SELECT m.name
                        FROM minions AS m
                        JOIN minions_villains AS mv ON m.id = mv.minion_id
                        WHERE mv.villain_id = ?
                        ORDER BY m.id;""");

        statement.setInt(1, villainId);
        System.out.printf("Villain with ID %d:\n", villainId);
        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.isBeforeFirst()) {
            System.out.println("<no minions>");
        } else {
            while (resultSet.next()) {
                String minionName = resultSet.getString("name");
                System.out.println(minionName);
            }
        }
    }
}
