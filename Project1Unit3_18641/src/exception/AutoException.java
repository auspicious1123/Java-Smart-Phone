package exception;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author-Rui Wang rw1
 */
public class AutoException extends Exception {
    
    /**
     *  serialVersionUID
     */
    private static final long serialVersionUID = 1958691100812231457L;
    
    /*
     * MissingFileName(1, "MissingFileName");
     * WrongInputFormat(2, "WrongInputFormat");
     * MissingAutoPrice(3, "MissingOptionPrice");
     * MissingOptionSetName(4, "MissingOptionSetName");
     * MissingOptionPrice(5, "MissingOptionPrice");
     */
    
    private int errno;
    private String exceptionName;
    
    public AutoException() { }
    
    public AutoException(int errno, String exceptionName) {
        this.errno = errno;
        this.exceptionName = exceptionName;
    }

    /**
     * @return the errno
     */
    public int getErrno() {
        return errno;
    }

    /**
     * @param errno the errno to set
     */
    public void setErrno(int errno) {
        this.errno = errno;
    }

    /**
     * @return the exceptionName
     */
    public String getExceptionName() {
        return exceptionName;
    }

    /**
     * @param exceptionName the exceptionName to set
     */
    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }
    
    /**
     * record exception.
     * @param errno exception number.
     */
    public void log(int errno) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        String info = timestamp.toString() + ": Exception number:" + errno 
                + ", Exception name: " + this.getExceptionName();
        String block = "\n";
        // write the exception information into log.txt
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("log.txt", true)));
            writer.write(info);
            writer.write(block);
            writer.flush();
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
