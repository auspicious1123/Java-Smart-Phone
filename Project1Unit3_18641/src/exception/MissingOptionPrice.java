package exception;

/**
 * @author-Rui Wang rw1
 */
public class MissingOptionPrice extends AutoException{
    /**
     * 
     */
    private static final long serialVersionUID = 5780582201486866446L;
    private final int ERRNO;
    private final String exceptionName;
    
    public MissingOptionPrice(int ERRNO, String exceptionName) {
        super(ERRNO, exceptionName);
        this.ERRNO = ERRNO;
        this.exceptionName = exceptionName;
    }
    /**
     * Throws option data.
     */
    public void print() {
        System.out.println();
        System.out.println("Error: Missing option price");
        System.out.println("Call fix5() to fix this problem.");
    }
    /**
     * recode exception information. In the fix1to100, this errno is 3.
     */
    public void log(int errno) {
        super.log(ERRNO);
    }
}
