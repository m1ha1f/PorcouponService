package main;

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
 
 private void verifyDependencies(Offer offer)
 {
  //verifyDependencyStore(offer.store_id);
 }
 
 void inject(Offer offer)
 {
  verifyDependencies(offer);
  
  db.nonQuery("INSERT INTO coupons VALUES (" +
              "default,'" +
              Statics.SQLStr(offer.title) + "','" + 
              Statics.SQLStr(offer.title) + "','" +
              offer.image_url + "','" +
              offer.deal_url + "','" +
              offer.store_url + "','" +
              offer.start_at + "','" +
              offer.end_at + "'," +
              offer.price + "," +
              offer.views + "," +
              offer.redirects + "," +
              offer.city_id + "," +
              offer.country_id + "," +
              offer.category_id + "," +
              offer.store_id + ",'" +
              offer.created_at + "','" +
              offer.updated_at + "','" +
              offer.currency + "')");
 }
 
 void inject(Offer[] offer)
 {
  for(Offer o: offer)
   inject(o);
 }
}