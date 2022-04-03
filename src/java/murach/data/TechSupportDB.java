/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.data;

import java.sql.*;
import java.util.ArrayList;
import murach.business.TechSupport;

/**
 *
 * @author Andrew M
 */
public class TechSupportDB {
    
    // Email is unique to each tech, so Email will be used as identifier
    public static int insert(TechSupport tech) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO TechSupport (Email, FirstName, LastName, PhoneNumber) "
                + "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, tech.getEmail());
            ps.setString(2, tech.getFirstName());
            ps.setString(3, tech.getLastName());
            ps.setString(4, tech.getPhone());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int update(TechSupport tech) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE TechSupport SET "
                + "FirstName = ?, "
                + "LastName = ?, "
                + "PhoneNumber = ? "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, tech.getFirstName());
            ps.setString(2, tech.getLastName());
            ps.setString(3, tech.getPhone());
            ps.setString(4, tech.getEmail());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(TechSupport tech) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM TechSupport "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, tech.getEmail());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean emailExists(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email FROM TechSupport "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    // checks if phone number input is a number
    public static boolean validPhone(String phone) {
        try {
            int thisPhone = Integer.parseInt(phone);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e);
            return false;
        }
    }

    // Returns single TechSupport object from DB with specified email
    public static TechSupport selectTech(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM TechSupport "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            TechSupport tech = null;
            if (rs.next()) {
                tech = new TechSupport();
                tech.setFirstName(rs.getString("FirstName"));
                tech.setLastName(rs.getString("LastName"));
                tech.setPhone(rs.getString("PhoneNumber"));
                tech.setEmail(rs.getString("Email"));
            }
            return tech;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    // Returns ArrayList of TechSupport objects from DB
    public static ArrayList<TechSupport> selectTechs() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM TechSupport";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<TechSupport> techs = new ArrayList<>();
            while (rs.next()) {
                TechSupport s = new TechSupport();
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setPhone(rs.getString("PhoneNumber"));
                s.setEmail(rs.getString("Email"));
                techs.add(s);
            }
            return techs;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
