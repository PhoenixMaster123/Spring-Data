import java.sql.*;

public class GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db",
                "root",
                "12345"
        );
        PreparedStatement statement = connection.prepareStatement(
                """
                        Select v.name, COUNT(mv.minion_id) AS minion_count
                        from villains AS v
                        JOIN minions_db.minions_villains mv on v.id = mv.villain_id
                        GROUP BY v.id
                        HAVING COUNT(mv.minion_id) > 15
                        ORDER BY v.id DESC;""");

        System.out.println("Villains with more than 15 minions:");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString("name");
            int minionCount = resultSet.getInt("minion_count");
            System.out.printf("%s %d%n", villainName, minionCount);
        }
    }
}
