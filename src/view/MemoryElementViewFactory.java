package view;

import controller.Chapter;
import controller.Utils;
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


    public static void constructMemoryViewForChapter(Chapter chapter) {

        switch (chapter.getType()) {
            case NOT_ENOUGH_MEMORY:
                constructNotEnoughMemoryChapterView(chapter);
                break;
        }


    }

    private static void constructNotEnoughMemoryChapterView(Chapter chapter) {

        List<MemoryElement> memoryElementList = chapter.getMemoryElementList();

        List<MemoryBlock> memoryBlockList = memoryElementList.subList(0, 3).stream().map(memoryElement -> (MemoryBlock) memoryElement).collect(Collectors.toList());
        List<MemoryLink> memoryLinkList = memoryElementList.subList(3, memoryElementList.size()).stream().map(memoryElement -> (MemoryLink) memoryElement).collect(Collectors.toList());


        //-------
        MemoryBlock blueMemoryBlock = memoryBlockList.get(0);
        attachView(blueMemoryBlock,10,20,40,40,Color.BLUE);

        //-------
        MemoryBlock greenMemoryBlock = memoryBlockList.get(1);
        attachView(greenMemoryBlock,60,60,40,40,Color.GREEN);

        //-------
        MemoryLink memLink1 = memoryLinkList.get(0);
        attachView(memLink1,100,60,0,0,Color.RED);

        //-------
        MemoryLink memLink2 = memoryLinkList.get(1);
        attachView(memLink2,120,50,0,0,Color.GREEN);

        //-------
        MemoryLink memLink3 = memoryLinkList.get(2);
        attachView(memLink3,140,40,0,0,Color.GREEN);


    }


    public static void attachView(MemoryElement element, int x, int y, int w, int h,Color color) {

        MemoryElementView memoryElementView = new MemoryElementView(x,y,w,h,color);

        element.setMemoryElementView(memoryElementView);

    }

}
