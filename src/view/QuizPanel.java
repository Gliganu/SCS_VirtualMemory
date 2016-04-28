package view;

import model.ChapterQuiz;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by GligaBogdan on 17-Apr-16.
 */
public class QuizPanel extends JPanel {


    private GridBagConstraints gc;

    private int counter = 0;
    private JPanel questionPanel;
    private Label titleLabel;
    private List<ChapterQuiz> chapterQuizList;

    public QuizPanel( List<ChapterQuiz> chapterQuizList) {
        resetUI(chapterQuizList);
    }

    public void resetUI(List<ChapterQuiz> chapterQuizList) {

        this.chapterQuizList = chapterQuizList;
        counter = 0;

        questionPanel = new JPanel();

        setLayout(new BorderLayout());
        questionPanel.setLayout(new GridBagLayout());

        gc = new GridBagConstraints();
        gc.gridy = 0;

        for(ChapterQuiz quiz: chapterQuizList){
            addChapterQuiz(quiz);
        }

        add(getTitlePanel(),BorderLayout.NORTH);
        add(new JScrollPane(questionPanel),BorderLayout.CENTER);

        repaint();
    }

    private JPanel getTitlePanel() {

        JPanel titlePanel = new JPanel();

        titleLabel = new Label("Correct answers: " + counter +" \\ "+ chapterQuizList.size());

        titlePanel.add(titleLabel);

        return titlePanel;
    }

    private void addChapterQuiz(ChapterQuiz chapterQuiz) {

        String question = chapterQuiz.getQuestion();
        String answer = chapterQuiz.getAnswer();
        String answerMotivation = chapterQuiz.getAnswerMotivation();
        List<String> options = chapterQuiz.getOptions();


        //First Row//////////////////////////////////////////

        for(int i=0;i<2;i++){
            gc.gridy++;

            gc.weightx = 1;
            gc.weighty = 0.1;

            gc.gridx = 0;
            gc.fill = GridBagConstraints.NONE;
            gc.anchor = GridBagConstraints.LINE_END;
            gc.insets = new Insets(0, 0, 0, 5);
            questionPanel.add(new JLabel(" "), gc);
        }


        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        JLabel questionTagLabel = new JLabel("Question: ");
        questionPanel.add(questionTagLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        JLabel questionLabel = new JLabel(question);
        questionPanel.add(questionLabel, gc);


        ///////////////Next Row///////////////////////////

        ButtonGroup answerGroup = new ButtonGroup();

        for(String option: options){
            JRadioButton optionButton = new JRadioButton(option);
            optionButton.setActionCommand(option);

            answerGroup.add(optionButton);
            gc.gridy++;

            gc.weightx = 1;
            gc.weighty = 0.05;

            gc.gridx = 0;
            gc.anchor = GridBagConstraints.LINE_END;
            gc.insets = new Insets(0, 0, 0, 5);
            questionPanel. add(new JLabel("Option: "), gc);

            gc.gridx = 1;
            gc.anchor = GridBagConstraints.FIRST_LINE_START;
            gc.insets = new Insets(0, 0, 0, 0);
            questionPanel. add(optionButton, gc);

        }


        ///////////////Next Row///////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        JButton submitButton = new JButton("Submit");

        JLabel answerMotivationLabel = new JLabel(chapterQuiz.getAnswerMotivation());
        JLabel answerMotivationTag = new JLabel("Answer motivation: ");

        submitButton.addActionListener(e -> {

            if(chapterQuiz.getAnswer().equals(answerGroup.getSelection().getActionCommand())){
                submitButton.setEnabled(false);
                counter++;

                if(counter == chapterQuizList.size()){
                    titleLabel.setText("All correct");
                }else{
                    titleLabel.setText("Correct answers: " + counter +" \\ "+ chapterQuizList.size());
                }

                answerMotivationLabel.setVisible(true);
                answerMotivationTag.setVisible(true);

                Enumeration<AbstractButton> elementsEnum = answerGroup.getElements();
                while(elementsEnum.hasMoreElements()){
                    AbstractButton abstractButton = elementsEnum.nextElement();
                    abstractButton.setEnabled(false);
                }

            }


        });

        questionPanel.add(submitButton, gc);


        //First Row//////////////////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        questionPanel.add(answerMotivationTag, gc);
        answerMotivationTag.setVisible(false);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        questionPanel.add(answerMotivationLabel, gc);
        answerMotivationLabel.setVisible(false);


    }


}
