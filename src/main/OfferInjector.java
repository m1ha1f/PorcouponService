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
  verifyDependencyStore(offer.store_id);
 }
 
 void inject(Offer offer)
 {
  //inainte se verifica daca exista toate dependentele iar daca nu se insereaza
  verifyDependencies(offer);
  
  db.nonQuery("INSERT INTO tmpOferte VALUES ('" + Statics.SQLStr(offer.status) + 
              "','" + Statics.SQLStr(offer.announcementTitle) + 
              "','" + Statics.SQLStr(offer.soldQuantityMessage) + "')");
 }
 
 void inject(Offer[] offer)
 {
  for(Offer o: offer)
   inject(o);
 }
}