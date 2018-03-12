import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        Simulation sim = new Simulation();
        ArrayList<Item> phase1Items = sim.loadItems("phase-1.txt");
        ArrayList<Item> phase2Items = sim.loadItems("phase-2.txt");

        // U1 rocket mission
        ArrayList<Rocket> phase1U1 = sim.loadU1(phase1Items);
        ArrayList<Rocket> phase2U1 = sim.loadU1(phase2Items);
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < 100; i++) {
            sum += sim.runSimulation(phase1U1);
        }
        for (int i = 0; i < 100; i++) {
            sum2 += sim.runSimulation(phase2U1);
        }
//        System.out.println(sum2/100);
        System.out.println(sum2/100 + sum/100);


        // U2 rocket mission
        phase1Items = sim.loadItems("phase-1.txt");
        phase2Items = sim.loadItems("phase-2.txt");
        ArrayList<Rocket> phase1U2 = sim.loadU2(phase1Items);
        ArrayList<Rocket> phase2U2 = sim.loadU2(phase2Items);
        sum = 0;
        sum2 = 0;
        for (int i = 0; i < 100; i++) {
            sum += sim.runSimulation(phase1U1);
        }
        for (int i = 0; i < 100; i++) {
            sum2 += sim.runSimulation(phase2U1);
        }
//        System.out.println(sum/100);
        System.out.println(sum2/100 + sum/100);


    }
}
