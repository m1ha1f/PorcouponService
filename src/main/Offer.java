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
 final int views;
 final int redirects;
 final int city_id;
 final int country_id;
 final int category_id;
 final int store_id;
 final String created_at;
 final String updated_at;
 final String currency;

 public Offer(String title,
              String text,
              String image_url,
              String deal_url,
              String store_url,
              String start_at,
              String end_at,
              int price,
              int views,
              int redirects,
              int city_id,
              int country_id,
              int category_id,
              int store_id,
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
  this.views = views;
  this.redirects = redirects;
  this.city_id = city_id;
  this.country_id = country_id;
  this.category_id = category_id;
  this.store_id = store_id;
  this.created_at = created_at;
  this.updated_at = updated_at;
  this.currency = currency;
 }
}