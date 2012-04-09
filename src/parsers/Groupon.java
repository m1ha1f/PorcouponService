package parsers;

import main.JPar;
import main.Offer;
import main.Statics;

public class Groupon 
{
 private final String key = "9506642c0dce14bc1941e4add332d864d6892589";
 private final String baseURL = "https://api.groupon.com/v2/"; 
 
 String[] getDivisions()
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
 
 Offer[] getOfferFromDivision(String divisionid)
 {
  String json = Statics.request(baseURL+"divisions.json?client_id="+key+"&division_id="+divisionid);
  
 }
}