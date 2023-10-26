/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author smitj
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @Override
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        Connection cn = ConnectionProvider.getCon();
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM TEST");
            System.out.println("Query Executed");
            while (rs.next()) {
                names.add(rs.getString("sname"));
            }
            System.out.println("returning list");
            return names;
        } catch (SQLException ex) {
            Logger.getLogger(NewSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
