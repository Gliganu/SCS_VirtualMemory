package model;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class MemoryLink extends MemoryElement {

    private AddressBlock fromAddressBlock;
    private AddressBlock toAddressBlock;

    public MemoryLink(AddressBlock fromAddressBlock, AddressBlock toAddressBlock,String description) {
        super(description);
        this.fromAddressBlock = fromAddressBlock;
        this.toAddressBlock = toAddressBlock;
    }

    public AddressBlock getFromAddressBlock() {
        return fromAddressBlock;
    }

    public void setFromAddressBlock(AddressBlock fromAddressBlock) {
        this.fromAddressBlock = fromAddressBlock;
    }

    public AddressBlock getToAddressBlock() {
        return toAddressBlock;
    }

    public void setToAddressBlock(AddressBlock toAddressBlock) {
        this.toAddressBlock = toAddressBlock;
    }
}
