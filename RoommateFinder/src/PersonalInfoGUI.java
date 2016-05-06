import javax.swing.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by William Vagharfard on 4/29/16.
 */
public class PersonalInfoGUI {

    private JTextField majorText;
    private JComboBox yearBox;
    private JPanel PersonalInfoPanel;
    private JRadioButton earlySleepButton;
    private JRadioButton lateSleepButton;
    private JRadioButton earlyWakeButton;
    private JRadioButton lateWakeButton;
    private JRadioButton quietButton;
    private JRadioButton livelyButton;
    private JButton previousButton;
    private JButton nextButton;
    private JTextField ageText;
    private List<String> personalInfoList;
    private final Charset UTF8 = StandardCharsets.UTF_8;


    static void createFrame() {
        JFrame frame = new JFrame();
        frame.setContentPane(new PersonalInfoGUI().PersonalInfoPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public PersonalInfoGUI() {
        personalInfoList = new ArrayList<>();

        nextButton.addActionListener(e -> {
            personalInfoList.add(getAge());
            personalInfoList.add(getMajor());
            personalInfoList.add(getYear());
            personalInfoList.add(getSleepPrefs());
            personalInfoList.add(getWakePrefs());
            personalInfoList.add(getRoommatePref());

            try {
                Files.write(Paths.get("StudentInfo.txt"), personalInfoList, UTF8,
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException exc) {
                exc.printStackTrace();
            }

            ((JFrame) PersonalInfoPanel.getTopLevelAncestor()).dispose();
            RoomPreferencesGUI.createFrame();
        });

        previousButton.addActionListener(e -> {
            //TODO: Add actionListener to Go to Ray's screen
             ((JFrame) PersonalInfoPanel.getTopLevelAncestor()).dispose();
             StudentInfoGUI.createFrame();
        });
    }


    private String getMajor(){
        if (majorText.getText().length() == 0)
            return "Undeclared";
        else
            return majorText.getText();
    }

    private String getYear() {
        return (String) yearBox.getSelectedItem();
    }

    private String getSleepPrefs() {
        if (earlySleepButton.isSelected())
            return "Early";
        else if (lateSleepButton.isSelected())
            return "Late";
        else
            return "No preference";
    }

    private String getWakePrefs() {
        if (earlyWakeButton.isSelected())
            return "Early";
        else if (lateWakeButton.isSelected())
            return "Late";
        else
            return "No preference";
    }

    private String getRoommatePref() {
        if (quietButton.isSelected())
            return "Quiet";
        else if (livelyButton.isSelected())
            return "Lively";
        else
            return "No preference";
    }

    private String getAge() {
        return ageText.getText();
    }


    public static void main(String[] args){
        PersonalInfoGUI.createFrame();
    }
}
