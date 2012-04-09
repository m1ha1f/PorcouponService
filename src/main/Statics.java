package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Statics 
{
 public static String request(String url)
 { 
  try 
  {
   return new BufferedReader(new InputStreamReader(new URL(url).openStream())).readLine();
  } 
  catch (MalformedURLException e) { e.printStackTrace(); } 
  catch (IOException e) { e.printStackTrace(); }
  return null;
 }
 
 public static String fileToStr(String fnam)
 {
  String s;
  try
  {
   FileInputStream fis = new FileInputStream(fnam);
   DataInputStream in = new DataInputStream(fis);
   BufferedReader br = new BufferedReader(new InputStreamReader(in));
   s = br.readLine();
  } catch (Exception e) { return null; }
  return s;
 }
}