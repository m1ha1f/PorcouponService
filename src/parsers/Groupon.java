package parsers;

import main.JPar;
import main.Offer;
import main.Statics;

public class Groupon extends Parser
{
 private final String key = "9506642c0dce14bc1941e4add332d864d6892589";
 private final String baseURL = "https://api.groupon.com/v2/";
 private Offer[] page;
 private int pointerOnPage, pointerOnDivision;
 private String[] division;
 
 public Groupon()
 {
  division = getDivisions();
  pointerOnDivision = 0;
  page = getPage(division[0]);
  pointerOnPage = 0;
 }
 
 private String[] getDivisions()
 {
  String json = Statics.request(baseURL+"divisions.json?client_id="+key);
  
  JPar jpar = new JPar(json);
  jpar = jpar.fi("divisions");
  String[] ret = new String[10/*jpar.size()*/];
  
  int i;
  for(i=0;i<ret.length;i++)
  {
   JPar joferta = jpar.at(i);
   ret[i] = joferta.fi("id").toString();
  }
  
  return ret;
 }
 
 private Offer[] getPage(String divisionid)
 {
  String json = Statics.request(baseURL+"deals.json?client_id="+key+"&division_id="+divisionid);
  
  JPar jpar = new JPar(json);
  jpar = jpar.fi("deals");
  
  Offer[] ret = new Offer[jpar.size()];

  int i;
  for(i=0;i<ret.length;i++)
  {
   JPar joferta = jpar.at(i);
   ret[i] = new Offer(joferta.fi("title").toString(),
                      joferta.fi("pitchHtml").toString(),
                      joferta.fi("largeImageUrl").toString(),
                      joferta.fi("options").at(0).fi("buyUrl").toString(),
                      joferta.fi("merchant").fi("websiteUrl").toString(),
                      joferta.fi("startAt").toString(),
                      joferta.fi("endAt").toString(),
                      joferta.fi("options").at(0).fi("price").fi("amount").toInt(),
                      joferta.fi("redemptionLocation").toString(),
                      null,
                      "URSS",
                      joferta.fi("tags").at(0).fi("name").toString(),
                      joferta.fi("merchant").fi("name").toString(),
                      "USD");
  }
  return ret;
 }

 public Offer next() 
 {
  Offer tmp = page[pointerOnPage];
  pointerOnPage++;
  if(pointerOnPage >= page.length)
  {
   System.out.println(pointerOnPage+" "+pointerOnDivision);
   pointerOnDivision++;
   if(pointerOnDivision >= division.length)
    return null;
   page = getPage(division[pointerOnDivision]);
   pointerOnPage = 0;
  }
  return tmp;
 }
 
 public boolean hasNext()
 {
  return pointerOnDivision < division.length;
 }
}