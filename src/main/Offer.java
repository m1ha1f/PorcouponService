package main;
public class Offer 
{
 final String title;
 final String text;
 final String image_url;
 final String deal_url;
 final String store_url;
 final String start_at;
 final String end_at;
 final int price;
 final String city;
 final String country; 
 final String category;
 final String store;
 final String currency;

 public Offer(String title,
              String text,
              String image_url,
              String deal_url,
              String store_url,
              String start_at,
              String end_at,
              int price,
              String city,
              String country,
              String category,
              String store,
              String created_at,
              String updated_at,
              String currency)
 {
  this.title = title;
  this.text = text;
  this.image_url = image_url;
  this.deal_url = deal_url;
  this.store_url = store_url;
  this.start_at = start_at;
  this.end_at = end_at;
  this.price = price;
  this.city = city;
  this.country = country;
  this.category = category;
  this.store = store;
  this.currency = currency;
 }
}