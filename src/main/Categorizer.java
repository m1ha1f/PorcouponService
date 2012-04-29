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
  /*
  map.put("Arts and Entertainment",Category.AUTO);
  map.put("Automotive",            Category.AUTO);
  map.put("Beauty & Spas",         Category.AUTO);
  map.put("Education",             Category.ED);
  map.put("Financial Services",    Category.AUTO);
  map.put("Food & Drink",          Category.FOOD);
  map.put("Health & Fitness",      Category.HLTH);
  map.put("Home Services",         Category.AUTO);
  map.put("Legal Services",        Category.AUTO);
  map.put("Nightlife",             Category.AUTO);
  map.put("Pets",                  Category.AUTO);
  map.put("Professional Services", Category.AUTO);
  map.put("Public Services & Government",Category.AUTO);
  map.put("Real Estate",                 Category.AUTO);
  map.put("Religious Organizations",     Category.AUTO);
  map.put("Restaurants",                 Category.AUTO);
  map.put("Shopping",                    Category.AUTO);
  map.put("Travel",                      Category.AUTO);
  */
 }
 
 private void loadCategoriesYipit()
 {
  /*
  restaurants
  bar-club
  massage
  facials
  manicure-pedicure
  tanning
  hair-salon
  hair-removal
  spa
  teetch-whitening
  eye-vision
  makeup
  pilates
  yoga
  gym
  goot-camp
  mens-closthing
  womens-clothing
  food-grocery
  treats
  home-services
  museums
  whine-tasting
  city-tours
  comedy-clubs
  theater
  concerts
  life-skills-classes
  golf
  bowling
  sporting-events
  skydiving
  skiing
  dance-classes
  baby
  kids
  college
  bridal
  pets
  travel
  dental
  chiropractor
  dermatology
  martial-arts
  fitness-classes
  personal-training
  protography-services
  automotive-services
  outdoor-adventures
  gay
  jewish */
 }
 
 Category getCategory(String s)
 {
  if(!map.containsKey(s)) return null;
  return map.get(s);
 }
 
 Category getCategory(String[] s)
 {
  return getCategory(s[0]);
 }
}