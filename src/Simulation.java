import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(String fileName) {
        String line = "";
        String name = "";
        int weight = 0;
        ArrayList<Item> itemsList = new ArrayList<Item>();
        File items = new File(fileName);
        try(Scanner inputFile = new Scanner(items)){
            while(inputFile.hasNextLine()){
                line = inputFile.nextLine();
                name = line.split("=")[0];
                weight = Integer.parseInt(line.split("=")[1])/1000;
                itemsList.add(new Item(name, weight));
            }
            return itemsList;
        }
        catch(FileNotFoundException e){
            System.out.println("File was not found!");
        }
        return null;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemsList){
        ArrayList<Rocket> U1List = new ArrayList<Rocket>();
        while (!itemsList.isEmpty()) {
            U1List.add(new U1());
            int index = U1List.size() - 1;
            for (int i = 0; i < itemsList.size();){
                if(U1List.get(index).canCarry(itemsList.get(i))){
                    U1List.get(index).carry(itemsList.get(i));
                    itemsList.remove(itemsList.get(i));
                }
                else{
                    i++;
                }
            }
        }
        return U1List;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsList){
        ArrayList<Rocket> U2List = new ArrayList<Rocket>();
        while (!itemsList.isEmpty()) {
            U2List.add(new U2());
            int index = U2List.size() - 1;
            for (int i = 0; i < itemsList.size();){
                if(U2List.get(index).canCarry(itemsList.get(i))){
                    U2List.get(index).carry(itemsList.get(i));
                    itemsList.remove(itemsList.get(i));
                }
                else{
                    i++;
                }
            }
        }
        return U2List;
    }

    public int runSimulation(ArrayList<Rocket> rocketList){
        int totalBudget = 0;
        boolean landed;
        boolean launched;
        for(Rocket rocket : rocketList){
            landed = rocket.land();
            launched = rocket.launch();
            while(!landed || !launched){
                landed = rocket.land();
                launched = rocket.launch();
                totalBudget += rocket.getCost();
            }
            totalBudget += rocket.getCost();
        }
        return totalBudget;
    }

}
