package exception;

/**
 * @author-Rui Wang rw1
 */
public class WrongInputFormat extends AutoException{
    /**
     * 
     */
    private static final long serialVersionUID = 5426673453796895149L;
    private final int ERRNO;
    private final String exceptionName;
    
    public WrongInputFormat(int ERRNO, String exceptionName) {
        super(ERRNO, exceptionName);
        this.ERRNO = ERRNO;
        this.exceptionName = exceptionName;
    }
    public void print() {
        System.out.println();
        System.out.println("Error: Wrong input format");
        System.out.println("Call fix2() to fix this problem.");
    }

    /**
     * recode exception information. In the fix1to100, this errno is 2.
     */
    public void log(int errno) {
        super.log(ERRNO);
    }
}
