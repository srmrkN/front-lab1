class Bombardirovshik extends Samolyot {
    public Bombardirovshik(String marka, String model, int maxSkorost, int maxVysota) {
        super(marka, model, maxSkorost, maxVysota);
    }

    @Override
    public double stoimost() {
        return super.stoimost() * 2;
    }
}