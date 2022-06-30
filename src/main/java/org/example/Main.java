package org.example;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Scanner in = null;
        //Scanner in2 = null;
        //  int count = 0;
        try {
            File myObj = new File("C:\\Users\\danie\\IdeaProjects\\CountryFinder\\countries.json");
            in = new Scanner(myObj);
            //System.out.println("Found file");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("C:\\Users\\danie\\IdeaProjects\\CountryFinder\\countries.json")) {
           // System.out.println(" not excwtion");


            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArr = (JSONArray) obj;
            //System.out.println(jsonArr);

         /*   Object in2 = parser.parse(new FileReader("C:\\Users\\danie\\IdeaProjects\\CountryFinder\\countries.json"));

            System.out.println(" File found again?");

            JSONObject jsonObject = (JSONObject)in2; */



            String[][] countries = new String[2][245];
            JSONObject jsonOb;
            //System.out.println(jsonOb.get("name"));

            //JSONObject employeeObject = (JSONObject) jsonObj.get();


            for(int i = 0; i<jsonArr.size();i++){
                jsonOb = (JSONObject) jsonArr.get(i);

                countries[0][i] = (String) jsonOb.get("name");
                countries[1][i] = (String) jsonOb.get("code");
                //System.out.println("name - " +  countries[0][i] + " \n code - " + countries[1][i] );
            }
            Menu menu = new Menu();
            menu.Display(jsonArr);



        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}