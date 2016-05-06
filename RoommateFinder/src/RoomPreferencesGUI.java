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
public class RoomPreferencesGUI {
    private JRadioButton lowPriceButton;
    private JRadioButton kitchenYesButton;
    private JRadioButton showerYesButton;
    private JRadioButton floorLowerButton;
    private JRadioButton bunkLowerButton;
    private JRadioButton roomLightButton;
    private JRadioButton wdYesButton;
    private JRadioButton bunkUpperButton;
    private JRadioButton highPriceButton;
    private JRadioButton roomDarkButton;
    private JRadioButton kitchenNoButton;
    private JRadioButton floorUpperButton;
    private JRadioButton wdNoButton;
    private JRadioButton showerNoButton;
    private JButton previousButton;
    private JButton nextButton;
    private JPanel RoomPreferencesPanel;
    private List<String> roomPreferencesList;
    private final Charset UTF8 = StandardCharsets.UTF_8;

    static void createFrame(){
        JFrame frame = new JFrame();
        frame.setContentPane(new RoomPreferencesGUI().RoomPreferencesPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public RoomPreferencesGUI(){
        roomPreferencesList = new ArrayList<>();

        nextButton.addActionListener(e -> {
            roomPreferencesList.add(pricePref());
            roomPreferencesList.add(kitchenPref());
            roomPreferencesList.add(showerPref());
            roomPreferencesList.add(washerDryerPref());
            roomPreferencesList.add(floorPref());
            roomPreferencesList.add(roomBrightnessPref());
            roomPreferencesList.add(bunkPref());

            try {
                Files.write(Paths.get("StudentInfo.txt"), roomPreferencesList, UTF8,
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException exc) {
                exc.printStackTrace();
            }

            ((JFrame) RoomPreferencesPanel.getTopLevelAncestor()).dispose();
            MainMenuGUI.createFrame();
        });

        previousButton.addActionListener(e -> {
            ((JFrame) RoomPreferencesPanel.getTopLevelAncestor()).dispose();
            PersonalInfoGUI.createFrame();
        });
    }

    private String pricePref() {
        if (lowPriceButton.isSelected())
            return "Low";
        else if (highPriceButton.isSelected())
            return "High";
        else
            return "No preference";
    }

    private String kitchenPref() {
        if (kitchenNoButton.isSelected())
            return "No";
        else if (kitchenYesButton.isSelected())
            return "Yes";
        else
            return "No preference";
    }

    private String showerPref() {
        if (showerNoButton.isSelected())
            return "No";
        else if (showerYesButton.isSelected())
            return "Yes";
        else
            return "No preference";
    }

    private String washerDryerPref() {
        if (wdNoButton.isSelected())
            return "No";
        else if (wdYesButton.isSelected())
            return "Yes";
        else
            return "No preference";
    }

    private String floorPref() {
        if (floorLowerButton.isSelected())
            return "Lower";
        else if (floorUpperButton.isSelected())
            return "Upper";
        else
            return "No preference";
    }

    private String roomBrightnessPref() {
        if (roomDarkButton.isSelected())
            return "Dark";
        else if (roomLightButton.isSelected())
            return "Light";
        else
            return "No preference";
    }

    private String bunkPref() {
        if (bunkLowerButton.isSelected())
            return "Lower";
        else if (bunkUpperButton.isSelected())
            return "Upper";
        else
            return "No preference";
    }

    public static void main(String[] args){
        RoomPreferencesGUI.createFrame();
    }

}
