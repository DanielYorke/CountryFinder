package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class Menu {


    public void Display(JSONArray arr){
        int choice;
        String key;
        Scanner sc= new Scanner(System.in);
        do {
            System.out.println("\n\n\n1. Find Country by code \n2. Find Code by Country \n0. To exit");
            choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Enter code for Country: ");
                key = sc.next();
                System.out.println(findCountry(key,arr));
            }
            if(choice == 2){
                System.out.println("Enter Country for Code: ");
                key = sc.next();
                System.out.println(findCode(key,arr));
            }

        }while (choice != 0);
    }
    public String findCountry(String key, JSONArray arr){
        JSONObject jsonOb = new JSONObject();
        for(int i = 0; i<arr.size();i++){
            //jsonOb = (JSONObject) arr.get(i);
            System.out.println(jsonOb.get("code"));
            if(key.equals(jsonOb.get("code")))
                return (String) jsonOb.get("name");
        }
        return "Country not found.";
    }

    public  String findCode(String key, JSONArray arr){
        JSONObject jsonOb = new JSONObject();
        for(int i = 0; i<arr.size();i++){
            jsonOb = (JSONObject) arr.get(i);
            //System.out.println(jsonOb.get("name"));
            if(key.equals(jsonOb.get("name")))
                return (String) jsonOb.get("code");
        }
        return "Code not found.";
    }
}

