package main;
public class Offer 
{
 final int id;
 final String title;
 final String text;
 final String imageURL;
 final String storeURL;
 final String startat;
 final String endat;
 final double money;
 final int locationid;
 final int cathegoryid;

 public Offer(int id,
              String title,
              String text,
              String imageURL,
              String storeURL,
              String startat,
              String endat,
              double money,
              int locationid,
              int cathegoryid)
 {
  this.id = id;
  this.title = title;
  this.text = text;
  this.imageURL = imageURL;
  this.storeURL = storeURL;
  this.startat = startat;
  this.endat = endat;
  this.money = money;
  this.locationid = locationid;
  this.cathegoryid = cathegoryid;
 }
}