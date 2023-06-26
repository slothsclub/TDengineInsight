package org.slothsclub.tdengineinsight.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class DynamicDataSource {
    @Value("${datasource.sqlite.data.dir}")
    String sqliteDataDir;
    public final static String dbFile = "tdengineinsight.db";
    public final static String dbName = "tdengineinsight";
    public final static String driverClassName = "com.taosdata.jdbc.rs.RestfulDriver";

    private final ThreadLocal<String> current = new ThreadLocal<>();
    private final Map<Object, Object> dataSources = new ConcurrentHashMap<>();

    private AbstractRoutingDataSource multiDataSource;

    public DynamicDataSource(DataSourceProperties properties) {
    }

    @Bean
    public DataSource dataSource() {
        multiDataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return current.get();
            }
        };
        multiDataSource.setTargetDataSources(dataSources);
        multiDataSource.setDefaultTargetDataSource(defaultDataSource());
        multiDataSource.afterPropertiesSet();
        return multiDataSource;
    }

    public void addDataSource(String id, DataSource dataSource) throws SQLException {
        try (Connection c = dataSource.getConnection()) {
            dataSources.put(id, dataSource);
            multiDataSource.afterPropertiesSet();
        }
    }

    public void setCurrent(String id) {
        current.set(id);
    }

    public String getCurrent() {
        return current.get();
    }

    public void clear() {
        current.remove();
    }

    public boolean hasInstance(String id) {
        return dataSources.get(id) != null;
    }

    public DataSource defaultDataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(String.format("jdbc:sqlite:%s/%s", sqliteDataDir, dbFile));
        dataSource.setDatabaseName(dbName);
        return dataSource;
    }
}
