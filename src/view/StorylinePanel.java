package view;

import controller.Chapter;
import controller.Utils;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

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

        addStories(Utils.getRandomStories());

    }

    private void initUI() {

        listModel = new DefaultListModel<>();

        storyList = new JList<>(listModel);

        add(storyList);
    }

    public void addStories(List<String> stories){

        for(String story: stories){
            listModel.addElement(story);
        }
    }
}
