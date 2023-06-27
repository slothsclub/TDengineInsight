package org.slothsclub.tdengineinsight.service;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.SqliteService;
import org.slothsclub.tdengineinsight.bind.Instance;
import org.slothsclub.tdengineinsight.config.DynamicDataSource;
import org.slothsclub.tdengineinsight.mapper.InstanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class InstanceService extends SqliteService {
    public final static String[] connectionProperties = {"username", "password", "batchfetch", "batchErrorIgnore", "httpConnectTimeout", "httpSocketTimeout", "messageWaitTimeout"};
    public final static HashMap<String, String> connectionPropertiesAlias = new HashMap<>() {{
        put("username", "user");
    }};

    @Autowired
    InstanceMapper instanceMapper;

    @Autowired
    DynamicDataSource dynamicDataSource;

    public boolean insert(Instance model) {
        return instanceMapper.insert(model) > 0;
    }

    public List<Instance> selectAll() {
        return instanceMapper.selectAll();
    }

    public Instance detail(String id) {
        return instanceMapper.findOne(id);
    }

    public boolean update(String id, Instance model) {
        model.setId(id);
        return instanceMapper.update(model) > 0;
    }

    public boolean delete(String id) {
        return instanceMapper.delete(id) > 0;
    }

    public boolean createDataSourceIfMissing(Instance instance) {
        if (instance == null) {
            return false;
        }

        if (dynamicDataSource.hasInstance(instance.getId())) {
            return true;
        }

        try {
            List<String> args = new ArrayList<String>();
            Arrays.stream(connectionProperties).forEach(k -> {
                Field field = null;
                try {
                    field = instance.getClass().getDeclaredField(k);
                    field.setAccessible(true);
                    String property = connectionPropertiesAlias.getOrDefault(k, k);
                    args.add(String.format("%s=%s", property, field.get(instance)));
                } catch (NoSuchFieldException | IllegalAccessException ex) {
                    log.error(ex.getMessage());
                }
            });

            String url = String.format("jdbc:TAOS-RS://%s:%d/?%s", instance.getHost(), instance.getPort(), String.join("&", args.toArray(new CharSequence[0])));
            DataSource dataSource = DataSourceBuilder.create()
                    .driverClassName(DynamicDataSource.driverClassName)
                    .url(url)
                    .build();
            dynamicDataSource.addDataSource(instance.getId(), dataSource);
            return true;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return false;
    }
}
