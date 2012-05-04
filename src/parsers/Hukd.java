package parsers;

import main.JPar;
import main.Offer;
import main.Statics;

public class Hukd extends Parser 
{
 private final String key = "8797b1c4482a8715b49b26c41f2d4434";
 private final String baseURL = "http://api.hotukdeals.com/rest_api/v2/";
 private Offer[] page;
 private int pointerOnPage;
 
 public Hukd()
 {
  page = getPage(0);
  pointerOnPage = 0;
 }
 
 private Offer[] getPage(int page)
 {
//String json = Statics.fileToStr("D:\\jsons\\raw\\hukd.txt");
  String json = Statics.request(baseURL+"?key="+key+"&output=json&results_per_page=100");
  
  JPar jpar = new JPar(json);
  jpar = jpar.fi("deals").fi("items");
  
  Offer[] ret = new Offer[jpar.size()];
  
  int i;
  for(i=0;i<ret.length;i++)
  {
   JPar joferta = jpar.at(i);
   ret[i] = new Offer(joferta.fi("title").toString(),
                      joferta.fi("description").toString(),
                      joferta.fi("deal_image").toString(),
                      joferta.fi("deal_link").toString(),
                      joferta.fi("merchant").fi("url_name").toString(),
                      Statics.now(),
                      null,
                      joferta.fi("dealPrice").toInt(), //(int)(Math.random()*20)*100+99
                      null,
                      null,
                      "UK",
                      joferta.fi("category").fi("url_name").toString(),
                      joferta.fi("merchant").fi("name").toString(),
                      "USD");
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
