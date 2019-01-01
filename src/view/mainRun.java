package view;

import controller.InventoryManager;
import model.Bar;

import java.util.ArrayList;

public class mainRun {
    public static void main(String[] args) {
       InventoryManager i = new InventoryManager();

       printBarArrayList(i.getInventory());



       /*

        try {
            String toPrint =     "whatever";  //i.fileToString("src/data/inventoryData.csv");
            System.out.println(toPrint);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

    }
    public static void printBarArrayList(ArrayList<Bar> yea) {
        for(int counter =0; counter< yea.size(); counter ++) {
            Bar currentBar = yea.get(counter);
            String currentOut = currentBar.getSeries() + currentBar.getColour() + currentBar.getLength() + currentBar.getName();
            System.out.println(currentOut);
        }
    }
}
