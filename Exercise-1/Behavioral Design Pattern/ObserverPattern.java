// ObserverPattern.java
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stock, int price);
}

class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stock, int price) {
        System.out.println("Notification to " + name + ": " + stock + " stock price changed to " + price);
    }
}

class StockTicker {
    private List<Observer> observers = new ArrayList<>();
    private int price;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(String stock, int price) {
        this.price = price;
        notifyObservers(stock);
    }

    private void notifyObservers(String stock) {
        for (Observer observer : observers) {
            observer.update(stock, price);
        }
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        StockTicker stockTicker = new StockTicker();
        Investor investor1 = new Investor("Sateesh");
        Investor investor2 = new Investor("Reddy");

        stockTicker.addObserver(investor1);
        stockTicker.addObserver(investor2);

        stockTicker.setPrice("Google", 1500);
        stockTicker.setPrice("Apple", 1200);
    }
}
