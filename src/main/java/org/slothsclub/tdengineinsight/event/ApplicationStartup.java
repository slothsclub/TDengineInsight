package org.slothsclub.tdengineinsight.event;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.config.DynamicDataSource;
import org.slothsclub.tdengineinsight.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@Component
@Slf4j
public class ApplicationStartup {
    @Value("${datasource.sqlite.data.dir}")
    String sqliteDataDir;

    @Autowired
    InitService initService;

    @Autowired
    DynamicDataSource dynamicDataSource;

    @PostConstruct
    public void initDatabase() {
        String path = String.format("%s/%s", sqliteDataDir, ".initialized");
        if (initialized(path)) {
            log.info("The database is initialized, load the database file from {}", sqliteDataDir);
            addDefaultDatasource();
            return;
        }
        log.info("Initializing database");
        try {
            addDefaultDatasource();
            initService.init();
            writeCkpt(path);
            log.info("The database file are stored in {}", path);
        } catch (Exception e) {
            log.error("An exception occurred while initializing the database. Error: {}", e.getMessage());
        }
    }

    private boolean initialized(String path) {
        File file = new File(path);
        return file.exists();
    }

    private void writeCkpt(String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(new Date(System.currentTimeMillis()).toString());
        writer.flush();
        writer.close();
    }

    private void addDefaultDatasource() {
        log.info("Create default datasource...");
        try {
            dynamicDataSource.addDataSource("default", dynamicDataSource.defaultDataSource());
        } catch (SQLException e) {
            log.error(e.getMessage());
            System.exit(0);
        }
    }
}
