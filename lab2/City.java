public class City {
    private String name;
    private Path[] paths;
    private int pathCount;

    public City(String name) {
        this.name = name;
        this.paths = new Path[10];
        this.pathCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addPath(City toCity, int cost) {
        if (pathCount < paths.length) {
            paths[pathCount] = new Path(toCity, cost);
            pathCount++;
        } else {
            System.out.println("Ошибка: достигнут лимит дорог для города " + name);
        }
    }

    public String toString() {
        String result = name + ": ";

        if (pathCount == 0) {
            result = result + "нет связей";
        } else {
            for (int i = 0; i < pathCount; i++) {
                result = result + paths[i].getToCity().getName() + ":" + paths[i].getCost() + " ";
            }
        }

        return result.trim();
    }
}
