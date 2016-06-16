package ni.com.armalagon.sql;

import java.util.Properties;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public interface JdbcUrl {
    String getDriverClassName();

    String getUrl();

    Properties getProperties();
}
