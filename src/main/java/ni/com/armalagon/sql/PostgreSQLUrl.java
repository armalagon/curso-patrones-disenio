package ni.com.armalagon.sql;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class PostgreSQLUrl implements JdbcUrl {
    private static final String DRIVER_CLASSNAME = "org.postgresql.Driver";
    private static final String PROTOCOL = "jdbc:postgresql:";

    private final String host;
    private final int port;
    private final String database;
    private final Properties props;
    private final String url;

    private PostgreSQLUrl(Builder builder) {
        host = builder.host;
        port = builder.port;
        database = builder.database;
        props = builder.props;

        StringBuilder url = new StringBuilder(PROTOCOL);
        if (StringUtils.isNotBlank(host)) {
            url.append("//").append(host);
        }
        if (port >= 1024) {
            url.append(":").append(port);
        }
        url.append("/");
        if (StringUtils.isNotBlank(database)) {
            url.append(database);
        }
        this.url = url.toString();
    }

    @Override
    public String getDriverClassName() {
        return DRIVER_CLASSNAME;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Properties getProperties() {
        return props;
    }

    public static class Builder {
        private String host = "localhost";
        private int port = 5432;
        private String database;
        private Properties props = new Properties();

        public Builder host(String value) {
            host = value;
            return this;
        }

        public Builder port(int value) {
            port = value;
            return this;
        }

        public Builder database(String value) {
            database = value;
            return this;
        }

        public Builder user(String user) {
            return addProperty("user", user);
        }

        public Builder password(String password) {
            return addProperty("password", password);
        }

        public Builder addProperty(String name, String value) {
            props.setProperty(name, value);
            return this;
        }

        public PostgreSQLUrl build() {
            return new PostgreSQLUrl(this);
        }
    }
}
