package org.helpinghands;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by ocx on 5/31/14.
 */
@Configuration
@EnableMongoRepositories
public class AppConfig extends AbstractMongoConfiguration{
    @Override
    protected String getDatabaseName() {
        return "helpinghands";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Mongo();
    }
}
