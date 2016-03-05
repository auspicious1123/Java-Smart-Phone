package exception;

/**
 * @author-Rui Wang rw1
 */
public class MissingAutoPrice extends AutoException {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2073634152695482229L;
    private final int ERRNO;
    private final String exceptionName;
    
    public MissingAutoPrice(int ERRNO, String exceptionName) {
        super(ERRNO, exceptionName);
        this.ERRNO = ERRNO;
        this.exceptionName = exceptionName;
    }

    public void print() {
        System.out.println();
        System.out.println("Error: Missing Automobile price in text file");
        System.out.println("Call fix3() to fix this problem.");
    }
    
    /**
     * recode exception information. In the fix1to100, this errno is 3.
     */
    public void log(int errno) {
        super.log(ERRNO);
    }

}
