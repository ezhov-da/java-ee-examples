package ru.ezhov.ejb.book.test;

import javax.ejb.Startup;
import javax.inject.Singleton;

@Singleton
@Startup
@javax.annotation.sql.DataSourceDefinition(
        className = "org.h2.Driver",
        name = "java:global/jdbc/ezhov",
        user = "admin",
        password = "admin",
        databaseName = "TEST"
)
public class DataSourceDefinition {




}
