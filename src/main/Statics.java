package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Statics 
{
 public static String URLplaceholder = "http://madflame991.blogspot.com";
 
 public static String request(String url)
 {
  return fileToStr("D:\\jsons\\raw\\8coupons.txt");
  /*
  try 
  {
   return new BufferedReader(new InputStreamReader(new URL(url).openStream())).readLine();
  } 
  catch (MalformedURLException e) { e.printStackTrace(); } 
  catch (IOException e) { e.printStackTrace(); } 
  return null; */
 }
 
 public static String fileToStr(String fnam)
 {
  String s;
  try
  {
   FileInputStream fis = new FileInputStream(fnam);
   DataInputStream in = new DataInputStream(fis);
   BufferedReader br = new BufferedReader(new InputStreamReader(in));
   s = br.readLine(); //chestia asta o sa fie nasoala
  } catch (Exception e) { System.out.println("file read ex"); return null; }
  return s;
 }
 
 static String SQLStr(String s)
 {
  return s.replaceAll("'","''");
 }
 
 static String now()
 {
  SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
  dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
  
  SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
  
  try 
  {
   return dateFormatLocal.parse( dateFormatGmt.format(new Date()) ).toString();
  } catch (ParseException e) { e.printStackTrace(); }
  
  return "";
 }
}