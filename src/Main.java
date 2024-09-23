import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Информация о самолетах");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridBagLayout());

        // Загрузка и изменение размера логотипа
        ImageIcon logoIcon = new ImageIcon("img/sut-logo.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));

        String[] samolyotModels = {"Boeing 747", "Airbus A320", "Cessna 172"};
        String[] bombardirovshikModels = {"Tupolev Tu-160", "B-2 Spirit", "B-52 Stratofortress"};
        String[] istrebitelModels = {"Sukhoi Su-57", "F-22 Raptor", "Eurofighter Typhoon"};

        JComboBox<String> samolyotComboBox = new JComboBox<>(samolyotModels);
        JComboBox<String> bombardirovshikComboBox = new JComboBox<>(bombardirovshikModels);
        JComboBox<String> istrebitelComboBox = new JComboBox<>(istrebitelModels);

        JButton buttonSamolyot = createStyledButton("Показать информацию");
        JButton buttonBombardirovshik = createStyledButton("Показать информацию");
        JButton buttonIstrebitel = createStyledButton("Показать информацию");

        buttonSamolyot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedModel = (String) samolyotComboBox.getSelectedItem();
                Samolyot samolyot = createSamolyot(selectedModel);
                showInfoDialog(frame, samolyot.informatsiya());
            }
        });

        buttonBombardirovshik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedModel = (String) bombardirovshikComboBox.getSelectedItem();
                Bombardirovshik bombardirovshik = createBombardirovshik(selectedModel);
                showInfoDialog(frame, bombardirovshik.informatsiya());
            }
        });

        buttonIstrebitel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedModel = (String) istrebitelComboBox.getSelectedItem();
                Istrebitel istrebitel = createIstrebitel(selectedModel);
                showInfoDialog(frame, istrebitel.informatsiya());
            }
        });

        buttonPanel.add(samolyotComboBox);
        buttonPanel.add(buttonSamolyot);
        buttonPanel.add(bombardirovshikComboBox);
        buttonPanel.add(buttonBombardirovshik);
        buttonPanel.add(istrebitelComboBox);
        buttonPanel.add(buttonIstrebitel);

        // Создание и настройка JLabel для имени, фамилии и группы
        JLabel nameLabel = new JLabel("Хоризонов Серафим, ИКПИ-21");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        nameLabel.setForeground(new Color(128, 128, 128, 128)); // Полупрозрачный серый цвет

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        frame.add(logoLabel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(buttonPanel, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        frame.add(nameLabel, gbc);

        frame.setVisible(true);
    }

    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(255, 128, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(10, 20, 10, 20));
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1, true));
        return button;
    }

    private static Samolyot createSamolyot(String model) {
        switch (model) {
            case "Boeing 747":
                return new Samolyot("Boeing", "747", 900, 10000);
            case "Airbus A320":
                return new Samolyot("Airbus", "A320", 830, 12000);
            case "Cessna 172":
                return new Samolyot("Cessna", "172", 302, 4000);
            default:
                return null;
        }
    }

    private static Bombardirovshik createBombardirovshik(String model) {
        switch (model) {
            case "Tupolev Tu-160":
                return new Bombardirovshik("Tupolev", "Tu-160", 2000, 15000);
            case "B-2 Spirit":
                return new Bombardirovshik("Northrop Grumman", "B-2 Spirit", 1010, 15240);
            case "B-52 Stratofortress":
                return new Bombardirovshik("Boeing", "B-52 Stratofortress", 1000, 15000);
            default:
                return null;
        }
    }

    private static Istrebitel createIstrebitel(String model) {
        switch (model) {
            case "Sukhoi Su-57":
                return new Istrebitel("Sukhoi", "Su-57", 2500, 20000);
            case "F-22 Raptor":
                return new Istrebitel("Lockheed Martin", "F-22 Raptor", 2410, 19812);
            case "Eurofighter Typhoon":
                return new Istrebitel("Eurofighter", "Typhoon", 2495, 19812);
            default:
                return null;
        }
    }

    private static void showInfoDialog(JFrame parent, String info) {
        JDialog dialog = new JDialog(parent, "Информация", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(info);
        textArea.setEditable(false);
        dialog.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton closeButton = createStyledButton("Закрыть");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }
}