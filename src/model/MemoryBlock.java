package model;

import view.MemoryElementView;

import java.awt.*;
import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class MemoryBlock extends MemoryElement {

    private List<AddressBlock> addressBlockList;

    public MemoryBlock(List<AddressBlock> addressBlockList, String description) {
        super(description);
        this.addressBlockList = addressBlockList;
        setParentForAddresses();
    }

    private void setParentForAddresses() {
        for(AddressBlock addres: addressBlockList){
            addres.setParent(this);
        }
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

    @Override
    public void setMemoryElementView(MemoryElementView memoryElementView) {
        super.setMemoryElementView(memoryElementView);

        memoryElementView.getX();
//        memoryElementView.getY

    }

    public Point getDrawPointForAddress(AddressBlock addressBlock) {

        int addressX = memoryElementView.getX();

        int height = memoryElementView.getHeight();
        int blockY = memoryElementView.getY();

        int indexOfAddress = addressBlockList.indexOf(addressBlock)+1;

        int addressY = blockY + height/indexOfAddress;

        return new Point(addressX,addressY);
    }
}
