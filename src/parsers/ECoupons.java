package parsers;

import main.JPar;
import main.Offer;
import main.Statics;

public class ECoupons extends Parser 
{
 private final String key = "fd34435590084b29dd3e25e0ccab3b526ed31bddc6ef832af94dd3593cf882b18d4e67d8273fa601efcb753fbd67bb1a";
 private final String baseURL = "http://api.8coupons.com/v1/getrealtimelocaldeals";
 private Offer[] page;
 private int pointerOnPage;
 
 public ECoupons()
 {
  page = getPage(0);
  pointerOnPage = 0;
 }
 
 private Offer[] getPage(int page)
 {
  //String json = Statics.request(baseURL + "?key=" + key + "limit=400");
  String json = Statics.fileToStr("D:\\jsons\\raw\\8coupons2.txt");
  
  JPar jpar = new JPar(json);
  
  Offer[] ret = new Offer[jpar.size()];
  
  int i;
  for(i=0;i<ret.length;i++)
  {
   JPar joferta = jpar.at(i);
   ret[i] = new Offer(joferta.fi("dealTitle").toString(),
                      joferta.fi("dealinfo").toString(),
                      joferta.fi("showImage").toString(),
                      Statics.URLplaceholder,
                      null,
                      joferta.fi("postDate").toString(),
                      joferta.fi("expirationDate").toString(),
                      joferta.fi("dealPrice").toInt(),
                      joferta.fi("city").toString(),
                      joferta.fi("state").toString(),
                      "Syberia",
                      joferta.fi("categoryID").toString(),
                      null,
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
