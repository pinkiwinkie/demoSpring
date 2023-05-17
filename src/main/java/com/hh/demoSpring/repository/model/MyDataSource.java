package com.hh.demoSpring.repository.model;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class MyDataSource {
    //si no comentas en el pom el runtime, no te deja hacer esto
    public static DataSource getMySQL(){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/accesojava");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("1234");

        return mysqlDataSource;
    }
}
