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
            case NOT_ENOUGH_MEMORY_SOLLUTION:
                constructNotEnoughMemorySollutionChapterView(chapter);
                break;
            case MEMORY_FRAGMENTATION_SOLLUTION:
                constructMemoryFragmentationSollutionChapterView(chapter);
                break;
        }


    }

    private static void constructMemoryFragmentationSollutionChapterView(Chapter chapter) {
        List<MemoryElement> memoryElementList = chapter.getMemoryElementList();

        List<MemoryBlock> memoryBlockList = memoryElementList.subList(0, 5).stream().map(memoryElement -> (MemoryBlock) memoryElement).collect(Collectors.toList());
        List<MemoryLink> memoryLinkList = memoryElementList.subList(5, memoryElementList.size()).stream().map(memoryElement -> (MemoryLink) memoryElement).collect(Collectors.toList());

        //-------
        MemoryBlock blueMemoryBlock = memoryBlockList.get(0);
        attachView(blueMemoryBlock, 120, 110, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.CYAN).setOnePiece(true);

        //-------
        MemoryBlock purpleMemoryBlock = memoryBlockList.get(1);
        attachView(purpleMemoryBlock, 120, 350, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.PINK).setOnePiece(true);

        //-------
        MemoryBlock blueOrangeMap = memoryBlockList.get(2);
        attachView(blueOrangeMap, 370, 110, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.ORANGE).setOnePiece(true);

        //-------
        MemoryBlock purpleOrangeMap = memoryBlockList.get(3);
        attachView(purpleOrangeMap, 370, 350, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.ORANGE).setOnePiece(true);

        //-------
        MemoryBlock greenMemoryBlock = memoryBlockList.get(4);
        attachView(greenMemoryBlock, 700, 130, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.GREEN);


        for (MemoryLink link : memoryLinkList.subList(0, 12)) {
            attachView(link, -1, -1, -1, -1, Color.RED);
        }


        for (MemoryLink link : memoryLinkList.subList(12, memoryLinkList.size())) {
            attachView(link, -1, -1, -1, -1, Color.BLUE);
        }
    }

    private static void constructNotEnoughMemorySollutionChapterView(Chapter chapter) {
        List<MemoryElement> memoryElementList = chapter.getMemoryElementList();

        List<MemoryBlock> memoryBlockList = memoryElementList.subList(0, 4).stream().map(memoryElement -> (MemoryBlock) memoryElement).collect(Collectors.toList());
        List<MemoryLink> memoryLinkList = memoryElementList.subList(4, memoryElementList.size()).stream().map(memoryElement -> (MemoryLink) memoryElement).collect(Collectors.toList());


//        -------
        MemoryBlock blueMemoryBlock = memoryBlockList.get(0);
        attachView(blueMemoryBlock, 120, 110, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.cyan);

//        -------
        MemoryBlock greenMemoryBlock = memoryBlockList.get(1);
        attachView(greenMemoryBlock, 730, 110, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.GREEN);


//        -------
        MemoryBlock orangeMemoryBlock = memoryBlockList.get(2);
        MemoryElementView mapView = attachView(orangeMemoryBlock, 430, 200, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.ORANGE);
        mapView.setOnePiece(true);


//        -------
        MemoryBlock diskMemoryBlock = memoryBlockList.get(3);
        MemoryElementView diskView = attachView(diskMemoryBlock, 730, 410, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.MAGENTA);
        diskView.setOnePiece(true);

        for (MemoryLink link : memoryLinkList) {
            attachView(link, -1, -1, -1, -1, Color.RED);
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

        for (MemoryLink link : memoryLinkList) {
            attachView(link, -1, -1, -1, -1, Color.RED);
        }

    }

    private static void constructMemoryFragmentationChapterView(Chapter chapter) {

        List<MemoryElement> memoryElementList = chapter.getMemoryElementList();

        List<MemoryBlock> memoryBlockList = memoryElementList.stream().map(memoryElement -> (MemoryBlock) memoryElement).collect(Collectors.toList());

        //-------
        MemoryBlock greenMemoryBlock = memoryBlockList.get(0);
        attachView(greenMemoryBlock, 100, 250, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.GREEN);

        //-------
        MemoryBlock blueMemoryBlock = memoryBlockList.get(1);
        MemoryElementView blueView = attachView(blueMemoryBlock, 225, 50, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.BLUE, true);
        blueView.setOnePiece(true);

        //-------
        MemoryBlock purpleMemoryBlock = memoryBlockList.get(2);
        MemoryElementView purpleView = attachView(purpleMemoryBlock, 500, 50, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.pink, true);
        purpleView.setOnePiece(true);

        //-------
        MemoryBlock orangeMemoryBlock = memoryBlockList.get(3);
        MemoryElementView orangeView = attachView(orangeMemoryBlock, 800, 50, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.orange, true);
        orangeView.setOnePiece(true);

        //-------
        MemoryBlock afterBlueMemoryBlock = memoryBlockList.get(4);
        MemoryElementView afterBlueView = attachView(afterBlueMemoryBlock, 100, 250, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.blue, true);
        afterBlueView.setOnePiece(true);

        //-------
        MemoryBlock afterPurpleMemoryBlock = memoryBlockList.get(5);
        MemoryElementView afterPurpleView = attachView(afterPurpleMemoryBlock, 100, 250 + 3 * ADDRESS_BLOCK_HEIGHT, ADDRESS_BLOCK_WIDTH, ADDRESS_BLOCK_HEIGHT, Color.pink, true);
        afterPurpleView.setOnePiece(true);

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

        for (MemoryLink link : memoryLinkList) {
            attachView(link, -1, -1, -1, -1, Color.RED);
        }


    }


    public static MemoryElementView attachView(MemoryElement element, int x, int y, int w, int h, Color color) {
        return attachView(element, x, y, w, h, color, false);
    }

    public static MemoryElementView attachView(MemoryElement element, int x, int y, int w, int h, Color color, boolean insideDescription) {

        int elementHeight;

        if (element instanceof MemoryBlock) {
            MemoryBlock memoryBlock = (MemoryBlock) element;
            int addressListSize = memoryBlock.getAddressBlockList().size();
            elementHeight = addressListSize * h;
        } else {
            elementHeight = h;
        }


        MemoryElementView memoryElementView = new MemoryElementView(x, y, w, elementHeight, color);
        memoryElementView.setWithInsideDescription(insideDescription);
        element.setMemoryElementView(memoryElementView);

        return memoryElementView;

    }

}
