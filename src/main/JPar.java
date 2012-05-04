package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JPar
{
 static final JSONParser par = new JSONParser();
 private final String s;
     
 public JPar(String s)
 {
  this.s = s;
 }
     
 public JPar at(int i)
 {
  JSONArray o;
  try { o = (JSONArray)par.parse(s); } catch(Exception e) { Dbo.out("JPar at("+i+") ex"); return null; }
  return new JPar(o.get(i).toString());
 }
     
 public JPar fi(String s)
 {
  JSONObject o;
  try { o = (JSONObject)par.parse(this.s); } catch(Exception e) { Dbo.out("JPar fi(\""+s+"\") ex"); return null; }
  //System.out.println("field "+s+"|");
  if(o.get(s) == null) return new JPar("");
  return new JPar(o.get(s).toString());
 }
     
 String[] ar()
 {
  String[] ret;
  JSONArray o;
  try { o = (JSONArray)par.parse(s); } catch (Exception e) { Dbo.out("JPar ar ex"); return null; }
      
  ret = new String[o.size()];
  int i;
  for(i=0;i<o.size();i++)
   ret[i] = o.get(i).toString();
  return ret;
 }
     
 public int size()
 {
  JSONArray o;
  try { o = (JSONArray)par.parse(s); } catch (Exception e) { Dbo.out("JPar size ex"); return -1; }
  return o.size();
 }
     
 public int toInt()
 {
  try
  {
   return Integer.parseInt(s);
  }
  catch (Exception e) { Dbo.out("JPar toInt ex"); return -1; } 
 }
 
 public double toDouble()
 {
  try
  {
   return Double.parseDouble(s);
  }
  catch (Exception e) { Dbo.out("JPar toDouble ex"); return -1; } 
 }
 
 public String toString()
 {
  return s;
 }
}