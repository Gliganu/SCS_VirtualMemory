package top;

import controller.Chapter;
import controller.ChapterFactory;
import controller.Utils;
import view.MainFrame;

import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class App {

    public static void main(String[] args) {


        List<Chapter> randomChapters = ChapterFactory.getAllChapters();

        MainFrame mainFrame = new MainFrame(randomChapters);

    }
}
