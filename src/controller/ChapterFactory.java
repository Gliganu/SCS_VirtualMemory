package controller;

import model.*;
import model.Command.CommandType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class ChapterFactory {


    public static List<Chapter> getAllChapters() {

        List<Chapter> chapterList = new ArrayList<>();

        for (Type chapterType : Type.values()) {
            chapterList.add(getChapter(chapterType));
        }

        return chapterList;
    }

    private static Chapter getChapter(Type chapterType) {

        switch (chapterType) {

            case NOT_ENOUGH_MEMORY:
                return notEnoughMemoryProblemChapter();
            case MEMORY_FRAGMENTATION:
                return memoryFragmentationProblemChapter();
            case SECURITY:
                return securityChapter();
            case NOT_ENOUGH_MEMORY_SOLLUTION:
                return notEnoughMemorySollutionChapter();
            case MEMORY_FRAGMENTATION_SOLLUTION:
                return memoryFragmentationSollutionChapter();
            case ACCESS_MEMORY_DETAIL:
                return accessMemoryDetailChapter();
            case PAGE_TABLE:
                return pageTableChapter();
        }

        return null;

    }

    private static Chapter pageTableChapter() {

        String name = "Page Table";

        Type chapterType = Type.PAGE_TABLE;

        Storyline storyline = new Storyline(Utils.getStoriesForChapter(chapterType));

        MemoryBlock blueMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3), "4kb");
        MemoryBlock blue2 = new MemoryBlock(Utils.getRandomAddressBlocks(3), "4kb");
        MemoryBlock blue3 = new MemoryBlock(Utils.getRandomAddressBlocks(3), "4kb");
        MemoryBlock blue4 = new MemoryBlock(Utils.getRandomAddressBlocks(3), "4kb");

        MemoryBlock greenMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3), "4kb");
        MemoryBlock green2 = new MemoryBlock(Utils.getRandomAddressBlocks(3), "4kb");
        MemoryBlock green3 = new MemoryBlock(Utils.getRandomAddressBlocks(3), "4kb");

        MemoryBlock orangeMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(4), "");

        List<MemoryElement> memoryElementList = new ArrayList<>();

        memoryElementList.add(blueMemoryBlock);
        memoryElementList.add(blue2);
        memoryElementList.add(blue3);
        memoryElementList.add(blue4);
        memoryElementList.add(greenMemoryBlock);
        memoryElementList.add(green2);
        memoryElementList.add(green3);
        memoryElementList.add(orangeMemoryBlock);

        MemoryLink link1 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(0), green2.getAddressBlockAt(0), "");
        MemoryLink link2 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(2), green2.getAddressBlockAt(2), "");
        MemoryLink link3 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(1), green2.getAddressBlockAt(1), "150");


        memoryElementList.add(link1);
        memoryElementList.add(link2);
        memoryElementList.add(link3);

        List<Command> commandList = new ArrayList<>();

        Command c2 = new Command(CommandType.ELEMENT_VISIBILITY, blueMemoryBlock, true);
        c2.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, blue2, true));
        c2.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, blue3, true));
        c2.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, blue4, true));
        c2.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, green2, true));
        c2.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, green3, true));
        c2.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, greenMemoryBlock, true));
        c2.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, orangeMemoryBlock, true));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, orangeMemoryBlock.getAddressBlockAt(0), "VA   |   PA"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, orangeMemoryBlock.getAddressBlockAt(1), "0-4095   |   4096 - 8191"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, blueMemoryBlock.getAddressBlockAt(2), "0"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, blueMemoryBlock.getAddressBlockAt(0), "4095"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, blue2.getAddressBlockAt(2), "4096"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, blue2.getAddressBlockAt(0), "8191"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, blue3.getAddressBlockAt(2), "8192"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, blue3.getAddressBlockAt(0), "12287"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, blue4.getAddressBlockAt(2), "12288"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, blue4.getAddressBlockAt(0), "16383"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, greenMemoryBlock.getAddressBlockAt(2), "0"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, greenMemoryBlock.getAddressBlockAt(0), "4095"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, green2.getAddressBlockAt(2), "4096"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, green2.getAddressBlockAt(0), "8191"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, green3.getAddressBlockAt(2), "8192"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, green3.getAddressBlockAt(0), "12287"));


        Command c3 = new Command(CommandType.ELEMENT_VISIBILITY, link1, true);
        c3.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, link2, true));


        Command c4 = new Command(CommandType.ELEMENT_VISIBILITY, link3, true);
        c4.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, blueMemoryBlock.getAddressBlockAt(1), "150"));
        c4.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE_LEFT, green2.getAddressBlockAt(1), "4246"));

        commandList.add(c2);
        commandList.add(c3);
        commandList.add(c4);

        return new Chapter(name, storyline, memoryElementList, null, commandList, chapterType);
    }

    private static Chapter accessMemoryDetailChapter() {
        String name = "How VM access memory";

        Type chapterType = Type.ACCESS_MEMORY_DETAIL;

        Storyline storyline = new Storyline(Utils.getStoriesForChapter(chapterType));

        MemoryBlock blueMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(6), "");
        MemoryBlock greenMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(6), "");
        MemoryBlock orangeMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(4), "");
        MemoryBlock diskBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3), "Disk");


        MemoryLink link1 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(0), orangeMemoryBlock.getAddressBlockAt(3), "VA 1024");
        MemoryLink link2 = new MemoryLink(orangeMemoryBlock.getAddressBlockAt(3), greenMemoryBlock.getAddressBlockAt(2), "PA 2");

        MemoryLink link3 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(1), orangeMemoryBlock.getAddressBlockAt(1), "VA 512");
        MemoryLink link4 = new MemoryLink(orangeMemoryBlock.getAddressBlockAt(1), greenMemoryBlock.getAddressBlockAt(5), "PA 12");

        MemoryLink link5 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(3), orangeMemoryBlock.getAddressBlockAt(2), "VA 786");
        MemoryLink link6 = new MemoryLink(orangeMemoryBlock.getAddressBlockAt(2), diskBlock.getAddressBlockAt(1), "Disk");
        MemoryLink link7 = new MemoryLink(diskBlock.getAddressBlockAt(1), greenMemoryBlock.getAddressBlockAt(4), "");

        MemoryLink link8 = new MemoryLink(orangeMemoryBlock.getAddressBlockAt(2), greenMemoryBlock.getAddressBlockAt(4), "PA 4");

        List<MemoryElement> memoryElementList = new ArrayList<>();

        memoryElementList.add(blueMemoryBlock);
        memoryElementList.add(greenMemoryBlock);
        memoryElementList.add(orangeMemoryBlock);
        memoryElementList.add(diskBlock);

        memoryElementList.add(link1);
        memoryElementList.add(link2);
        memoryElementList.add(link3);
        memoryElementList.add(link4);
        memoryElementList.add(link5);
        memoryElementList.add(link6);
        memoryElementList.add(link7);
        memoryElementList.add(link8);

        List<Command> commandList = new ArrayList<>();

        Command c1 = new Command(CommandType.ELEMENT_VISIBILITY, blueMemoryBlock, true);
        c1.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, orangeMemoryBlock, true));
        c1.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, greenMemoryBlock, true));
        c1.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, diskBlock, true));


        Command c2 = new Command(CommandType.ADDRESS_BLOCK_WRITE, orangeMemoryBlock.getAddressBlockAt(0), "VA   |   PA");
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, orangeMemoryBlock.getAddressBlockAt(1), "512   |   5"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, orangeMemoryBlock.getAddressBlockAt(2), "786   |   disk"));
        c2.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, orangeMemoryBlock.getAddressBlockAt(3), "1014   |   2"));


        Command c3 = new Command(CommandType.ADDRESS_BLOCK_WRITE, blueMemoryBlock.getAddressBlockAt(0), "ld R3, 1024");
        Command c4 = new Command(CommandType.ELEMENT_VISIBILITY, link1, true);
        Command c5 = new Command(CommandType.ELEMENT_VISIBILITY, link2, true);
        c5.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(2), "data for R3"));


        Command c6 = new Command(CommandType.ADDRESS_BLOCK_WRITE, blueMemoryBlock.getAddressBlockAt(1), "ld R2, 512");
        c6.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, link1, false));
        c6.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, link2, false));
        Command c7 = new Command(CommandType.ELEMENT_VISIBILITY, link3, true);
        Command c8 = new Command(CommandType.ELEMENT_VISIBILITY, link4, true);
        c8.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(5), "data for R2"));


        Command c9 = new Command(CommandType.ADDRESS_BLOCK_WRITE, blueMemoryBlock.getAddressBlockAt(2), "add R4, R3, R2");
        c9.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, link3, false));
        c9.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, link4, false));

        Command c10 = new Command(CommandType.ADDRESS_BLOCK_WRITE, blueMemoryBlock.getAddressBlockAt(3), "ld R5, 786");
        Command c11 = new Command(CommandType.ELEMENT_VISIBILITY, link5, true);
        Command c12 = new Command(CommandType.ELEMENT_VISIBILITY, link6, true);
        Command c13 = new Command(CommandType.ELEMENT_VISIBILITY, link7, true);
        c13.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(4), "data for R5"));


        Command c14 = new Command(CommandType.ADDRESS_BLOCK_WRITE, orangeMemoryBlock.getAddressBlockAt(2), "786   |   4");
        c14.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, link5, false));
        c14.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, link6, false));
        c14.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, link7, false));

        Command c15 = new Command(CommandType.ADDRESS_BLOCK_WRITE, blueMemoryBlock.getAddressBlockAt(1), "ld R5, 786");
        Command c16 = new Command(CommandType.ELEMENT_VISIBILITY, link5, true);
        Command c17 = new Command(CommandType.ELEMENT_VISIBILITY, link8, true);
        c17.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(4), "data for R5"));


        commandList.add(c1);
        commandList.add(c2);
        commandList.add(c3);
        commandList.add(c4);
        commandList.add(c5);
        commandList.add(c6);
        commandList.add(c7);
        commandList.add(c8);
        commandList.add(c9);
        commandList.add(c10);
        commandList.add(c11);
        commandList.add(c12);
        commandList.add(c13);
        commandList.add(c14);
        commandList.add(c15);
        commandList.add(c16);
        commandList.add(c17);


        return new Chapter(name, storyline, memoryElementList, null, commandList, chapterType);

    }

    private static Chapter memoryFragmentationSollutionChapter() {

        String name = "Memory Fragmentation Sollution";

        Type chapterType = Type.MEMORY_FRAGMENTATION_SOLLUTION;

        Storyline storyline = new Storyline(Utils.getStoriesForChapter(chapterType));

        MemoryBlock blueMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(6), "Program 3 2 GB");
        MemoryBlock purpleMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(6), "Program 2 2 GB");

        MemoryBlock blueOrangeMap = new MemoryBlock(Utils.getRandomAddressBlocks(6), "Map 3");
        MemoryBlock purpleOrangeMap = new MemoryBlock(Utils.getRandomAddressBlocks(6), "Map 2");

        MemoryBlock greenMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(12), "");

        List<MemoryElement> memoryElementList = new ArrayList<>();

        memoryElementList.add(blueMemoryBlock);
        memoryElementList.add(purpleMemoryBlock);
        memoryElementList.add(blueOrangeMap);
        memoryElementList.add(purpleOrangeMap);
        memoryElementList.add(greenMemoryBlock);

        List<Command> commandList = new ArrayList<>();

        Command c1 = new Command(CommandType.ELEMENT_VISIBILITY, blueMemoryBlock, true);
        c1.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, purpleMemoryBlock, true));
        c1.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, greenMemoryBlock, true));

        Command c2 = new Command(CommandType.ELEMENT_VISIBILITY, blueOrangeMap, true);
        c2.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, purpleOrangeMap, true));

        commandList.add(c1);
        commandList.add(c2);

        Command c3 = new Command(CommandType.NEXT_STORY);

        for (int i = 0; i < 6; i++) {
            MemoryLink memoryLink = new MemoryLink(purpleMemoryBlock.getAddressBlockAt(i), purpleOrangeMap.getAddressBlockAt(i), "");
            memoryElementList.add(memoryLink);
            c3.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, memoryLink, true));
        }

        Command c4 = new Command(CommandType.NEXT_STORY);

        for (int i = 0; i < 6; i++) {
            MemoryLink memoryLink = new MemoryLink(purpleOrangeMap.getAddressBlockAt(i), greenMemoryBlock.getAddressBlockAt(3 + i), "");
            memoryElementList.add(memoryLink);
            c4.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, memoryLink, true));
        }


        Command c5 = new Command(CommandType.NEXT_STORY);

        for (int i = 0; i < 6; i++) {
            MemoryLink memoryLink = new MemoryLink(blueMemoryBlock.getAddressBlockAt(i), blueOrangeMap.getAddressBlockAt(i), "");
            memoryElementList.add(memoryLink);
            c5.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, memoryLink, true));
        }

        Command c6 = new Command(CommandType.NEXT_STORY);
        for (int i = 0; i < 6; i++) {

            MemoryLink memoryLink;
            if (i < 3) {
                memoryLink = new MemoryLink(blueOrangeMap.getAddressBlockAt(i), greenMemoryBlock.getAddressBlockAt(i), "");
            } else {
                memoryLink = new MemoryLink(blueOrangeMap.getAddressBlockAt(i), greenMemoryBlock.getAddressBlockAt(6 + i), "");
            }

            memoryElementList.add(memoryLink);
            c6.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, memoryLink, true));
        }

        commandList.add(c3);
        commandList.add(c4);
        commandList.add(c5);
        commandList.add(c6);


        return new Chapter(name, storyline, memoryElementList, null, commandList, chapterType);
    }

    private static Chapter notEnoughMemorySollutionChapter() {

        String name = "Not enough memory sollution";

        Type chapterType = Type.NOT_ENOUGH_MEMORY_SOLLUTION;

        Storyline storyline = new Storyline(Utils.getStoriesForChapter(chapterType));

        MemoryBlock blueMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(10), "32-bit program address space (4 GB)");
        MemoryBlock greenMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3), "30-bit RAM address space(1 GB)");
        MemoryBlock orangeMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(4), "Map");
        MemoryBlock diskBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3), "Disk");


        MemoryLink link1 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(0), orangeMemoryBlock.getAddressBlockAt(0), "");
        MemoryLink link2 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(1), orangeMemoryBlock.getAddressBlockAt(1), "");
        MemoryLink link3 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(2), orangeMemoryBlock.getAddressBlockAt(2), "");
        MemoryLink link4 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(3), orangeMemoryBlock.getAddressBlockAt(3), "");

        MemoryLink link5 = new MemoryLink(orangeMemoryBlock.getAddressBlockAt(0), greenMemoryBlock.getAddressBlockAt(1), "");
        MemoryLink link6 = new MemoryLink(orangeMemoryBlock.getAddressBlockAt(1), greenMemoryBlock.getAddressBlockAt(0), "");
        MemoryLink link7 = new MemoryLink(orangeMemoryBlock.getAddressBlockAt(2), greenMemoryBlock.getAddressBlockAt(2), "");

        MemoryLink link8 = new MemoryLink(orangeMemoryBlock.getAddressBlockAt(0), diskBlock.getAddressBlockAt(0), "");
        MemoryLink link9 = new MemoryLink(orangeMemoryBlock.getAddressBlockAt(3), greenMemoryBlock.getAddressBlockAt(1), "");

        List<MemoryElement> memoryElementList = new ArrayList<>();

        memoryElementList.add(blueMemoryBlock);
        memoryElementList.add(greenMemoryBlock);
        memoryElementList.add(orangeMemoryBlock);
        memoryElementList.add(diskBlock);

        memoryElementList.add(link1);
        memoryElementList.add(link2);
        memoryElementList.add(link3);
        memoryElementList.add(link4);
        memoryElementList.add(link5);
        memoryElementList.add(link6);
        memoryElementList.add(link7);
        memoryElementList.add(link8);
        memoryElementList.add(link9);

        List<Command> commandList = new ArrayList<>();

        Command c1 = new Command(CommandType.ELEMENT_VISIBILITY, blueMemoryBlock, true);
        c1.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, orangeMemoryBlock, true));
        c1.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, greenMemoryBlock, true));
        c1.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, diskBlock, true));

        Command c2 = new Command(CommandType.ADDRESS_BLOCK_WRITE, blueMemoryBlock.getAddressBlockAt(0), "Program 0");
        Command c3 = new Command(CommandType.ELEMENT_VISIBILITY, link1, true);
        Command c4 = new Command(CommandType.ELEMENT_VISIBILITY, link5, true);
        c4.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(1), "Program 0"));

        Command c5 = new Command(CommandType.ADDRESS_BLOCK_WRITE, blueMemoryBlock.getAddressBlockAt(1), "Program 1");
        Command c6 = new Command(CommandType.ELEMENT_VISIBILITY, link2, true);
        Command c7 = new Command(CommandType.ELEMENT_VISIBILITY, link6, true);
        c7.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(0), "Program 1"));

        Command c8 = new Command(CommandType.ADDRESS_BLOCK_WRITE, blueMemoryBlock.getAddressBlockAt(2), "Program 2");
        Command c9 = new Command(CommandType.ELEMENT_VISIBILITY, link3, true);
        Command c10 = new Command(CommandType.ELEMENT_VISIBILITY, link7, true);
        c10.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(2), "Program 2"));


        Command c11 = new Command(CommandType.ADDRESS_BLOCK_WRITE, blueMemoryBlock.getAddressBlockAt(3), "Program 3");
        Command c12 = new Command(CommandType.ELEMENT_VISIBILITY, link4, true);
        Command c13 = new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(1), "");
        c13.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, diskBlock.getAddressBlockAt(0), "Program 0"));

        Command c14 = new Command(CommandType.ELEMENT_VISIBILITY, link8, true);
        c14.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, link5, false));


        Command c15 = new Command(CommandType.ELEMENT_VISIBILITY, link9, true);
        c15.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(1), "Program 3"));


        commandList.add(c1);
        commandList.add(c2);
        commandList.add(c3);
        commandList.add(c4);
        commandList.add(c5);
        commandList.add(c6);
        commandList.add(c7);
        commandList.add(c8);
        commandList.add(c9);
        commandList.add(c10);
        commandList.add(c11);
        commandList.add(c12);
        commandList.add(c13);
        commandList.add(c14);
        commandList.add(c15);


        return new Chapter(name, storyline, memoryElementList, null, commandList, chapterType);

    }

    private static Chapter securityChapter() {

        String name = "Application Security";

        Type chapterType = Type.SECURITY;

        Storyline storyline = new Storyline(Utils.getStoriesForChapter(chapterType));

        MemoryBlock greenMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(12), "32-bit RAM address space(1 GB)");
        MemoryBlock blueMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3), "Program 1 1GB");
        MemoryBlock purpleMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(6), "Program 2 2GB");


        MemoryLink memoryLink1 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(1), greenMemoryBlock.getAddressBlockAt(1), "Program Address 1024");
        MemoryLink memoryLink2 = new MemoryLink(purpleMemoryBlock.getAddressBlockAt(3), greenMemoryBlock.getAddressBlockAt(1), "Program Address 1024");


        List<MemoryElement> memoryElementList = new ArrayList<>();
        memoryElementList.add(blueMemoryBlock);
        memoryElementList.add(greenMemoryBlock);
        memoryElementList.add(purpleMemoryBlock);

        memoryElementList.add(memoryLink1);
        memoryElementList.add(memoryLink2);

        List<Command> commandList = new ArrayList<>();

        Command c1 = new Command(CommandType.NEXT_STORY);
        c1.addInnerCommand(new Command(CommandType.NEXT_STORY));
        c1.addInnerCommand(new Command(CommandType.NEXT_STORY));

        Command c3 = new Command(CommandType.ELEMENT_VISIBILITY, greenMemoryBlock, true);
        Command c4 = new Command(CommandType.ELEMENT_VISIBILITY, blueMemoryBlock, true);
        Command c5 = new Command(CommandType.ELEMENT_VISIBILITY, purpleMemoryBlock, true);

        Command c6 = new Command(CommandType.ELEMENT_VISIBILITY, memoryLink1, true);
        c6.addInnerCommand(new Command(CommandType.NEXT_STORY));
        c6.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(1), "112134"));

        Command c7 = new Command(CommandType.ELEMENT_VISIBILITY, memoryLink2, true);
        c7.addInnerCommand(new Command(CommandType.NEXT_STORY));
        c7.addInnerCommand(new Command(CommandType.ADDRESS_BLOCK_WRITE, greenMemoryBlock.getAddressBlockAt(1), "25435"));

        Command c8 = new Command(CommandType.NEXT_STORY);

        commandList.add(c1);
        commandList.add(c3);
        commandList.add(c4);
        commandList.add(c5);
        commandList.add(c6);
        commandList.add(c7);
        commandList.add(c8);

        return new Chapter(name, storyline, memoryElementList, null, commandList, chapterType);
    }

    private static Chapter memoryFragmentationProblemChapter() {
        String name = "Memory Fragmentation";

        Type chapterType = Type.MEMORY_FRAGMENTATION;

        Storyline storyline = new Storyline(Utils.getStoriesForChapter(chapterType));

        MemoryBlock greenMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(12), "32-bit RAM address space(1 GB)");
        MemoryBlock blueMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3), "Program 1 1GB");
        MemoryBlock purpleMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(6), "Program 2 2GB");
        MemoryBlock orangeMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3), "Program 3 1GB");

        MemoryBlock afterBlueMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3), "Program 1 1GB");
        MemoryBlock afterPurpleMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(6), "Program 2 2GB");

        List<MemoryElement> memoryElementList = new ArrayList<>();

        memoryElementList.add(greenMemoryBlock);
        memoryElementList.add(blueMemoryBlock);
        memoryElementList.add(purpleMemoryBlock);
        memoryElementList.add(orangeMemoryBlock);
        memoryElementList.add(afterBlueMemoryBlock);
        memoryElementList.add(afterPurpleMemoryBlock);

        List<Command> commandList = new ArrayList<>();

        Command c1 = new Command(CommandType.NEXT_STORY);
        c1.addInnerCommand(new Command(CommandType.NEXT_STORY));
        Command c3 = new Command(CommandType.ELEMENT_VISIBILITY, greenMemoryBlock, true);
        Command c4 = new Command(CommandType.ELEMENT_VISIBILITY, blueMemoryBlock, true);
        Command c5 = new Command(CommandType.ELEMENT_VISIBILITY, purpleMemoryBlock, true);
        Command c6 = new Command(CommandType.ELEMENT_VISIBILITY, orangeMemoryBlock, true);
        Command c7 = new Command(CommandType.ELEMENT_VISIBILITY, blueMemoryBlock, false);
        c7.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, afterBlueMemoryBlock, true));
        c7.addInnerCommand(new Command(CommandType.NEXT_STORY));
        Command c8 = new Command(CommandType.ELEMENT_VISIBILITY, purpleMemoryBlock, false);
        c8.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, afterPurpleMemoryBlock, true));
        Command c9 = new Command(CommandType.ELEMENT_VISIBILITY, blueMemoryBlock, true);
        c9.addInnerCommand(new Command(CommandType.ELEMENT_VISIBILITY, afterBlueMemoryBlock, false));
        c9.addInnerCommand(new Command(CommandType.NEXT_STORY));
        Command c10 = new Command(CommandType.NEXT_STORY);


        commandList.add(c1);
        commandList.add(c3);
        commandList.add(c4);
        commandList.add(c5);
        commandList.add(c6);
        commandList.add(c7);
        commandList.add(c8);
        commandList.add(c9);
        commandList.add(c10);

        return new Chapter(name, storyline, memoryElementList, null, commandList, chapterType);
    }

    private static Chapter notEnoughMemoryProblemChapter() {

        String name = "Not enough memory chapter";

        Type chapterType = Type.NOT_ENOUGH_MEMORY;

        Storyline storyline = new Storyline(Utils.getStoriesForChapter(chapterType));

        MemoryBlock blueMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(10), "32-bit program address space (4 GB)");
        MemoryBlock greenMemoryBlock = new MemoryBlock(Utils.getRandomAddressBlocks(3), "30-bit RAM address space(1 GB)");
        greenMemoryBlock.addHiddenAddressBlock();

        MemoryLink memoryLink1 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(0), greenMemoryBlock.getAddressBlockAt(0), "succeeds");
        MemoryLink memoryLink2 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(1), greenMemoryBlock.getAddressBlockAt(1), "succeeds");
        MemoryLink memoryLink3 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(2), greenMemoryBlock.getAddressBlockAt(2), "succeeds");
        MemoryLink memoryLink4 = new MemoryLink(blueMemoryBlock.getAddressBlockAt(3), greenMemoryBlock.getAddressBlockAt(3), "???");


        List<MemoryElement> memoryElementList = new ArrayList<>();
        memoryElementList.add(blueMemoryBlock);
        memoryElementList.add(greenMemoryBlock);

        memoryElementList.add(memoryLink1);
        memoryElementList.add(memoryLink2);
        memoryElementList.add(memoryLink3);
        memoryElementList.add(memoryLink4);

        List<Command> commandList = new ArrayList<>();

        Command c1 = new Command(CommandType.NEXT_STORY);
        Command c2 = new Command(CommandType.ELEMENT_VISIBILITY, blueMemoryBlock, true);
        Command c3 = new Command(CommandType.NEXT_STORY);
        Command c4 = new Command(CommandType.ELEMENT_VISIBILITY, greenMemoryBlock, true);
        Command c5 = new Command(CommandType.ELEMENT_VISIBILITY, memoryLink1, true);
        Command c6 = new Command(CommandType.ELEMENT_VISIBILITY, memoryLink2, true);
        Command c7 = new Command(CommandType.ELEMENT_VISIBILITY, memoryLink3, true);
        Command c8 = new Command(CommandType.ELEMENT_VISIBILITY, memoryLink4, true);

        commandList.add(c1);
        commandList.add(c2);
        commandList.add(c3);
        commandList.add(c4);
        commandList.add(c5);
        commandList.add(c6);
        commandList.add(c7);
        commandList.add(c8);


        return new Chapter(name, storyline, memoryElementList, null, commandList, chapterType);


    }
}
