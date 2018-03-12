public class U1 extends Rocket {

    public U1(){
        super(100, 10, 18);
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public int getMaxWeight() {
        return maxWeight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean land() {
        return Math.random() >  0.05 * this.weight / this.maxWeight;
    }

    @Override
    public boolean launch() {
        return Math.random() > 0.01 * this.weight / this.maxWeight;
    }
}
