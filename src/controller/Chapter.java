package controller;

import model.*;
import view.ChapterDashboard;

import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class Chapter {

    private String name;
    private Storyline storyline;

    private Type type;

    private List<MemoryElement> memoryElementList;
    private List<Question> questionList;

    private ChapterDashboard dashboard;

    public Chapter(String name, Storyline storyline, List<MemoryElement> memoryElementList, List<Question> questionList, Type type) {
        this.name = name;
        this.storyline = storyline;
        this.memoryElementList = memoryElementList;
        this.questionList = questionList;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Storyline getStoryline() {
        return storyline;
    }

    public void setStoryline(Storyline storyline) {
        this.storyline = storyline;
    }

    public List<MemoryElement> getMemoryElementList() {
        return memoryElementList;
    }

    public void setMemoryElementList(List<MemoryElement> memoryElementList) {
        this.memoryElementList = memoryElementList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ChapterDashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(ChapterDashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "name='" + name + '\'' +
                ", storyline=" + storyline +
                ", memoryElementList=" + memoryElementList +
                ", questionList=" + questionList +
                '}';
    }
}
