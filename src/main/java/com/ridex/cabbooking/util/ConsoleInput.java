package com.ridex.cabbooking.util;

import java.util.Scanner;

public class ConsoleInput {

    private static Scanner scanner;

    public ConsoleInput(){

    }

    public Scanner getInstance(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
