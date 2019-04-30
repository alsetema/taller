package controller;

import fileFunctions.FileFunctions;
import model.Bar;

import java.io.*;
import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Bar> inventory = new ArrayList<Bar>();
    private String errMSG = null;


    public InventoryManager(String dbFilePath) {
        loadInventory(dbFilePath);
    }




    private void loadInventory(String inventoryFilePath) { //will return a string with an error if there is any

        //todo, implement the method that will read the inventory file (or create it if it doesnt exist)
        try {
            String fileText = FileFunctions.toString(inventoryFilePath);
            File dbFile = new File(inventoryFilePath);
            if (!dbFile.exists()) {
                //if it doesnt exist, (try to) create it.
                boolean success = dbFile.createNewFile();
                if (!success) {
                    System.err.println("El archivo de base de datos no se pudo crear");
                    throw new FileNotFoundException();
                }
            }

            String[] lines = fileText.split("\n");
            for (int counter = 0; counter < lines.length; counter++) {
                //nice thing to have, check that each line has only one pipe :)
                String[] individual = lines[counter].split("\\|");
                //System.out.println(individual.length);
                Bar tempbar = new Bar();
                tempbar.setColour(individual[0]);
                tempbar.setSeries(individual[1]);
                tempbar.setLength(Double.parseDouble(individual[2]));
                tempbar.setThickness(Double.parseDouble(individual[3]));
                tempbar.setName(individual[4]);

                inventory.add(tempbar);

            }


        } catch (FileNotFoundException e) {
            this.errMSG = "El archivo no existe (y/o no se ha podido crear) o no tiene permisos de lectura";

        } catch (IOException e) {
            this.errMSG = "IO ERROR (Perhaps could not create file)" + e.getStackTrace();

        } catch (NumberFormatException e) {
            this.errMSG = "El numero introducido no es un numero valido";
        } catch (Exception e) {
            this.errMSG = "unexpected error" + e.getStackTrace();

        }

    }




    public void clearError() {
        this.errMSG = null;

    }


}
