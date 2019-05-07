package controller;

import fileFunctions.FileFunctions;
import model.Bar;

import java.io.*;
import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Bar> inventory = new ArrayList<Bar>();
    //if it ends up being "OK" then we know it went well, if not it will be error codes
    private String status = null;


    public InventoryManager(String dbFilePath) {
        String resolution = loadInventory(dbFilePath);
        if(!resolution.equals("OK")) {
            this.status = "Errores Encontrados: " + resolution;
        }
    }




    private String loadInventory(String inventoryFilePath) { //will return a string with an error if there is any
        StringBuilder possibleErrors = new StringBuilder();

        try {
            String fileText = FileFunctions.toString(inventoryFilePath);
            File dbFile = new File(inventoryFilePath);
            if (!dbFile.exists()) {
                //if it doesnt exist, (try to) create it.
                boolean success = dbFile.createNewFile();
                if (!success) {
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
            possibleErrors.append("El archivo no existe (y/o no se ha podido crear) o no tiene permisos de lectura\n");

        } catch (IOException e) {
            possibleErrors.append("IO ERROR (Perhaps could not create file)\n");

        } catch (NumberFormatException e) {
            possibleErrors.append ("El numero introducido no es un numero valido\n");
        } catch (Exception e) {
            possibleErrors.append("unexpected error\n");

        }
        //if we know its emptry
        if (possibleErrors.length() <= 0) {
            return "OK";
        } else {
            return possibleErrors.toString();
        }

    }




    public void clearError() {
        this.status = null;

    }


}
