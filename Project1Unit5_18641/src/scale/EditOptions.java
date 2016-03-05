package scale;

import model.Automobile;

/**
 * @author-Rui Wang rw1
 */
public class EditOptions extends Thread {
    public static final int OPTION_SET_NAME = 0;  //change option set name
    public static final int OPTION_PRICE = 1;   // change option price
    public static final int CHOICE = 2;  // change choice
    public static final int OPTION_NAME = 3;    // change option name

    private int mOptionNum;         
    private String mModelName;
    private String mOptionName;          // use for option and choice
    private String mOptionSetName;       // set name
    private String mOptionSetNewName;    // updated set name
    private String mOptionNewName;       // updated option name

    private int mPrice;

    private Automobile mEditAuto;

    // constructer
    public EditOptions(int optionNum, Automobile auto, String modelName) {
        mOptionNum = optionNum;
        mEditAuto = auto;
        mModelName = modelName;
    }

    /**
     * @return the mOptionSetNewName
     */
    public String getOptionSetNewName() {
        return mOptionSetNewName;
    }

    /**
     * @param mOptionSetNewName
     *            the mOptionSetNewName to set
     */
    public void setOptionSetNewName(String mOptionSetNewName) {
        this.mOptionSetNewName = mOptionSetNewName;
    }

    /**
     * @return the mOptionNum
     */
    public int getOptionNum() {
        return mOptionNum;
    }

    /**
     * @param mOptionNum
     *            the mOptionNum to set
     */
    public void setOptionNum(int mOptionNum) {
        this.mOptionNum = mOptionNum;
    }

    /**
     * @return the mModelName
     */
    public String getModelName() {
        return mModelName;
    }

    /**
     * @param mModelName
     *            the mModelName to set
     */
    public void setModelName(String mModelName) {
        this.mModelName = mModelName;
    }

    /**
     * @return the mOptionName
     */
    public String getOptionName() {
        return mOptionName;
    }

    /**
     * @param mOptionName
     *            the mOptionName to set
     */
    public void setOptionName(String mOptionName) {
        this.mOptionName = mOptionName;
    }

    /**
     * @return the mOptionSetName
     */
    public String getOptionSetName() {
        return mOptionSetName;
    }

    /**
     * @param mOptionSetName
     *            the mOptionSetName to set
     */
    public void setOptionSetName(String mOptionSetName) {
        this.mOptionSetName = mOptionSetName;
    }

    /**
     * @return the mOptionNewName
     */
    public String getOptionNewName() {
        return mOptionSetNewName;
    }

    /**
     * @param mOptionNewName
     *            the mOptionNewName to set
     */
    public void setOptionNewName(String mOptionNewName) {
        this.mOptionNewName = mOptionNewName;
    }

    /**
     * @return the mPrice
     */
    public int getPrice() {
        return mPrice;
    }

    /**
     * @param mPrice
     *            the mPrice to set
     */
    public void setPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    /**
     * @return the mEditAuto
     */
    public Automobile getEditAuto() {
        return mEditAuto;
    }

    /**
     * @param mEditAuto
     *            the mEditAuto to set
     */
    public void setEditAuto(Automobile mEditAuto) {
        this.mEditAuto = mEditAuto;
    }

    /*
     * according to edit type(mOptionNum) to choose update operation
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        super.run();
        Automobile autoMobile = mEditAuto;
            if (autoMobile == null)
                return;
            for(int i = 0; i < 10; i++){
                System.out.println("run thread is : "+ mOptionNum);
            switch (mOptionNum) {
            
            case OPTION_SET_NAME:
                autoMobile.updateOptionSet(mOptionSetName, mOptionSetNewName); 
                break;
            case OPTION_NAME:
                autoMobile.updateOptionName(mOptionSetName, mOptionName, mOptionNewName);
                break;
            case OPTION_PRICE:
                autoMobile.updateOptionPrice(mOptionSetName, mOptionName, mPrice);
                break;
            case CHOICE:
                autoMobile.updateChoice(mOptionName, mOptionNewName);
                break;
            default:
                break;
            }
        }
    }
}
