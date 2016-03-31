package controller;

import model.AddressBlock;
import model.MemoryBlock;
import model.MemoryElement;
import view.MemoryElementView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class Utils {


    public static List<Chapter> getRandomChapters(){

        List<Chapter> chapterList = new ArrayList<>();

        for(int i= 0;i<10;i++){
            chapterList.add(new Chapter("Test "+i,null,null,null,null));
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
            AddressBlock addressBlock = new AddressBlock("in desc", "left desc", "above desc");
            addressBlockList.add(addressBlock);

        }

        return addressBlockList;
    }

}
