package main;
public class Oferta 
{
 final String status;
 final String announcementTitle;
 final String soldQuantityMessage;
 
 Oferta(String status, String announcementTitle, String soldQuantityMessage)
 {
  this.status = status;
  this.announcementTitle = announcementTitle;
  this.soldQuantityMessage = soldQuantityMessage;
 }
}