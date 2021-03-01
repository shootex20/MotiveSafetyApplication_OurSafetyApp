/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import domain.Manual;

/**
 *
 * @author 813033
 */
public class ManualDB {
    
    
    public ArrayList<Manual> getAll() throws Exception {
        
    ArrayList<Manual> manuals = new ArrayList<>();
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    Connection connection = connectionPool.getConnection();
    PreparedStatement statement = null;
    ResultSet result = null;
    String sql = "SELECT * FROM manual";
    
    try {
        statement = connection.prepareStatement(sql);
        result = statement.executeQuery();
        while(result.next()){
            //to be edited
        }
    }
        finally {
        DBUtil.closeResultSet(result);
        DBUtil.closePreparedStatement(statement);
        connectionPool.freeConnection(connection);
    }
    
    return manuals;
  
    }

}
