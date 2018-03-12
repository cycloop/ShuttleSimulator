public class Rocket implements Spaceship {
    protected int cost;
    protected int weight;
    protected int maxWeight;
    protected double chanceOfLaunchExplosion;
    protected double chanceOfLandingCrash;

    public Rocket(int cost, int weight, int maxWeight){
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
    }

    public int getCost() {
        return this.cost;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (item.getWeight() + this.weight > this.maxWeight){
            return false;
        }
        return true;
    }

    @Override
    public void carry(Item item) {
        this.weight += item.getWeight();
    }
}
