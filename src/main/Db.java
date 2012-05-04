package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db
{
 final String url = "jdbc:postgresql://localhost:5432/";
 final String dbName = "postgres";
 final String driver = "org.postgresql.Driver";
 final String userName = "postgres"; 
 final String password = "soareceturbat";
 
 Connection conn;
 
 Db()
 {

 }
 
 void conn()
 {
  try
  {
   Class.forName(driver).newInstance();
   conn = DriverManager.getConnection(url+dbName,userName,password);
  } catch(Exception e) { System.out.println("conn ex"); /*should exit*/ }
 }

 void disconn()
 {
  try
  {
   conn.close();
  } catch(Exception e) { System.out.println("disconn ex"); /*should exit*/ }
 }
 
 void nonQuery(String str)
 {
  try
  {
   conn.createStatement().executeUpdate(str);
  } catch (SQLException e) { e.printStackTrace(); }
 }
 
 ResultSet query(String str)
 {
  try
  {
   return conn.createStatement().executeQuery(str); 
  } catch (SQLException e) { return null; }
 }
 
 int count(String str)
 {
  try
  {
   return Integer.parseInt(conn.createStatement().executeQuery(str).getString(1));
  } catch (SQLException e) { return -1; }
 }
}