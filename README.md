CAMBIEN!!!

package util;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connection {

    private java.sql.Connection connection  = null;

    static final String USER = "root"; <--
    static final String PASS = "megamisama"; <---
    static final String DB_URL = "jdbc:mysql://localhost/proyecto4"; <---


    public Connection() {

