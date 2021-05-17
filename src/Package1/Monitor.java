package Package1;

public class Monitor {
    private final Producer producer;
    private final String model;
    private final double screenSize;
    private final int price;

    public Monitor(Producer producer, String model, double screenSize, int price) {
        this.producer = producer;
        this.model = model;
        this.screenSize = screenSize;
        this.price = price;
    }

    public Producer getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return "Марка: " + producer +
                ", модель: " + model +
                ", диагональ: " + screenSize +
                "\", цена: " + price +
                " руб.";
    }
}
