package exception;

/**
 * @author-Rui Wang rw1
 */
public class MissingOptionSetName extends AutoException{
    /**
     * 
     */
    private static final long serialVersionUID = -4942398521750597695L;
    private final int ERRNO;
    private final String exceptionName;
    
    public MissingOptionSetName(int ERRNO, String exceptionName) {
        super(ERRNO, exceptionName);
        this.ERRNO = ERRNO;
        this.exceptionName = exceptionName;
    }
    /**
     * throws missing optionset data exception.
     */
    public void print() {
        System.out.println();
        System.out.println("Error: Missing OptionSet NameMo");
        System.out.println("Call fix4() to fix this problem.");
    }
    /**
     * recode exception information. In the fix1to100, this errno is 3.
     */
    public void log(int errno) {
        super.log(ERRNO);
    }
}
