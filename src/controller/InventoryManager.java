package controller;

import model.Bar;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private  ArrayList<Bar> inventory = new ArrayList<Bar>();
    private String errMSG = null;


    public InventoryManager() {
        File inventoryFile = new File("src/data/inventoryData.csv");


        if(inventoryFile.exists() && inventoryFile.canRead()) {
            loadInventory(inventoryFile.getPath());

        } else {
            errMSG = "El archivo de inventario no existe o no hay acceso de lectura";
        }

    }

    private void loadInventory(String filePath) {
        //todo, implement the method that will read the inventory file
        //and load it to the inventory arraylist
        try {
            String fullDatabase = fileToString(filePath);
            String[] lineArray = fullDatabase.split("\n");
            for(int counter = 0; counter < lineArray.length; counter++) {
                String[] innerAttributes = lineArray[counter].split("\\|");
                //assuming the current data structure in the file
                String barName = innerAttributes[0];
                String barSeries = innerAttributes[1];
                double barLength = Double.parseDouble(innerAttributes[2]);
                double barThickness = Double.parseDouble(innerAttributes[3]);
                String barColour = innerAttributes[4];

                Bar tempBar = new Bar(barColour,barSeries,barLength,barThickness,barName);
                inventory.add(tempBar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//remember to make this private
    private String fileToString(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader((new FileReader(filePath)));
        StringBuilder sb = new StringBuilder();
        String currentLine = reader.readLine();
        while(currentLine != null) {
            sb.append(currentLine);
            sb.append('\n'); //we append the linebreak to the thing too
            currentLine = reader.readLine();
        }

        reader.close();
        return sb.toString();
    }

    public void clearError() {
        this.errMSG = null;
    }

    public String getErrMSG() { //this system will return the error message and clear it from the memory
        String outMessage = this.errMSG;
        clearError();
        return outMessage;
    }

    public ArrayList<Bar> getInventory() {
        return this.inventory;
    }



}
