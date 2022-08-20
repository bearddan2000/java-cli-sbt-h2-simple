package example;

import org.apache.log4j.PropertyConfigurator;

public class Main {

  public static void main(String[] args) {
    PropertyConfigurator.configure("/tmp/src/main/resources/log4j.xml");
    String databaseName = "test";
    String opptions = ";DB_CLOSE_DELAY=-1";
    opptions += ";INIT=CREATE SCHEMA IF NOT EXISTS " + databaseName + "\\";
    opptions += ";SET SCHEMA " + databaseName;

    // Create a variable for the connection string.
    String connectionStr = "jdbc:h2:mem:" + databaseName + opptions;
    example.dto.Dog dog = new example.dto.Dog("org.h2.Driver", connectionStr);
    dog.operation("00", example.dto.SQLOPT.CREATE);
    dog.operation("01", example.dto.SQLOPT.INSERT);

    example.db.print.output.IOutput output = new example.db.print.output.ToConsole();
    for ( String tbl : new String[]{databaseName+".dog"})
      example.db.DBQuery.query(connectionStr, tbl, output);
  }
}
