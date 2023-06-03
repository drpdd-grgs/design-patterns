package creational.abstractfactory;

import creational.abstractfactory.factories.OracleFactory;
import creational.abstractfactory.factories.PostgreFactory;
import creational.abstractfactory.factories.SQLStatementFactory;

public class App {
    public static void main(String[] args) {
        SQLStatementFactory factory = getFactory("Oracle");
        String deleteStatement = factory.createDeleteStatement("tableName", "columnName = 'someValue'");
        System.out.println(deleteStatement);
    }

    public static SQLStatementFactory getFactory(String db) {
        if (db == "Oracle") {
            return new OracleFactory();
        }
        if (db == "Postgre") {
            return new PostgreFactory();
        }
        return null;
    }
}
