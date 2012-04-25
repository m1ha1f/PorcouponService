package main;

import java.util.ArrayList;

public class TestArea 
{
 static void test1()
 {
  String json = Statics.fileToStr("D:\\jsons\\raw\\hukd.txt");
  JPar jpar = new JPar(json);
  
  //System.out.println(Integer.parseInt(""));
  System.out.println("|"+jpar.fi("deals").fi("items").at(1).fi("price").toInt()+"|");
 }
 
 static void test2()
 {
  String a = null;
  String b = "asd";
  System.out.println(a+b);
 }
 
 static void test3()
 {
  System.out.println(Statics.fileToStr2("D:\\jsons\\raw\\yipit.txt"));
 }
 
 static void test4()
 {
  String json = Statics.fileToStr2("D:\\jsons\\raw\\yipit.txt");
  JPar jpar = new JPar(json);
  
  System.out.println("|"+jpar.fi("response").fi("deals").at(0).fi("business").toString()+"|");
 }
 
 static void test5()
 {
  ArrayList<String> al = new ArrayList<String>();
  al.add("asd");
  al.add("qwe");
  String[] s = (String[]) al.toArray(new String[al.size()]);
 }
 
 public static void main(String[] args)
 {
  test5();
 }
}
