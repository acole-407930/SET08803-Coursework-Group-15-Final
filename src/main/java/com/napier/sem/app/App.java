package com.napier.sem.app;

import com.napier.sem.util.DBConnection;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {

        DBConnection db = new DBConnection();

        Connection con = db.connect();

        db.disconnect(con);
    }
}