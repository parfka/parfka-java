package com.parfka;

public class Test {
  public static void main(String[] args) {
    Parfka.initialize("com.parfka.test", "", "http://parfka.playstrap.com:8080/parfka");
    ParfkaObject aaa = new ParfkaObject("javaclient");
    aaa.put("key1", "value1");
    aaa.put("key2", 5);
    aaa.saveInBackground();
  }
}
