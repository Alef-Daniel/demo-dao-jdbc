package db;

public class DbintegrityException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DbintegrityException(String msg){
        super(msg);
    }
}
