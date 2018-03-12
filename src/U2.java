public class U2 extends Rocket {

    public U2() {
        super(120, 18, 29);
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
        return Math.random() >  0.04 * this.weight / this.maxWeight;
    }

    @Override
    public boolean launch() {
        return Math.random() > 0.08 * this.weight / this.maxWeight;
    }

}
