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
  try { o = (JSONArray)par.parse(s); } catch(Exception e) { return null; }
  return new JPar(o.get(i).toString());
 }
     
 public JPar fi(String s)
 {
  JSONObject o;
  try { o = (JSONObject)par.parse(this.s); } catch(Exception e) { return null; }
  return new JPar(o.get(s).toString());
 }
     
 String[] ar()
 {
  String[] ret;
  JSONArray o;
  try { o = (JSONArray)par.parse(s); } catch (Exception e) { return null; }
      
  ret = new String[o.size()];
  int i;
  for(i=0;i<o.size();i++)
   ret[i] = o.get(i).toString();
  return ret;
 }
     
 public int size()
 {
  JSONArray o;
  try { o = (JSONArray)par.parse(s); } catch (Exception e) { return -1; }
  return o.size();
 }
     
 public int toInt()
 {
  return Integer.parseInt(s);
 }
 
 public String toString()
 {
  return s;
 }
}