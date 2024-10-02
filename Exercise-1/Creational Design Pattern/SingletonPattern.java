// SingletonPattern.java
class Database {
    private static Database instance;

    private Database() {
        System.out.println("Database connection established.");
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}

public class SingletonPatternDemo {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        db1.query("SELECT * FROM users");

        Database db2 = Database.getInstance();
        db2.query("SELECT * FROM orders");

        // Both db1 and db2 will point to the same instance.
    }
}
