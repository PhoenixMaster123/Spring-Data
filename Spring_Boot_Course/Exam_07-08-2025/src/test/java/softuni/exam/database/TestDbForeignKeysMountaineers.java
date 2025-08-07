package softuni.exam.database;
//TestDbForeignKeysMountaineers
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class TestDbForeignKeysMountaineers {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Test
    void testForeignKeysVolcanologists() throws SQLException {
        DatabaseMetaData metaData = getDatabaseMetaData();

        ResultSet mountaineersKeys = metaData.getImportedKeys(null, null, "MOUNTAINS");
        ResultSet mountainsKeys = metaData.getImportedKeys(null, null, "MOUNTAINEERS");

        List<String> actualResult = new ArrayList<>();

        mountaineersKeys.next();
        actualResult.add(mountaineersKeys.getString("PKTABLE_NAME"));
        actualResult.add(mountaineersKeys.getString("FKTABLE_NAME"));
        actualResult.add(mountaineersKeys.getString("PKCOLUMN_NAME"));
        actualResult.add(mountaineersKeys.getString("FKCOLUMN_NAME"));

        mountainsKeys.next();
        actualResult.add(mountainsKeys.getString("PKTABLE_NAME"));
        actualResult.add(mountainsKeys.getString("FKTABLE_NAME"));
        actualResult.add(mountainsKeys.getString("PKCOLUMN_NAME"));
        actualResult.add(mountainsKeys.getString("FKCOLUMN_NAME"));

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("MOUNTAINS");
        expectedResult.add("MOUNTAINEERS");
        expectedResult.add("ID");
        expectedResult.add("CLIMBING_MOUNTAIN_ID");
        expectedResult.add("COUNTRIES");
        expectedResult.add("MOUNTAINS");
        expectedResult.add("ID");
        expectedResult.add("COUNTRY_ID");

        Assertions.assertArrayEquals(expectedResult.stream().sorted().toArray(), actualResult.stream().sorted().toArray());
    }

    private DatabaseMetaData getDatabaseMetaData() throws SQLException {
        DataSource dataSource = getJdbcTemplate().getDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection.getMetaData();
    }
}