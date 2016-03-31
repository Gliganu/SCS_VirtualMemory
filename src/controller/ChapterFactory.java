package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class ChapterFactory {


    private static Chapter notEnoughMemoryProblemChapter(){

        String name = "Not enough memory chapter";

        Storyline storyline = new Storyline(Utils.getRandomStories());

        MemoryBlock blueMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(10),"Big Blue");
        MemoryBlock greenMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3),"Small green");

        MemoryLink memoryLink1 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(0),greenMemoryBlock.getAddressBlockAt(0),"first");
        MemoryLink memoryLink2 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(1),greenMemoryBlock.getAddressBlockAt(1),"second");
        MemoryLink memoryLink3 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(2),greenMemoryBlock.getAddressBlockAt(2),"third");


        List<MemoryElement> memoryElementList = new ArrayList<>();
        memoryElementList.add(blueMemoryBlock);
        memoryElementList.add(greenMemoryBlock);

        memoryElementList.add(memoryLink1);
        memoryElementList.add(memoryLink2);
        memoryElementList.add(memoryLink3);


        return new Chapter(name,storyline,memoryElementList,null, Type.NOT_ENOUGH_MEMORY);


    }

    public static List<Chapter> getAllChapters(){

        List<Chapter> chapterList = new ArrayList<>();

        chapterList.add(notEnoughMemoryProblemChapter());
        chapterList.addAll(Utils.getRandomChapters());

        return chapterList;
    }
}
