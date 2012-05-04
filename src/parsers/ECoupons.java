package parsers;

import main.JPar;
import main.Offer;
import main.Statics;

public class ECoupons extends Parser 
{
 private final String key = "9506642c0dce14bc1941e4add332d864d6892589";
 private final String baseURL = "https://api.groupon.com/v2/";
 private Offer[] page;
 private int pointerOnPage;
 
 public ECoupons()
 {
  page = getPage(0);
  pointerOnPage = 0;
 }
 
 private Offer[] getPage(int page)
 {
  //de schimbat adresa
  //http://api.8coupons.com/v1/getrealtimelocaldeals?key=XYZ
  //String json = Statics.request(baseURL+"divisions.json?client_id="+key);
  String json = Statics.fileToStr("D:\\jsons\\raw\\8coupons.txt");
  
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
                      null,
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
