package main;

public class Categorizer 
{
 static final String[] HUKDCategories = {"clothing","computers","electricals","entertainment","finance","general-deals",
                                         "groceries","home","kids","mobiles","nonsense","travel"};
 static int getHUKDCategory(String nam)
 {
  int i;
  for(i=0;i<HUKDCategories.length;i++)
   if(nam.equals(HUKDCategories[i]))
    return i;
  return -1;
 }
}