package parsers;

import java.util.ArrayList;

import main.JPar;
import main.Offer;
import main.Statics;

public class Yipit extends Parser 
{
 private final String key = "9506642c0dce14bc1941e4add332d864d6892589";
 private final String baseURL = "http://api.hotukdeals.com/rest_api/v2/";
 private Offer[] page;
 private int pointerOnPage;
 
 public Yipit()
 {
  page = getPage(0);
  pointerOnPage = 0;
 }
 
 private Offer[] getPage(int page)
 {
  //de lucru
  String json = Statics.fileToStr2("D:\\jsons\\raw\\yipit.txt");
  JPar jpar = new JPar(json);
  
  jpar = jpar.fi("response").fi("deals");
  
  ArrayList<Offer> ret = new ArrayList<Offer>();
  
  int noffer = jpar.size();
  int i;
  for(i=0;i<noffer;i++)
  {
   Offer[] tmp = getVariants(jpar.at(i));
   for(Offer o: tmp)
    ret.add(o);
  }
  System.out.println(ret.size());
  return (Offer[]) ret.toArray(new Offer[ret.size()]);
 }
 
 private Offer[] getVariants(JPar jpar)
 {
  String title, text, image_url, deal_url, store_url, start_at, end_at, category, store, currency;
  double price;
  
  title = jpar.fi("title").toString();
  text = null;
  image_url = jpar.fi("images").fi("image_big").toString();
  deal_url = jpar.fi("url").toString();
  store_url = jpar.fi("business").fi("url").toString();
  start_at = jpar.fi("date_added").toString();
  end_at = jpar.fi("end_date").toString();
  price = jpar.fi("price").fi("raw").toDouble();
  category = jpar.fi("tags").fi("slug").toString();
  store = jpar.fi("business").fi("name").toString();
  currency = "USD";
  
  jpar = jpar.fi("business").fi("locations");
  int nvar = jpar.size();
  Offer[] ret = new Offer[nvar];
  
  int i;
  for(i=0;i<nvar;i++)
  {
   JPar jparloc = jpar.at(i);
   ret[i] = new Offer(title,
                      text,
                      image_url,
                      deal_url,
                      store_url,
                      start_at,
                      end_at,
                      (int)price,
                      jparloc.fi("locality").toString(),
                      jparloc.fi("state").toString(),
                      "Congo",    
                      category,
                      store,
                      currency);
  }
  
  return ret;
 }

 public Offer next() 
 {
  Offer tmp = page[pointerOnPage];
  pointerOnPage++;
  return tmp;
 }
 
 public boolean hasNext()
 {
  return pointerOnPage < page.length;
 }
}
