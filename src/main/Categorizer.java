package main;

import java.util.HashMap;

public class Categorizer 
{
 final HashMap<String,Category> map;
 
 Categorizer()
 {
  map = new HashMap<String,Category>();
  loadCategories();
 }
 
 void loadCategories()
 {
  loadCategoriesHukd();
  loadCategoriesGroupon();
  loadCategoriesYipit();
  loadCategoriesECoupons();
 }
 
 private void loadCategoriesHukd()
 {
  map.put("audiovisual",  Category.AV);
  map.put("computers",    Category.COMP);
  map.put("entertainment",Category.ENT);
  map.put("fashion",      Category.FSHN);
  map.put("gaming",       Category.GAME);
  map.put("groceries",    Category.GRCR);
  map.put("home",         Category.HOME);
  map.put("kids",         Category.KIDS);
  map.put("mobiles",      Category.MOB);
  map.put("other",        Category.MISC);
  map.put("restaurants",  Category.RSTR);
  map.put("travel",       Category.TRVL);
 }
 
 private void loadCategoriesGroupon()
 {
  map.put("Arts and Entertainment",Category.ENT);
  map.put("Automotive",            Category.MISC);
  map.put("Beauty & Spas",         Category.FSHN);
  map.put("Education",             Category.KIDS);
  map.put("Financial Services",    Category.MISC);
  map.put("Food & Drink",          Category.GRCR);
  map.put("Health & Fitness",      Category.HOME);
  map.put("Home Services",         Category.HOME);
  map.put("Legal Services",        Category.MISC);
  map.put("Nightlife",             Category.ENT);
  map.put("Pets",                  Category.KIDS);
  map.put("Professional Services", Category.MISC);
  map.put("Public Services & Government",Category.MISC);
  map.put("Real Estate",                 Category.HOME);
  map.put("Religious Organizations",     Category.ENT);
  map.put("Restaurants",                 Category.RSTR);
  map.put("Shopping",                    Category.FSHN);
  map.put("Travel",                      Category.TRVL);
 }
 
 private void loadCategoriesYipit()
 {
  map.put("restaurants",Category.RSTR);
  map.put("bar-club",   Category.RSTR);
  map.put("massage",    Category.ENT);
  map.put("facials",    Category.FSHN);
  map.put("manicure-pedicure",Category.FSHN);
  map.put("tanning",          Category.FSHN);
  map.put("hair-salon",       Category.FSHN);
  map.put("hair-removal",     Category.FSHN);
  map.put("spa",              Category.FSHN);
  map.put("teeth-whitening",  Category.FSHN);
  map.put("eye-vision",       Category.MISC);
  map.put("makeup",           Category.FSHN);
  map.put("pilates",          Category.FSHN);
  map.put("yoga",             Category.MISC);
  map.put("gym",              Category.FSHN);
  map.put("boot-camp",          Category.MISC);
  map.put("mens-closthing",     Category.FSHN);
  map.put("womens-clothing",    Category.FSHN);
  map.put("food-grocery",       Category.GRCR);
  map.put("treats",             Category.GRCR);
  map.put("home-services",      Category.HOME);
  map.put("museums",            Category.ENT);
  map.put("whine-tasting",      Category.ENT);
  map.put("city-tours",         Category.ENT);
  map.put("comedy-clubs",       Category.ENT);
  map.put("theater",            Category.ENT);
  map.put("concerts",           Category.ENT);
  map.put("life-skills-classes",Category.ENT);
  map.put("golf",               Category.ENT);
  map.put("bowling",            Category.ENT);
  map.put("sporting-events",    Category.ENT);
  map.put("skydiving",          Category.ENT);
  map.put("skiing",             Category.ENT);
  map.put("dance-classes",Category.ENT);
  map.put("baby",         Category.KIDS);
  map.put("kids",         Category.KIDS);
  map.put("college",      Category.KIDS);
  map.put("bridal",       Category.MISC);
  map.put("pets",         Category.KIDS);
  map.put("travel",       Category.TRVL);
  map.put("dental",       Category.MISC);
  map.put("chiropractor", Category.MISC);
  map.put("dermatology",  Category.MISC);
  map.put("martial-arts", Category.ENT);
  map.put("fitness-classes",     Category.ENT);
  map.put("personal-training",   Category.ENT);
  map.put("protography-services",Category.ENT);
  map.put("automotive-services", Category.MISC);
  map.put("outdoor-adventures",  Category.TRVL);
  map.put("gay",                 Category.MISC);
  map.put("jewish",              Category.MISC);
 }
 
 private void loadCategoriesECoupons()
 {
  map.put("1",Category.RSTR);
  map.put("2",Category.ENT);
  map.put("3",Category.ENT);
  map.put("4",Category.MISC);
  map.put("6",Category.GRCR);
  map.put("7",Category.TRVL);
 }
 
 Category getCategory(String s)
 {
  if(!map.containsKey(s)) { Dbo.out("Unheard-of category: |"+s+"|"); return null; }
  return map.get(s);
 }
 
 Category getCategory(String[] s)
 {
  return getCategory(s[0]);
 }
}