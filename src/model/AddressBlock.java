package model;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class AddressBlock {

    private String inDescription;
    private String leftDescription;
    private String aboveDescription;

    public AddressBlock(String inDescription, String leftDescription, String aboveDescription) {
        this.inDescription = inDescription;
        this.leftDescription = leftDescription;
        this.aboveDescription = aboveDescription;
    }

    public String getInDescription() {
        return inDescription;
    }

    public void setInDescription(String inDescription) {
        this.inDescription = inDescription;
    }

    public String getLeftDescription() {
        return leftDescription;
    }

    public void setLeftDescription(String leftDescription) {
        this.leftDescription = leftDescription;
    }

    public String getAboveDescription() {
        return aboveDescription;
    }

    public void setAboveDescription(String aboveDescription) {
        this.aboveDescription = aboveDescription;
    }
}
