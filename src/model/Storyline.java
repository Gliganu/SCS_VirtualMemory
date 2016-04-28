package model;

import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class Storyline {

    private List<String> storyList;
    private int currentIndex = 0;

    public Storyline(List<String> storyList) {
        this.storyList = storyList;
    }

    public String getNextStory(){

        if(currentIndex >= storyList.size()){
            return "";
        }

        String nextStory = storyList.get(currentIndex);

        currentIndex++;

        return nextStory;

    }

    public List<String> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<String> storyList) {
        this.storyList = storyList;
        currentIndex = 0;
    }
}
