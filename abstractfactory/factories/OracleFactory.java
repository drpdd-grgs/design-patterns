package abstractfactory.factories;

public class OracleFactory implements SQLStatementFactory{
    @Override
    public String createTransactionStatement(String statement) {
        var sb = new StringBuilder();
        sb.append(statement);
        sb.append("\nCOMMIT;");
        return sb.toString();
    }

    @Override
    public String currentDate() {
        return "SYSDATE";
    }

    @Override
    public String createDeleteStatement(String tableName, String statement) {
        var sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append(tableName);
        sb.append(" WHERE ");
        sb.append(statement);
        return sb.toString();
    }
}
