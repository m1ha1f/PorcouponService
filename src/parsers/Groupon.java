package parsers;

import main.JPar;
import main.Offer;
import main.Statics;

public class Groupon extends Parser
{
 private final String key = "9506642c0dce14bc1941e4add332d864d6892589";
 private final String baseURL = "https://api.groupon.com/v2/";
 private String[] divisions;
 
 private String[] getDivisions()
 {
  String json = Statics.request(baseURL+"divisions.json?client_id="+key);
  
  JPar jpar = new JPar(json);
  jpar = jpar.fi("divisions");
  String[] ret = new String[jpar.size()];
  
  int i;
  for(i=0;i<ret.length;i++)
  {
   JPar joferta = jpar.at(i);
   ret[i] = joferta.fi("id").toString();
  }
  
  return ret;
 }
 
 private Offer[] getOfferFromDivision(String divisionid)
 {
  String json = Statics.request(baseURL+"divisions.json?client_id="+key+"&division_id="+divisionid);
  
  JPar jpar = new JPar(json);
  jpar = jpar.fi("deals");
  Offer[] ret;
 
  ret = new Offer[jpar.size()];
  
  int i;
  for(i=0;i<ret.length;i++)
  {
   JPar joferta = jpar.at(i);
   /*
   ret[i] = new Offer(joferta.fi("announcementTitle").toString(),
                      joferta.fi("pitchHtml").toString(),
                      joferta.fi("mediumImageUrl").toString(),
                      joferta.fi("merchant").fi("websiteUrl").toString(),
                      "", //startat
                      joferta.fi("endAt").toString(),
                      joferta.fi("options").at(0).fi("value").fi("amount").toInt(),
                      0,
                      0
                      ); */
  }
  
  return ret;
 }
 
 public Offer next()
 {
  
  return null;
 }

 boolean hasNext() 
 {
  return false;
 }
}