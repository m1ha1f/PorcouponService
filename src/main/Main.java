package main;

import parsers.ECoupons;
import parsers.Groupon;
import parsers.Yipit;

public class Main 
{
 static void init()
 {
  Statics.init();
 }
 
 static private void doECoupons(OfferInjector oi)
 {
  ECoupons pec = new ECoupons();
  while(pec.hasNext())
   oi.inject(pec.next());
 }
 
 static private void doHukd(OfferInjector oi)
 {
  ECoupons pec = new ECoupons();
  while(pec.hasNext())
   oi.inject(pec.next());
 }
 
 static private void doYipit(OfferInjector oi)
 {
  Yipit pec = new Yipit();
  while(pec.hasNext())
   oi.inject(pec.next());
 }
 
 static private void doGroupon(OfferInjector oi)
 {
  Groupon pec = new Groupon();
  while(pec.hasNext())
   oi.inject(pec.next());
 }
 
 static void start()
 {
  Db db = new Db();
  db.conn();
  
  OfferInjector oi = new OfferInjector(db);

  //doHukd(oi);
  doECoupons(oi);
  //doYipit(oi);
  //doGroupon(oi);
  
  db.disconn();
 }
 
 public static void main(String[] args)
 {
  init();
  start();
 }
}
