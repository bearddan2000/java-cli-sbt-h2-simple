package example.dto;

public enum SQLOPT {
  CREATE("-create-table.sql", "Create"),
  INSERT("-insert-table.sql", "Insert");

  public final String sqlFile;
  public final String operation;

  private SQLOPT(String file, String op)
  {
    this.sqlFile = file;
    this.operation = op;
  }
}
