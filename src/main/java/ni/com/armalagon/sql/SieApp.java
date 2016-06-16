package ni.com.armalagon.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class SieApp {

    public static void main(String... args) {
        JdbcUrl url = new PostgreSQLUrl.Builder()
                .database("sie")
                .addProperty("user", "champu")
                .addProperty("password", "champu")
                .addProperty("ApplicationName", "sie")
                .build();
        System.out.println("************ url: " + url.getUrl());

//            System.out.printf("Driver: %s%n", cnn.getMetaData().getDriverName());
//            System.out.printf("Motor: %s-%s%n", cnn.getMetaData().getDatabaseProductName(), cnn.getMetaData().getDatabaseProductVersion());

        try (
                Connection cnn = JdbcUtils.open(url);
                Statement stmt = cnn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from public.novedad");
                ) {
            while (rs.next()) {
                System.out.printf("Nss %d, tipo: %d, %b%b%n", rs.getInt("nss"), rs.getInt("tipo_novedad")
                        , rs.getBoolean("semana1"), rs.getBoolean("semana2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
