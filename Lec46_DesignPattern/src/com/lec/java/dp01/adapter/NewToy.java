package com.lec.java.dp01.adapter;

public class NewToy implements NewtypeToy {
    private String myName = "";
    
    public NewToy(String myName) {
        this.myName = myName;
    }
 
    @Override
    public void use() {
        System.out.println(myName+" : use this");
    }
 
    // 신모델은 USB를 통해 충전 합니다.
    @Override
    public void onUSBCharge() {
        System.out.println(myName+" : on USB charge");
    }
     
    @Override
    public String getName() {
        return myName;
    }
}
