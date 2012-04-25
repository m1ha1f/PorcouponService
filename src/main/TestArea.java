package main;

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
 
 public static void main(String[] args)
 {
  test2();
 }
}
