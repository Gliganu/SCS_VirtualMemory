package view;

import model.AddressBlock;
import model.MemoryBlock;

import java.awt.*;
import java.util.List;

/**
 * Created by GligaBogdan on 02-Apr-16.
 */
public class UIUtils {

    public static Point getDrawPointForAddressBlock(AddressBlock addressBlock, boolean isStart) {

        MemoryBlock parentMemBlock = addressBlock.getParent();

        MemoryElementView memoryElementView = parentMemBlock.getMemoryElementView();

        List<AddressBlock> addressBlockList = parentMemBlock.getAddressBlockList();


        int height = memoryElementView.getHeight();
        int blockY = memoryElementView.getY();

        int indexOfAddress = addressBlockList.indexOf(addressBlock) + 1;

        int addressY = blockY + height / addressBlockList.size() * indexOfAddress;


        int addressBlockHeight = memoryElementView.getHeight() / addressBlockList.size();
        int addressBlockWidth = parentMemBlock.getMemoryElementView().getWidth();

        //get it to be in the middle
        addressY -= addressBlockHeight / 2;

        //start point for line is at the end of starting block
        int addressX = isStart ? memoryElementView.getX() + addressBlockWidth : memoryElementView.getX();

        return new Point(addressX, addressY);

    }

}
