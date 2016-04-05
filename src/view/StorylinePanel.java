package view;

import javax.swing.*;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class StorylinePanel extends JPanel {


    private MainFrame parent;
    private JList<String> storyList;
    private DefaultListModel<String> listModel;

    public StorylinePanel(MainFrame parent) {

        this.parent = parent;
        initUI();

    }

    private void initUI() {

        listModel = new DefaultListModel<>();

        storyList = new JList<>(listModel);

        add(storyList);
    }

    public void addStory(String story) {
        listModel.addElement(story);
    }

    public void clearStories() {
        listModel.clear();
    }
}
