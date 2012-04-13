package main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferInjector 
{
 Db db;
 
 OfferInjector(Db db)
 {
  this.db = db;
 }
 
 private void verifyDependencyStore(String store)
 {
  if(db.count("SELECT count(*) FROM stores WHERE name = '" + Statics.SQLStr(store) + "'") <= 0)
  {
  
  }
 }
 
 private int getStateID(String state)
 {
  return -1;
 }
 
 private int getCityID(String city)
 {
  ResultSet rs = db.query("SELECT id FROM cities WHERE name = '" + city + "'");
  
  try 
  {
   if(rs.next())
   {
    return Integer.parseInt(rs.getString(1));
   }
   else
   {
    db.nonQuery("INSERT INTO cities VALUES (default,'" + city + "',0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)");
    rs = db.query("SELECT id FROM cities WHERE name = '" + city + "'");
    rs.next();
    return Integer.parseInt(rs.getString(1));
   }
  } catch (SQLException e) { e.printStackTrace(); }
  return -1;
 }
 
 /*
 private void verifyDependencies(Offer offer)
 {
  //verifyDependencyStore(offer.store_id);
  getCityID(offer.city);
 }*/
 
 void inject(Offer offer)
 {
  int city_id = getCityID(offer.city);
  int country_id = 0;
  int category_id = 0;
  int store_id = 0;
  
  db.nonQuery("INSERT INTO couponsbak VALUES (" +
              "default,'" +
              Statics.SQLStr(offer.title) + "','" + 
              Statics.SQLStr(offer.title) + "','" +
              offer.image_url + "','" +
              offer.deal_url + "','" +
              offer.store_url + "','" +
              offer.start_at + "','" +
              offer.end_at + "'," +
              offer.price + "," +
              "0,0," + //views, redirs
              city_id + "," +
              country_id + "," +
              category_id + "," +
              store_id + "," +
              "CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'" + //post_date, update_date
              offer.currency + "')");
 }
 
 void inject(Offer[] offer)
 {
  for(Offer o: offer)
   inject(o);
 }
}