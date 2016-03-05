package exception;

/**
 * @author-Rui Wang rw1
 */
public class NoModel extends AutoException{
    /**
     * 
     */
    private static final long serialVersionUID = 4505040366073504036L;

    public void print() {
        System.out.println("The Modelname does not exist, please check the name.");
    }
}
