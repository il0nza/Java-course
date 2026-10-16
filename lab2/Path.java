public class Path {
    private City toCity;
    private int cost;

    public Path(City toCity, int cost) {
        this.toCity = toCity;
        this.cost = cost;
    }

    public City getToCity() {
        return toCity;
    }

    public int getCost() {
        return cost;
    }
}
