package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import parsers.ECoupons;
import parsers.Hukd;
import parsers.Yipit;

public class Main 
{
 static void init()
 {
  Statics.init();
 }
 
 static String GrouponRequest()
 {
  /*
  String divizie = "abbotsford";
  String url = "https://api.groupon.com/v2/deals.json?division_id="+divizie+"&client_id=9506642c0dce14bc1941e4add332d864d6892589"; 
  try 
  {
   return new BufferedReader(new InputStreamReader(new URL(url).openStream())).readLine();
  } 
  catch (MalformedURLException e) { e.printStackTrace(); } 
  catch (IOException e) { e.printStackTrace(); }
  */
  return null;
 }
 
 static String FileToStr(String fnam)
 {
  String s;
  try
  {
   FileInputStream fis = new FileInputStream(fnam);
   DataInputStream in = new DataInputStream(fis);
   BufferedReader br = new BufferedReader(new InputStreamReader(in));
   s = br.readLine();
  } catch (Exception e) { return null;}
  return s;
 }
 
 static Oferta[] JSONToOferte(String s)
 {
  JPar jpar = new JPar(s);
  Oferta[] ret;
 
  ret = new Oferta[jpar.fi("deals").size()];
  
  int i;
  for(i=0;i<ret.length;i++)
  {
   JPar joferta = jpar.fi("deals").at(i);
   ret[i] = new Oferta(joferta.fi("status").toString(),
                       joferta.fi("announcementTitle").toString(),
                       joferta.fi("soldQuantityMessage").toString());
  }
  
  return ret;
 }
 
 static String SQLStr(String s)
 {
  return s.replaceAll("'","''");
 }
 
 static void OferteToDB(Oferta[] oferta, Db db)
 {
  for(Oferta o: oferta)
   db.nonQuery("INSERT INTO tmpOferte VALUES ('" + SQLStr(o.status) + 
                                           "','" + SQLStr(o.announcementTitle) + 
                                           "','" + SQLStr(o.soldQuantityMessage) + "')");
 }
 
 static void startold()
 {
  Db db = new Db();
  db.conn();
  OferteToDB(JSONToOferte(FileToStr("D:\\jsons\\raw\\groupon.txt")),db);
  db.disconn();
 }
 
 static void start()
 {
  Db db = new Db();
  db.conn();
  
  OfferInjector oi = new OfferInjector(db);
  //ECoupons pec = new ECoupons();
  //Hukd pec = new Hukd();
  Yipit pec = new Yipit();
  
  while(pec.hasNext())
  {
   oi.inject(pec.next());
  }
  
  db.disconn();
 }
 
 public static void main(String[] args)
 {
  init();
  start();
 }
}
