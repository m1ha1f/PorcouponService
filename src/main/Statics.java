package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Statics 
{
 public static String URLplaceholder = "http://madflame991.blogspot.com";
 private static SimpleDateFormat dateFormatGmt, dateFormatLocal; 
 
 public static void init()
 {
  dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
  dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
  
  dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
 }
 
 public static String request(String url)
 {
  try 
  {
   return new BufferedReader(new InputStreamReader(new URL(url).openStream())).readLine();
  } 
  catch (MalformedURLException e) { Dbo.out("Request ex: bad URL"); e.printStackTrace(); } 
  catch (IOException e) { Dbo.out("Request ex"); e.printStackTrace(); } 
  return null;
 }
 
 private static void saveRequest(String request)
 {
  FileOutputStream fos;
  try 
  {
   fos = new FileOutputStream((int)(Math.random()*10000000)+".txt"); //not so smart
   DataOutputStream out = new DataOutputStream(fos);
   out.writeUTF(request);
   out.close();
  } catch (FileNotFoundException e) { e.printStackTrace(); }
  catch (IOException e) { e.printStackTrace(); }
 }
 
 public static String fileToStr(String fnam)
 {
  String s;
  try
  {
   FileInputStream fis = new FileInputStream(fnam);
   DataInputStream in = new DataInputStream(fis);
   BufferedReader br = new BufferedReader(new InputStreamReader(in));
   s = br.readLine(); //some files may have more than one lines :(
   in.close();
   fis.close();
  } catch (Exception e) { Dbo.out("File read ex"); return null; }
  return s;
 }
 
 public static String fileToStr2(String fnam)
 {
  try 
  {
   return new Scanner(new File(fnam)).useDelimiter("\\Z").next();
  } catch (FileNotFoundException e) { Dbo.out("File read ex"); return null; }
 }
 
 static String SQLStr(String s)
 {
  return s.replaceAll("'","''");
 }
 
 public static String now()
 {
  try 
  {
   return dateFormatLocal.parse(dateFormatGmt.format(new Date())).toString();
  } catch (ParseException e) { Dbo.out("Now ex"); e.printStackTrace(); }
  
  return "";
 }
 
 static String nvl(int i)
 {
  if(i == -1) return "null";
  else return i+"";
 }
 
 static String nvl(String s)
 {
  if(s == null) return "null";
  else return "'" + s + "'";
 }
}