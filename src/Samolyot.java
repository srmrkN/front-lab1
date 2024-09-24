public class Samolyot {
    private String marka;
    private String model;
    private int maxSkorost;
    private int maxVysota;

    public Samolyot(String marka, String model, int maxSkorost, int maxVysota) {
        this.marka = marka;
        this.model = model;
        this.maxSkorost = maxSkorost;
        this.maxVysota = maxVysota;
    }

    public double stoimost() {
        return maxSkorost * 1000 + maxVysota * 100;
    }

    public String informatsiya() {
        return String.format("Марка: %s\nМодель: %s\nМаксимальная скорость: %d км/ч\nМаксимальная высота: %d м\nСтоимость: %.0f руб",
                marka, model, maxSkorost, maxVysota, stoimost());
    }
}