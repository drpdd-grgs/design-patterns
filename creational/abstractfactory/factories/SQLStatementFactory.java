package creational.abstractfactory.factories;

public interface SQLStatementFactory {
    String createTransactionStatement(String statement);
    String currentDate();
    String createDeleteStatement(String tableName, String statement);
}
