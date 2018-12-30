package controller;

import model.Bar;

import java.io.File;
import java.util.ArrayList;

public class InventoryManager {
    private  ArrayList<Bar> inventory = new ArrayList<Bar>();
    private String errMSG = null;


    public InventoryManager() {
        File inventoryFile = new File("/src/data/inventoryData.csv")


        if(inventoryFile.exists() && inventoryFile.canRead()) {
            loadInventory(inventoryFile);
        } else {
            errMSG = "El archivo de inventario no existe o no hay acceso de lectura";
        }

    }

    private void loadInventory(File inventoryFile) {
        //todo, implement the method that will read the inventory file
        //and load it to the inventory arraylist
        inventory.add(new Bar("negro", "2300",640, 6, "marco superior"));

    }

    private String fileToString(){

    }

    public void clearError() {
        this.errMSG = null;
    }



}
