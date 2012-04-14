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
 
 private int getStoreID(String store)
 {
  return -1;
 }
 
 private int getCountryID(String country)
 {
  ResultSet rs = db.query("SELECT id FROM countries WHERE name = '" + country + "'");
  
  try 
  {
   if(rs.next())
   {
    return Integer.parseInt(rs.getString(1));
   }
   else
   {
    db.nonQuery("INSERT INTO countries VALUES (default,'" + country + "','" + Statics.now() + "','" + Statics.now() + "')");
    rs = db.query("SELECT id FROM countries WHERE name = '" + country + "'");
    rs.next();
    return Integer.parseInt(rs.getString(1));
   }
  } catch (SQLException e) { e.printStackTrace(); }
  return -1;
 }
 
 private int[] getStateID(String state, String country)
 {
  int country_id = getCountryID(country);
  
  ResultSet rs = db.query("SELECT id FROM states WHERE name = '" + state + "'");
  
  try 
  {
   if(rs.next())
   {
    return new int[] {Integer.parseInt(rs.getString(1)),country_id};
   }
   else
   {
    db.nonQuery("INSERT INTO states VALUES (default,'" + state + "'," + country_id + ",'" + Statics.now() + "','" + Statics.now() + "')");
    rs = db.query("SELECT id FROM states WHERE name = '" + state + "'");
    rs.next();
    return new int[] {Integer.parseInt(rs.getString(1)),country_id};
   }
  } catch (SQLException e) { e.printStackTrace(); }
  return new int[] {-1,country_id};
 }
 
 private int[] getCityID(String city, String state, String country)
 {
  int[] tmp = getStateID(state,country);
  int state_id = tmp[0]; 
  
  ResultSet rs = db.query("SELECT id FROM cities WHERE name = '" + city + "'");
  
  try 
  {
   if(rs.next())
   {
    return new int[] {Integer.parseInt(rs.getString(1)),tmp[1]};
   }
   else
   {
    db.nonQuery("INSERT INTO cities VALUES (default,'" + city + "'," + state_id + ",'" + Statics.now() + "','" + Statics.now() + "')");
    rs = db.query("SELECT id FROM cities WHERE name = '" + city + "'");
    rs.next();
    return new int[] {Integer.parseInt(rs.getString(1)),tmp[1]};
   }
  } catch (SQLException e) { e.printStackTrace(); }
  return new int[] {-1,tmp[1]};
 }
 
 /*
 private void verifyDependencies(Offer offer)
 {
  //verifyDependencyStore(offer.store_id);
  getCityID(offer.city);
 }*/
 
 void inject(Offer offer)
 {
  int[] tmp = getCityID(offer.city,offer.state,offer.country);
  int city_id = tmp[0]; 
  int country_id = tmp[1];
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
              store_id + ",'" +
              Statics.now() + "','" +
              Statics.now() + "','" +
              offer.currency + "')");
 }
 
 void inject(Offer[] offer)
 {
  for(Offer o: offer)
   inject(o);
 }
}