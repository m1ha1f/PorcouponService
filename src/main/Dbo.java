package main;

public class Dbo 
{
 static boolean outactive = true;
 static boolean logactive = true;
 
 public static void log(String s)
 {
  if(logactive)
   System.out.println(s);
 }
 
 public static void out(String s)
 {
  if(outactive)
   System.out.println(s);
 }
 
 public static void terminate()
 {
  System.exit(1);
 }
 
 public static void terminate(String s)
 {
  out(s);
  terminate();
 }
}