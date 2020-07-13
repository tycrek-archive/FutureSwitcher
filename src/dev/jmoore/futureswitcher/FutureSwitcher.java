package dev.jmoore.futureswitcher;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FutureSwitcher extends JFrame {

    private static final double VERSION = 0.1;

    private final JPanel panel;

    FutureSwitcher() {
        super("Future Switcher v" + (VERSION));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));
        setAutoRequestFocus(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(500,300);
        setVisible(false);
        setEnabled(true);

        JPanel panel1 = new JPanel(new GridLayout(4,1));
        JLabel createdByLabel = new JLabel("Created by tycrek");
        JLabel githubLabel = new JLabel("GitHub: https://github.com/tycrek");
        JLabel websiteLabel = new JLabel("Website: https://jmoore.dev");
        panel1.add(createdByLabel);
        panel1.add(githubLabel);
        panel1.add(websiteLabel);

        Button importBtn = new Button("Import profiles");
        importBtn.addActionListener(e -> importProfiles());
        panel1.add(importBtn);
        add(panel1);

        panel = new JPanel(new WrapLayout());
        add(panel);
        setVisible(true);
    }

    private void importProfiles() {
        for (Component c : panel.getComponents()) {
            panel.remove(c);
        }

        File userProfile = new File(System.getProperty("user.home"));
        String[] contents = userProfile.list();
        ArrayList<File> futureFiles = new ArrayList<>();
        for (String name : contents) {
            if (name.contains("Future") && new File(System.getProperty("user.home") + "/" + name).isDirectory())
                futureFiles.add(new File(System.getProperty("user.home") + "/" + name));
        }

        for (File futureFile : futureFiles) {
            Button tmpButton = new Button(futureFile.getName());
            tmpButton.addActionListener(e -> {
                File destinationDir = new File(System.getProperty("user.home") + "/Future");
                try {
                    FileUtils.deleteDirectory(destinationDir);
                    FileUtils.copyDirectory(futureFile, destinationDir);
                    JOptionPane.showMessageDialog(null, "Success, please run .reload in game to load the profile");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed, please try again");
                }
            });
            panel.add(tmpButton);
            revalidate();
        }
    }

    public static void main(String[] args) {
        new FutureSwitcher();
    }
}
