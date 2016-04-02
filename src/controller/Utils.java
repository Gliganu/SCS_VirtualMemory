package controller;

import model.AddressBlock;
import model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class Utils {


    public static List<Chapter> getRandomChapters(){

        List<Chapter> chapterList = new ArrayList<>();

        for(int i= 0;i<10;i++){
            chapterList.add(new Chapter("Test " + i, null, null, null, null, null));
        }

        return chapterList;

    }

    public static List<String> getRandomStories(){

        List<String> storyList = new ArrayList<>();

        for(int i= 0;i<10;i++){
            storyList.add("This is a test story bla bla " + i);
        }

        return storyList;

    }

    public static List<AddressBlock> getRandomAddressBlocks(int nrBlocks){

        List<AddressBlock> addressBlockList = new ArrayList<>();

        for(int i = 0;i < nrBlocks ;i++){
            AddressBlock addressBlock = new AddressBlock("", "", "");
            addressBlockList.add(addressBlock);

        }

        return addressBlockList;
    }

    public static List<String> getStoriesForChapter(Type notEnoughMemory) {

        switch (notEnoughMemory) {
            case NOT_ENOUGH_MEMORY:
                return getStoriesForNotEnoughMemoryChapter();
            case MEMORY_FRAGMENTATION:
                return getStoriesForMemoryFragmentationChapter();
            case SECURITY:
                return getStoriesForSecurityChapter();
        }

        return null;

    }

    private static List<String> getStoriesForSecurityChapter() {

        List<String> stories = new ArrayList<>();

        stories.add("Each program can access any 32-bit memory address");
        stories.add("What if mnultiple programs access the same address?");
        stories.add("They can corrupt or crash each other !");
        stories.add("Program 1 stores your bank balance at address 1024");
        stories.add("Program 2 stores your game info at address 1024");
        stories.add("What happens now ?");

        return stories;

    }

    private static List<String> getStoriesForMemoryFragmentationChapter() {

        List<String> stories = new ArrayList<>();

        stories.add("How do programs share the memory?");
        stories.add("Where do we put them?");
        stories.add("Programs 1 and 2 fit");
        stories.add("Quit Program 1");
        stories.add("Can't run Program 3");

        return stories;
    }

    private static List<String> getStoriesForNotEnoughMemoryChapter() {

        List<String> stories = new ArrayList<>();

        stories.add("MIPS gives each program its own 32-bit address space");
        stories.add("Programs can access any byte in their 32-bit address sapce");
        stories.add("What if you don't have 4GB of memory?");

        return stories;
    }
}
