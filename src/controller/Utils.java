package controller;

import model.AddressBlock;
import model.ChapterQuiz;
import model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class Utils {


    public static List<AddressBlock> getRandomAddressBlocks(int nrBlocks) {

        List<AddressBlock> addressBlockList = new ArrayList<>();

        for (int i = 0; i < nrBlocks; i++) {
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
            case NOT_ENOUGH_MEMORY_SOLUTION:
                return getStoriesForNotEnougMemorysolutionChapter();
            case MEMORY_FRAGMENTATION_SOLUTION:
                return getStoriesForMemoryFragmentationsolutionChapter();
            case ACCESS_MEMORY_DETAIL:
                return getStoriesForAccessMemoryDetailChapter();
            case PAGE_TABLE:
                return getStoriesForPageTableChapter();
            case SECURITY_SOLUTION:
                return getStoriesForSecuritySolutionChapter();
        }

        return null;

    }

    public static List<ChapterQuiz> getQuizzesForChapter(Type notEnoughMemory) {

        switch (notEnoughMemory) {
            case NOT_ENOUGH_MEMORY:
                return getQuizzesForNotEnoughMemoryChapter();
            case MEMORY_FRAGMENTATION:
                return getQuizzesForMemoryFragmentationChapter();
            case SECURITY:
                return getQuizzesForSecurityChapter();
            case NOT_ENOUGH_MEMORY_SOLUTION:
                return getQuizzesForNotEnougMemorySolutionChapter();
            case MEMORY_FRAGMENTATION_SOLUTION:
                return getQuizzesForMemoryFragmentationSolutionChapter();
            case ACCESS_MEMORY_DETAIL:
                return getQuizzesForAccessMemoryDetailChapter();
            case PAGE_TABLE:
                return getQuizzesForPageTableChapter();
            case SECURITY_SOLUTION:
                return getQuizzesForSecuritySolutionChapter();
        }

        return null;

    }

    private static List<ChapterQuiz> getQuizzesForSecuritySolutionChapter() {
        List<ChapterQuiz> chapterQuizList = new ArrayList<>();

        String question = "What is a downside of complete isolation of programs?";
        List<String> options = new ArrayList<>();
        options.add("Programs can't corrupt each other");
        options.add("Programs can't sahre data with each other");
        options.add("Programs use more space because they have their own address space");
        options.add("Programs are slower because they always have to check the disk for data");
        String answer = "Programs can't sahre data with each other";
        String answerMotivation = "A lot of data is shared between programs";
        ChapterQuiz c1 = new ChapterQuiz(question, options, answer, answerMotivation);
        chapterQuizList.add(c1);

        return chapterQuizList;
    }

    private static List<ChapterQuiz> getQuizzesForPageTableChapter() {
        List<ChapterQuiz> chapterQuizList = new ArrayList<>();

        String question = "How many entries do we need in our Page Table";
        List<String> options = new ArrayList<>();
        options.add("1 for every byte = 2^32 = 4 billion");
        options.add("1 for every word = 2^30 = 1 billion");
        options.add("1 for every register = 32");
        String answer = "1 for every word = 2^30 = 1 billion";
        String answerMotivation = "We have a word-aligned memory, so we need to be able to address every word";
        ChapterQuiz c1 = new ChapterQuiz(question, options, answer, answerMotivation);
        chapterQuizList.add(c1);

        return chapterQuizList;
    }

    private static List<ChapterQuiz> getQuizzesForAccessMemoryDetailChapter() {
        List<ChapterQuiz> chapterQuizList = new ArrayList<>();

        String question = "R12 has the value 1536. A program issues \"ld R3,0(R12)\". What location in RAM is accessed?";
        List<String> options = new ArrayList<>();
        options.add("RAM address 0");
        options.add("RAM address 1536");
        options.add("Need more information");
        String answer = "Need more information";
        String answerMotivation = "We need to know the VA - > PA mapping";
        ChapterQuiz c1 = new ChapterQuiz(question, options, answer, answerMotivation);
        chapterQuizList.add(c1);

        String question2 = "If a program uses more data than can fit into RAM, where does the data go?";
        List<String> options2 = new ArrayList<>();
        options2.add("Unused RAM");
        options2.add("Can't use more than what can fit into RAM");
        options2.add("Disk");
        String answer2 = "Disk";
        String answerMotivation2 = "If data doesn't fit in RAM, then the Page Table will map those VAs to Disk";
        ChapterQuiz c2 = new ChapterQuiz(question2, options2, answer2, answerMotivation2);
        chapterQuizList.add(c2);

        return chapterQuizList;
    }

    private static List<ChapterQuiz> getQuizzesForMemoryFragmentationSolutionChapter() {
        return new ArrayList<>();
    }

    private static List<ChapterQuiz> getQuizzesForNotEnougMemorySolutionChapter() {
        List<ChapterQuiz> chapterQuizList = new ArrayList<>();

        String question = "What is going to happen to program performance when data is on disk and not in memory ?";
        List<String> options = new ArrayList<>();
        options.add("Better performance: we can use more memory than we have");
        options.add("Nothing: mapping to memory or disk is just as easy");
        options.add("Worst performance: reading from disk is slower than RAM");
        String answer = "Worst performance: reading from disk is slower than RAM";
        String answerMotivation = "Disks are 1000x slower than RAM";
        ChapterQuiz c1 = new ChapterQuiz(question, options, answer, answerMotivation);
        chapterQuizList.add(c1);

        return chapterQuizList;
    }

    private static List<ChapterQuiz> getQuizzesForSecurityChapter() {
        List<ChapterQuiz> chapterQuizList = new ArrayList<>();

        String question = "Which of these is NOT a problem if all programs share a 32-bit address space and we don't have 4 GB RAM?";
        List<String> options = new ArrayList<>();
        options.add("Reading some addresses will cause a crash");
        options.add("Can't reach full memory range due to 16-bit MIPS immediate");
        options.add("Programs can overwrite each other's data");
        options.add("Programs may not fit together");
        String answer = "Can't reach full memory range due to 16-bit MIPS immediate";
        String answerMotivation = "We can always reach the full address space. Use 16-bit imm to create 32-bit imm";
        ChapterQuiz c1 = new ChapterQuiz(question, options, answer, answerMotivation);
        chapterQuizList.add(c1);

        return chapterQuizList;
    }

    private static List<ChapterQuiz> getQuizzesForMemoryFragmentationChapter() {
        return new ArrayList<>();
    }

    private static List<ChapterQuiz> getQuizzesForNotEnoughMemoryChapter() {

        List<ChapterQuiz> chapterQuizList = new ArrayList<>();

        String question = "How muych memory can you access with a 32 bit address?";
        List<String> options = new ArrayList<>();
        options.add("2^30 bytes = 1GB");
        options.add("2^32 bytes = 4GB");
        options.add("2^32 words = 16GB");
        String answer = "2^32 bytes = 4GB";
        String answerMotivation = "Because you have 32 bits, you can access 2^32 address";
        ChapterQuiz c1 = new ChapterQuiz(question, options, answer, answerMotivation);
        chapterQuizList.add(c1);

        return chapterQuizList;
    }


    private static List<String> getStoriesForPageTableChapter() {
        List<String> stories = new ArrayList<>();

        stories.add("Too many entries if 1-on-1 address mapping");
        stories.add("Idea: create address page mapping");
        stories.add("Each VA page maps to a PA space");
        stories.add("Offset within page is kept for each address");

        return stories;

    }

    private static List<String> getStoriesForAccessMemoryDetailChapter() {
        List<String> stories = new ArrayList<>();

        stories.add("Program executes a load with a VA");
        stories.add("Computer translates VA to PA");
        stories.add("Read RAM using PA and return data to program");
        stories.add("No memory operation for \"add\" instruction");
        stories.add("If PA not in RAM, load it from disk");
        stories.add("Update mapping value");
        stories.add("Next accessing, read it from RAM directly");


        return stories;
    }

    private static List<String> getStoriesForMemoryFragmentationsolutionChapter() {

        List<String> stories = new ArrayList<>();

        stories.add("We can do the mapping however we like");
        stories.add("Each program has its own mapping");
        stories.add("Mapping gives us flexibility in the RAM");


        return stories;
    }

    public static List<ChapterQuiz> getRandomChapterQuiz(String name) {

        List<ChapterQuiz> chapterQuizList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            String question = name + " - This song makes me feel like I found something I didn't know I missed. What is the meaning of life ? ";

            List<String> options = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                options.add("Option " + j);
            }

            String answer = "Option 2";

            String answerMotivation = "Something similar happens for me as well. It reminds me of weekends with my brother, sister, \n and I spending the night with our cousin Patricia at her mom's house. My aunt Theresa, her mother, had a HUGE finished basement, beautiful. Large TV for all our childhood movies. Stereo complete with vinyl, 8-track, cassette, and CD abilities.";


            chapterQuizList.add(new ChapterQuiz(question, options, answer, answerMotivation));

        }

        return chapterQuizList;
    }

    private static List<String> getStoriesForSecuritySolutionChapter() {

        List<String> stories = new ArrayList<>();

        stories.add("Each program with its address space, no data corruption");
        stories.add("Program 1 stores you bank balance at address 1024");
        stories.add("VM maps it to RAM address 4");
        stories.add("Program 2 stores your video game score at address 1024");
        stories.add("VM maps it to RAM address 8");
        stories.add("Neither can touch other's data!");

        return stories;
    }

    private static List<String> getStoriesForNotEnougMemorysolutionChapter() {

        List<String> stories = new ArrayList<>();

        stories.add("Map some of the program's address space to disk");
        stories.add("When we need it, we bring it into memory");
        stories.add("Program loads address 0");
        stories.add("VM Maps address 0 to RAM 1");
        stories.add("Program loads address 1");
        stories.add("VM Maps address 1 to RAM 0");
        stories.add("Program loads address 2");
        stories.add("VM Maps address 2 to RAM 2");
        stories.add("Program loads address 3");
        stories.add("VM does not have any more space in RAM");
        stories.add("VM moves the oldest data (0) to disk");
        stories.add("VM updates the map to point data 0 to disk");
        stories.add("VM Maps address 3 to RAM 1");
        stories.add("Mapping gives illusion of unlimited memory");

        return stories;
    }

    private static List<String> getStoriesForSecurityChapter() {

        List<String> stories = new ArrayList<>();

        stories.add("Each program can access any 32-bit memory address");
        stories.add("What if mnultiple programs access the same address?");
        stories.add("They can corrupt or crash each other !");
        stories.add("Program 1 stores your bank balance at address 1024");
        stories.add("Program 2 stores your game info at address 1024");
        stories.add("CORRUPTED DATA ! What happens now ?");

        return stories;

    }

    private static List<String> getStoriesForMemoryFragmentationChapter() {

        List<String> stories = new ArrayList<>();

        stories.add("How do programs share the memory?");
        stories.add("Where do we put them?");
        stories.add("Program 1 fits");
        stories.add("Program 2 fits");
        stories.add("Quit Program 1");
        stories.add("MEMORY SEGMENTATION ! Can't run Program 3");

        return stories;
    }

    private static List<String> getStoriesForNotEnoughMemoryChapter() {

        List<String> stories = new ArrayList<>();

        stories.add("MIPS gives each program its own 32-bit address space");
        stories.add("Programs can access any byte in their 32-bit address sapce");
        stories.add("What if you don't have 4GB of memory?");
        stories.add("Memory access SUCCESS");
        stories.add("Memory access SUCCESS");
        stories.add("Memory access SUCCESS");
        stories.add("Memory access FAIL");
        stories.add("Crash if we try to access more than 1GB");

        return stories;
    }
}
