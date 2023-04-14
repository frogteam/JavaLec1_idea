package com.lec.java.dp01.adapter;

public class OldToy implements OldtypeToy {
    private String myName = "";
    
    public OldToy(String myName) {
        this.myName = myName;
    }
    
    @Override
    public void use() {
        System.out.println(myName+" : use this");
    } // end use()
 
    // 구모델은 플러그를 통해 충전 함.
    @Override
    public void onPlug() {
        System.out.println(myName+" : plug on");
    } // end onPlug()
 
    @Override
    public String getName() {
        return myName;
    } // end getName()
} // end class
