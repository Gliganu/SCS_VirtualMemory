package view;

import controller.Chapter;
import model.MemoryBlock;
import model.MemoryElement;
import model.MemoryLink;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class MemoryElementViewFactory {


    private static final int ADDRESS_BLOCK_WIDTH = 100;
    private static final int ADDRESS_BLOCK_HEIGHT = 30;

    public static void constructMemoryViewForChapter(Chapter chapter) {

        switch (chapter.getType()) {
            case NOT_ENOUGH_MEMORY:
                constructNotEnoughMemoryChapterView(chapter);
                break;
            case MEMORY_FRAGMENTATION:
                constructMemoryFragmentationChapterView(chapter);
                break;
            case SECURITY:
                constructSecurityChapterView(chapter);
                break;
        }


    }

    private static void constructSecurityChapterView(Chapter chapter) {

        List<MemoryElement> memoryElementList = chapter.getMemoryElementList();

        List<MemoryBlock> memoryBlockList = memoryElementList.subList(0, 3).stream().map(memoryElement -> (MemoryBlock) memoryElement).collect(Collectors.toList());
        List<MemoryLink> memoryLinkList = memoryElementList.subList(3, memoryElementList.size()).stream().map(memoryElement -> (MemoryLink) memoryElement).collect(Collectors.toList());


        //-------
        MemoryBlock blueMemoryBlock = memoryBlockList.get(0);
        attachView(blueMemoryBlock, 120, 110, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.BLUE);

        //-------
        MemoryBlock greenMemoryBlock = memoryBlockList.get(1);
        attachView(greenMemoryBlock, 700, 110, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.GREEN);

        //-------
        MemoryBlock purpleMemoryBlock = memoryBlockList.get(2);
        attachView(purpleMemoryBlock, 120, 300, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.pink);

        //-------
        MemoryLink memLink1 = memoryLinkList.get(0);
        attachView(memLink1, -1, -1, -1, -1, Color.RED);

        //-------
        MemoryLink memLink2 = memoryLinkList.get(1);
        attachView(memLink2, 1, -1, -1, -1, Color.RED);

    }

    private static void constructMemoryFragmentationChapterView(Chapter chapter) {

        List<MemoryElement> memoryElementList = chapter.getMemoryElementList();

        List<MemoryBlock> memoryBlockList = memoryElementList.stream().map(memoryElement -> (MemoryBlock) memoryElement).collect(Collectors.toList());

        //-------
        MemoryBlock greenMemoryBlock = memoryBlockList.get(0);
        attachView(greenMemoryBlock, 100, 250, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.GREEN);

        //-------
        MemoryBlock blueMemoryBlock = memoryBlockList.get(1);
        attachView(blueMemoryBlock, 225, 50, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.BLUE, true);

        //-------
        MemoryBlock purpleMemoryBlock = memoryBlockList.get(2);
        attachView(purpleMemoryBlock, 500, 50, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.pink, true);

        //-------
        MemoryBlock orangeMemoryBlock = memoryBlockList.get(3);
        attachView(orangeMemoryBlock, 800, 50, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.orange, true);

        //-------
        MemoryBlock afterBlueMemoryBlock = memoryBlockList.get(4);
        attachView(afterBlueMemoryBlock, 100, 250, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.blue, true);

        //-------
        MemoryBlock afterPurpleMemoryBlock = memoryBlockList.get(5);
        attachView(afterPurpleMemoryBlock, 100, 250 + 3 * ADDRESS_BLOCK_HEIGHT, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.pink, true);

    }

    private static void constructNotEnoughMemoryChapterView(Chapter chapter) {

        List<MemoryElement> memoryElementList = chapter.getMemoryElementList();

        List<MemoryBlock> memoryBlockList = memoryElementList.subList(0, 2).stream().map(memoryElement -> (MemoryBlock) memoryElement).collect(Collectors.toList());
        List<MemoryLink> memoryLinkList = memoryElementList.subList(2, memoryElementList.size()).stream().map(memoryElement -> (MemoryLink) memoryElement).collect(Collectors.toList());


        //-------
        MemoryBlock blueMemoryBlock = memoryBlockList.get(0);
        attachView(blueMemoryBlock, 120, 110, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.BLUE);

        //-------
        MemoryBlock greenMemoryBlock = memoryBlockList.get(1);
        attachView(greenMemoryBlock, 570, 110, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.GREEN);

        //-------
        MemoryLink memLink1 = memoryLinkList.get(0);
        attachView(memLink1, -1, -1, -1, -1, Color.RED);

        //-------
        MemoryLink memLink2 = memoryLinkList.get(1);
        attachView(memLink2, 1, -1, -1, -1, Color.RED);

        //-------
        MemoryLink memLink3 = memoryLinkList.get(2);
        attachView(memLink3, 1, -1, -1, -1, Color.RED);

        //-------
        MemoryLink memLink4 = memoryLinkList.get(3);
        attachView(memLink4, 1, -1, -1, -1, Color.RED);


    }


    public static void attachView(MemoryElement element, int x, int y, int w, int h,Color color) {
        attachView(element, x, y, w, h, color, false);
    }

    public static void attachView(MemoryElement element, int x, int y, int w, int h, Color color, boolean insideDescription) {

        int elementHeight;

        if (element instanceof MemoryBlock) {
            MemoryBlock memoryBlock = (MemoryBlock) element;
            int addressListSize = memoryBlock.getAddressBlockList().size();
            elementHeight = addressListSize * h;
        } else {
            elementHeight = h;
        }


        MemoryElementView memoryElementView = new MemoryElementView(x, y, w, elementHeight, color);

        memoryElementView.setInsideDescription(insideDescription);
        element.setMemoryElementView(memoryElementView);

    }

}
