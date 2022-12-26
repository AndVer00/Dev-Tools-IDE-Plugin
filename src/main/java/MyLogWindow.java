import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyLogWindow {
    private JTextArea myTextArea;
    private JPanel panel1;
    private JButton updateButton;

    public MyLogWindow() {
        updateButton.addActionListener(e -> getCurrentLogState());
    }

    public void getCurrentLogState() {
        myTextArea.setText("");
        StringBuilder test = new StringBuilder();
        try {
            Scanner s = new Scanner(new File("C:/temp/test/MyLogFile.log"));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                test.append(line).append('\n');
            }

            if (String.valueOf(test).equals("")){
                myTextArea.setText("Your current log file is empty");
            }
            else {
                myTextArea.setText(test.toString());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public JPanel getContent(){
        return panel1;
    }
}
