package main;

public enum Category 
{
 AV(1),
 COMP(2),
 ENT(3),
 FSHN(4),
 GAME(5),
 GRCR(6),
 HOME(7),
 KIDS(8),
 MOB(9),
 MISC(10),
 RSTR(11),
 TRVL(12);
 
 private final int id;
 
 Category(int id)
 {
  this.id = id;
 }
 
 int id() 
 { 
  return id; 
 }
}