import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ZombieOutbreak {

    // =========================
    // WINDOW SETTINGS
    // =========================
    int boardWidth = 750;
    int boardHeight = 600;

    // =========================
    // COLORS
    // =========================
    Color darkGreen = new Color(25, 55, 35);
    Color green = new Color(70, 130, 85);
    Color lightGreen = new Color(180, 220, 185);

    Color darkRed = new Color(100, 25, 25);
    Color red = new Color(180, 55, 55);
    Color lightRed = new Color(245, 190, 190);

    Color darkGray = new Color(35, 35, 35);
    Color lightGray = new Color(235, 235, 235);

    Color white = Color.WHITE;

    // =========================
    // GAME VARIABLES
    // =========================
    String playerName;
    int playerAge;
    int playerRole;
    int playerHP = 20;

    // =========================
    // ROLE NAMES
    // =========================
    String[] roles = {
        "Warrior",
        "Artillery",
        "Medic",
        "Engineer",
        "Scientist"
    };

    // =========================
    // MAIN WINDOW
    // =========================
    JFrame frame = new JFrame("!!! Zombie Outbreak !!!");

    JPanel mainPanel = new JPanel();
    JLabel titleLabel = new JLabel();
    JLabel storyLabel = new JLabel();
    JPanel buttonPanel = new JPanel();

    // =========================
    // CONSTRUCTOR
    // =========================
    ZombieOutbreak() {

        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMainPanel();

        frame.setVisible(true);

        showTitleScreen();
    }

    // =========================================================
    // CREATE MAIN PANEL
    // =========================================================

    void createMainPanel() {

        mainPanel.setBackground(darkGray);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        frame.add(mainPanel);
    }

    // =========================================================
    // TITLE SCREEN
    // =========================================================

    void showTitleScreen() {

        mainPanel.removeAll();

        // TITLE
        titleLabel = new JLabel("!!! ZOMBIE OUTBREAK !!!");
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 38));
        titleLabel.setForeground(white);
        titleLabel.setBackground(darkRed);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // STORY
        storyLabel = new JLabel(
            "<html><div style='text-align:center;'>" +
            "The world has fallen into chaos.<br><br>" +
            "A deadly zombie virus is spreading rapidly.<br>" +
            "Your mission is to survive and find a cure.<br><br>" +
            "Will you save humanity,<br>" +
            "or will you become one of the infected?" +
            "</div></html>"
        );

        storyLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        storyLabel.setForeground(white);
        storyLabel.setHorizontalAlignment(JLabel.CENTER);
        storyLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 50, 0));
        mainPanel.add(storyLabel, BorderLayout.CENTER);

        // BUTTONS
        buttonPanel = new JPanel();
        buttonPanel.setBackground(darkGray);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JButton startButton = createButton(
            "START GAME",
            green,
            white
        );

        JButton exitButton = createButton(
            "EXIT",
            darkRed,
            white
        );
    // START GAME SIZE
    startButton.setPreferredSize(new Dimension(450, 55));
    startButton.setMaximumSize(new Dimension(450, 55));
    startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    // EXIT SIZE
    exitButton.setPreferredSize(new Dimension(450, 55));
    exitButton.setMaximumSize(new Dimension(450, 55));
    exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    // ADD BUTTONS
    buttonPanel.add(startButton);
    buttonPanel.add(Box.createVerticalStrut(15));
    buttonPanel.add(exitButton);

    mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        // START
        startButton.addActionListener(e -> showIdentificationScreen());

        // EXIT
        exitButton.addActionListener(e -> System.exit(0));

        refreshScreen();
    }

    // =========================================================
    // IDENTIFICATION SCREEN
    // =========================================================

    void showIdentificationScreen() {

        mainPanel.removeAll();

        titleLabel = new JLabel("PLAYER IDENTIFICATION");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(white);
        titleLabel.setBackground(darkGreen);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 45, 20, 45));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(darkGray);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 45, 20, 45));

        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(white);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));

        JLabel ageLabel = new JLabel("Enter your age:");
        ageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        ageLabel.setForeground(white);

        JTextField ageField = new JTextField();
        ageField.setFont(new Font("Arial", Font.PLAIN, 20));
        ageField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));

        formPanel.add(nameLabel);
        formPanel.add(Box.createVerticalStrut(5));
        formPanel.add(nameField);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(ageLabel);
        formPanel.add(Box.createVerticalStrut(5));
        formPanel.add(ageField);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(darkGray);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        

        JButton continueButton = createButton(
            "CONTINUE",
            green,
            white
        );

        JButton backButton = createButton(
            "BACK",
            darkRed,
            white
        );

        bottomPanel.add(backButton);
        bottomPanel.add(continueButton);


        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // BACK
        backButton.addActionListener(e -> showTitleScreen());

        // CONTINUE
        continueButton.addActionListener(e -> {

            playerName = nameField.getText().trim();

            if (playerName == null || playerName.isEmpty()) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Please enter your name.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            try {

                playerAge = Integer.parseInt(ageField.getText());

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Please enter a valid age.",
                    "Invalid Age",
                    JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // NOT OPERATOR
            if (!(playerAge >= 18)) {

                showGameOver(
                    "Sorry, " + playerName +
                    ". You are not eligible to participate in the simulation."
                );

            } else {

                JOptionPane.showMessageDialog(
                    frame,
                    "Welcome, " + playerName +
                    "! You are eligible to participate.",
                    "Welcome",
                    JOptionPane.INFORMATION_MESSAGE
                );

                showRoleScreen();
            }
        });

        refreshScreen();
    }

    // =========================================================
    // ROLE SCREEN
    // =========================================================

    void showRoleScreen() {

        mainPanel.removeAll();

        titleLabel = new JLabel("CHOOSE YOUR ROLE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(white);
        titleLabel.setBackground(darkRed);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 45, 20, 45));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel rolePanel = new JPanel();
        rolePanel.setBackground(darkGray);
        rolePanel.setLayout(new BoxLayout(rolePanel, BoxLayout.Y_AXIS));
        rolePanel.setBorder(BorderFactory.createEmptyBorder(25, 45, 25, 45));

        for (int i = 0; i < roles.length; i++) {

            int roleNumber = i + 1;

            JButton roleButton = createButton(
                roleNumber + ". " + roles[i],
                green,
                white
            );

            roleButton.setPreferredSize(new Dimension(380, 65));
            roleButton.setMaximumSize(new Dimension(380, 65));
            roleButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            rolePanel.add(roleButton);

            if (i < roles.length - 1) {
                rolePanel.add(Box.createVerticalStrut(30));
            }

            roleButton.addActionListener(e -> {

                playerRole = roleNumber;

                JOptionPane.showMessageDialog(
                    frame,
                    "You have chosen the " +
                    roles[playerRole - 1] +
                    " class.",
                    "Role Selected",
                    JOptionPane.INFORMATION_MESSAGE
                );

                showFirstAttackScreen();
            });
        }

        mainPanel.add(rolePanel, BorderLayout.CENTER);

        refreshScreen();
    }

    // =========================================================
    // FIRST ATTACK SCREEN
    // =========================================================

    void showFirstAttackScreen() {

        mainPanel.removeAll();

        titleLabel = new JLabel("!!!ZOMBIE ATTACK!!!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(white);
        titleLabel.setBackground(darkRed);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(25, 15, 20, 15));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        storyLabel = new JLabel(
            "<html><div style='text-align:center;'>" +
            "A zombie appeared out of nowhere<br>" +
            "and attacked your party!<br><br>" +

            "<b><font color='red'>You have been bitten.</font></b><br><br>" +

            "Your HP has dropped to:<br>" +
            "<font size='6'>20 HP</font>" +
            "</div></html>"
        );

        storyLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        storyLabel.setForeground(white);
        storyLabel.setHorizontalAlignment(JLabel.CENTER);

        mainPanel.add(storyLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(darkGray);
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 15));

        JButton potionButton = createButton(
            "USE HEALTH POTION",
            green,
            white
        );

        JButton continueButton = createButton(
            "DO NOT USE POTION",
            darkRed,
            white
        );

        buttonPanel.add(potionButton);
        buttonPanel.add(continueButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // USE POTION
        potionButton.addActionListener(e -> showPotionScreen());

        // NO POTION
        continueButton.addActionListener(e -> {

            playerHP = 20;

            showCurrentHP();

        });

        refreshScreen();
    }

    // =========================================================
    // POTION SCREEN
    // =========================================================

    void showPotionScreen() {

        mainPanel.removeAll();

        titleLabel = new JLabel("CHOOSE YOUR POTION");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(white);
        titleLabel.setBackground(darkGreen);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel infoLabel = new JLabel(
            "<html><div style='text-align:center;'>" +
            "Choose a health potion to restore your HP." +
            "</div></html>"
        );

        infoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoLabel.setForeground(white);
        infoLabel.setHorizontalAlignment(JLabel.CENTER);

        mainPanel.add(infoLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(darkGray);
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton potionA = createButton(
            "A-CLASS POTION  (+100 HP)",
            green,
            white
        );

        JButton potionB = createButton(
            "B-CLASS POTION  (+50 HP)",
            lightGreen,
            darkGreen
        );

        JButton noPotion = createButton(
            "CANCEL",
            darkRed,
            white
        );

        buttonPanel.add(potionA);
        buttonPanel.add(potionB);
        buttonPanel.add(noPotion);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // A CLASS
        potionA.addActionListener(e -> {

            playerHP = 20 + 100;

            JOptionPane.showMessageDialog(
                frame,
                "You have used an A-Class health potion.\n" +
                "+100 HP!",
                "Health Potion",
                JOptionPane.INFORMATION_MESSAGE
            );

            showCurrentHP();
        });

        // B CLASS
        potionB.addActionListener(e -> {

            playerHP = 20 + 50;

            JOptionPane.showMessageDialog(
                frame,
                "You have used a B-Class health potion.\n" +
                "+50 HP!",
                "Health Potion",
                JOptionPane.INFORMATION_MESSAGE
            );

            showCurrentHP();
        });

        // CANCEL
        noPotion.addActionListener(e -> {

            playerHP = 20;

            showCurrentHP();

        });

        refreshScreen();
    }

    // =========================================================
    // CURRENT HP SCREEN
    // =========================================================

    void showCurrentHP() {

        mainPanel.removeAll();

        titleLabel = new JLabel("CURRENT STATUS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(white);
        titleLabel.setBackground(darkGreen);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel hpLabel = new JLabel(
            "<html><div style='text-align:center;'>" +

            "Player:<br>" +
            "<font size='7'>" + playerName + "</font><br><br>" +

            "Role:<br>" +
            "<font size='5'>" +
            roles[playerRole - 1] +
            "</font><br><br>" +

            "HP:<br>" +
            "<font size='5'>" +
            playerHP +
            " HP" +
            "</font>" +

            "</div></html>"
        );

        hpLabel.setFont(new Font("Arial", Font.BOLD, 18));
        hpLabel.setForeground(white);
        hpLabel.setHorizontalAlignment(JLabel.CENTER);

        mainPanel.add(hpLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(darkGray);

        JButton continueButton = createButton(
            "CONTINUE TO FINAL STAGE",
            green,
            white
        );

        JButton exitButton = createButton(
            "EXIT GAME",
            darkRed,
            white
        );

        buttonPanel.add(continueButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        continueButton.addActionListener(e -> showBossFightScreen());

        exitButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                frame,
                "You have chosen to exit the simulation.\nGame Over.",
                "Game Over",
                JOptionPane.INFORMATION_MESSAGE
            );

            System.exit(0);
        });

        refreshScreen();
    }

    // =========================================================
    // BOSS FIGHT
    // =========================================================

    void showBossFightScreen() {

        mainPanel.removeAll();

        titleLabel = new JLabel("!!! ZOMBIE KING !!!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(white);
        titleLabel.setBackground(darkRed);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel story = new JLabel(
            "<html><div style='text-align:center;'>" +

            "You have reached the base of the<br>" +
            "<b>Zombie King</b>, the final boss.<br><br>" +

            "Your attacks seem to have<br>" +
            "no effect on the Zombie King.<br><br>" +

            "Your party is in a predicament.<br><br>" +

            "!?! A legendary sword has appeared !?!<br><br>" +

            "The sword can defeat the Zombie King,<br>" +
            "but certain conditions must be met." +

            "</div></html>"
        );

        story.setFont(new Font("Arial", Font.PLAIN, 18));
        story.setForeground(white);
        story.setHorizontalAlignment(JLabel.CENTER);

        mainPanel.add(story, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(darkGray);
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 15));

        JButton swordButton = createButton(
            "ATTEMPT TO USE SWORD?",
            green,
            white
        );

        JButton giveUpButton = createButton(
            "GIVE UP",
            darkRed,
            white
        );

        buttonPanel.add(swordButton);
        buttonPanel.add(giveUpButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // SWORD
        swordButton.addActionListener(e -> checkSwordConditions());

        // GIVE UP
        giveUpButton.addActionListener(e -> {

            showGameOver(
                "You have chosen not to attempt to wield " +
                "the legendary sword.\n\n" +
                "The Zombie King has defeated you and your party.\n\n" +
                "Once again, humanity has lost its hope."
            );
        });

        refreshScreen();
    }

    // =========================================================
    // CHECK SWORD CONDITIONS
    // =========================================================

    void checkSwordConditions() {

        String conditions =
            "To use the legendary sword:\n\n" +
            "✓ You must be a Warrior (Role 1)\n" +
            "✓ Your HP must be at least 80\n\n" +

            "Your role: " +
            roles[playerRole - 1] +

            "\nYour HP: " +
            playerHP;

        JOptionPane.showMessageDialog(
            frame,
            conditions,
            "Legendary Sword Conditions",
            JOptionPane.INFORMATION_MESSAGE
        );

        // AND OPERATOR
        if (playerRole == 1 && playerHP >= 80) {

            showVictoryScreen();

        } else if (playerRole != 1 || playerHP < 80) {

            showGameOver(
                "You have not met the conditions " +
                "to wield the legendary sword.\n\n" +

                "The Zombie King has defeated you and your party.\n\n" +

                "Once again, humanity has lost its hope."
            );
        }
    }

    // =========================================================
    // VICTORY SCREEN
    // =========================================================

    void showVictoryScreen() {

        mainPanel.removeAll();

        titleLabel = new JLabel("! HUMANITY IS SAVED !");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(white);
        titleLabel.setBackground(darkGreen);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel victoryLabel = new JLabel(
            "<html><div style='text-align:center;'>" +

            "** ONE STRIKE! **<br><br>" +

            "You have taken down the<br>" +
            "<b>Zombie King!</b><br><br>" +

            "The zombie outbreak has ended.<br>" +
            "Humanity has been saved!<br><br>" +

            "Congratulations, " +
            playerName +
            "!<br><br>" +

            "You have completed the<br>" +
            "Zombie Outbreak Simulation." +

            "</div></html>"
        );

        victoryLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        victoryLabel.setForeground(white);
        victoryLabel.setHorizontalAlignment(JLabel.CENTER);

        mainPanel.add(victoryLabel, BorderLayout.CENTER);

        JButton playAgainButton = createButton(
            "PLAY AGAIN",
            green,
            white
        );

        JButton exitButton = createButton(
            "EXIT",
            darkRed,
            white
        );

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(darkGray);

        buttonPanel.add(playAgainButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        playAgainButton.addActionListener(e -> resetGame());

        exitButton.addActionListener(e -> System.exit(0));

        refreshScreen();
    }

    // =========================================================
    // GAME OVER
    // =========================================================

    void showGameOver(String message) {

        mainPanel.removeAll();

        titleLabel = new JLabel("-- GAME OVER --");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(lightRed);
        titleLabel.setBackground(darkGreen);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel messageLabel = new JLabel(
            "<html><div style='text-align:center;'>" +
            message.replace("\n", "<br>") +
            "</div></html>"
        );

        messageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        messageLabel.setForeground(white);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);

        mainPanel.add(messageLabel, BorderLayout.CENTER);

        JButton restartButton = createButton(
            "TRY AGAIN",
            green,
            white
        );

        JButton exitButton = createButton(
            "EXIT",
            darkRed,
            white
        );

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(darkGray);

        buttonPanel.add(restartButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        restartButton.addActionListener(e -> resetGame());

        exitButton.addActionListener(e -> System.exit(0));

        refreshScreen();
    }

    // =========================================================
    // RESET GAME
    // =========================================================

    void resetGame() {

        playerName = null;
        playerAge = 0;
        playerRole = 0;
        playerHP = 20;

        showTitleScreen();
    }

    // =========================================================
    // CREATE BUTTON
    // =========================================================

    JButton createButton(
        String text,
        Color background,
        Color foreground
    ) {

        JButton button = new JButton(text) {

            @Override
            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
                );

                g2.setColor(getBackground());
                g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    25,
                    25
                );

                g2.dispose();

                super.paintComponent(g);
            }
        };

        button.setFont(
            new Font("Arial", Font.BOLD, 18)
        );

        button.setBackground(background);
        button.setForeground(foreground);

        button.setFocusable(false);

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        button.setCursor(
            new Cursor(Cursor.HAND_CURSOR)
        );

        return button;
    }

    // =========================================================
    // REFRESH SCREEN
    // =========================================================

    void refreshScreen() {

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ZombieOutbreak();
        });
    }
}