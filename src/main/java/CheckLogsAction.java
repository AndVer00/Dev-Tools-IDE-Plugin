import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckLogsAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        StringBuilder test = new StringBuilder();
        try {
            Scanner s = new Scanner(new File("C:/temp/test/MyLogFile.log"));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                test.append(line).append('\n');
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        String title = e.getPresentation().getDescription();
        String message = "Your current log file:";
        Messages.showMessageDialog(e.getProject(), String.valueOf(test), title, Messages.getQuestionIcon());
    }
}
