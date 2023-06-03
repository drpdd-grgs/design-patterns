package creational.abstractfactory.factories;

public class PostgreFactory implements SQLStatementFactory {
    @Override
    public String createTransactionStatement(String statement) {
        var sb = new StringBuilder();
        sb.append("BEGIN;\n");
        sb.append(statement);
        sb.append("\nCOMMIT;");
        return sb.toString();
    }

    @Override
    public String currentDate() {
        return "now()";
    }

    @Override
    public String createDeleteStatement(String tableName, String statement) {
        var sb = new StringBuilder();
        sb.append("DELETE FROM");
        sb.append(tableName);
        sb.append(" WHERE ");
        sb.append(statement);
        return sb.toString();
    }
}
