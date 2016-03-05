package exception;

/**
 * @author-Rui Wang rw1
 */
public class MissingFileName extends AutoException{
    /**
     * 
     */
    private static final long serialVersionUID = -4915924410792255892L;
    private final int ERRNO;
    private final String exceptionName;
    
    public MissingFileName(int ERRNO, String exceptionName) {
        super(ERRNO, exceptionName);
        this.ERRNO = ERRNO;
        this.exceptionName = exceptionName;
    }
    /**
     * Throw filename error or missing filename
     */
    public void print() {
        System.out.println("Error: Missing filename or error filename");
        System.out.println("Call fix1() to fix this problem.");
    }

    /**
     * recode exception information. In the fix1to100, this errno is 1.
     */
    public void log(int errno) {
        super.log(ERRNO);
    }
}
