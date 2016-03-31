package model;

import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class MemoryBlock extends MemoryElement {

    private List<AddressBlock> addressBlockList;

    public MemoryBlock(List<AddressBlock> addressBlockList, String description) {
        super(description);
        this.addressBlockList = addressBlockList;
    }

    public List<AddressBlock> getAddressBlockList() {
        return addressBlockList;
    }

    public void setAddressBlockList(List<AddressBlock> addressBlockList) {
        this.addressBlockList = addressBlockList;
    }

    public AddressBlock getAddressBlockAt(int index){
        return addressBlockList.get(index);
    }
}
