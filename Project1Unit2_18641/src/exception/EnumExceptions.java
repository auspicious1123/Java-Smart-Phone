package exception;

/**
 * @author-Rui Wang rw1
 */
public enum EnumExceptions {
     MissingFileName(1),
     WrongInputFormat(2),
     MissingAutoPrice(3),
     MissingOptionSetName(4),
     MissingOptionPrice(5);
     
    private int errno;
    
    private EnumExceptions(int errno){
        this.errno = errno;
    }
    
    // getter
    public int getErrno(){
        return errno;
    }
    
//    // getter
//    public String getExceptionName(){
//        return exceptionName;
//    }
}
