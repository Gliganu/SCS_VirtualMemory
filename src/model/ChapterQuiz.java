package model;

import java.util.List;

/**
 * Created by GligaBogdan on 17-Apr-16.
 */
public class ChapterQuiz {

    private String question;
    private List<String> options;
    private String answer;
    private String answerMotivation;


    public ChapterQuiz(String question, List<String> options, String answer, String answerMotivation) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.answerMotivation = answerMotivation;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerMotivation() {
        return answerMotivation;
    }

    public void setAnswerMotivation(String answerMotivation) {
        this.answerMotivation = answerMotivation;
    }
}
