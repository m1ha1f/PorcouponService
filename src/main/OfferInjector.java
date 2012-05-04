package main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferInjector 
{
 Db db;
 Categorizer categorizer;
 
 OfferInjector(Db db)
 {
  this.db = db;
  categorizer = new Categorizer();
 }
 
 private int getMerchantID(String name, String url)
 {
  ResultSet rs = db.query("SELECT id FROM stores WHERE name = '" + Statics.SQLStr(name) + "'");
  
  try 
  {
   if(rs.next())
   {
    return Integer.parseInt(rs.getString(1));
   }
   else
   {
    db.nonQuery("INSERT INTO stores VALUES (default,'" + 
                                            Statics.SQLStr(name) + "','" + 
                                            Statics.now() + "','" + 
                                            Statics.now() + "'," + 
                                            Statics.nvl(url) + ")");
    rs = db.query("SELECT id FROM stores WHERE name = '" + Statics.SQLStr(name) + "'");
    rs.next();
    return Integer.parseInt(rs.getString(1));
   }
  } catch (SQLException e) { Dbo.out("SQL ex"); e.printStackTrace(); }
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
  } catch (SQLException e) { Dbo.out("SQL ex"); e.printStackTrace(); }
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
  } catch (SQLException e) { Dbo.out("SQL ex"); e.printStackTrace(); }
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
  } catch (SQLException e) { Dbo.out("SQL ex"); e.printStackTrace(); }
  return new int[] {-1,tmp[1]};
 }
 
 void inject(Offer offer)
 {
  int city_id = -1; 
  int country_id = -1;
  int category_id = -1;
  int store_id = -1;
  
  if(offer.store != null)
   if(offer.store.length() > 0)
    store_id = getMerchantID(offer.store,offer.store_url);
  
  if(offer.country != null)
   if(offer.country.length() > 0)
    country_id = getCountryID(offer.country);
  
  if(offer.city != null)
   if(offer.city.length() > 0)
   {
    int[] tmp = getCityID(offer.city,offer.state,offer.country);
    city_id = tmp[0]; 
    country_id = tmp[1];
   }
  
  String text;
  if(offer.text == null) text = "null";
  else text = "'" + Statics.SQLStr(offer.text) + "'";
  
  if(offer.category != null)
  {
   Category tmp = categorizer.getCategory(offer.category); 
   if(tmp != null)
    category_id = tmp.id();
  }
    
  db.nonQuery("INSERT INTO coupons VALUES (" +
              "default,'" +
              Statics.SQLStr(offer.title) + "'," + 
              text + ",'" +
              offer.image_url + "','" +
              offer.deal_url + "','" +
              //offer.store_url + "','" +
              offer.start_at + "'," +
              Statics.nvl(offer.end_at) + "," +
              Statics.nvl(offer.price) + "," +
              (int)(Math.random()*1000000) + "," +
              (int)(Math.random()*1000000) + "," +
              Statics.nvl(city_id) + "," +
              Statics.nvl(country_id) + "," +
              Statics.nvl(category_id) + "," +
              Statics.nvl(store_id) + ",'" +
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