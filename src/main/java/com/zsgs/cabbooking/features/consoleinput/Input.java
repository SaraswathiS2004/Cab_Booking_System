package com.zsgs.cabbooking.features.consoleinput;

import java.util.Scanner;

public class Input {

    private static Scanner scanner;

    public Input(){

    }

    public Scanner getInstance(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
