import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class PvZ {

    // Configures the colors and fonts globally for all JOptionPane dialogs
    public static void applyZombieTheme() {
        Color darkDecay = new Color(20, 24, 20);       // Dark murky charcoal/green background
        Color toxicGreen = new Color(80, 240, 90);     // Glowing slime green text
        Color inputFieldBg = new Color(30, 40, 30);    // Dark input field background
        Color buttonBg = new Color(40, 60, 40);        // Muted dark military green button
        Font zombieFont = new Font("Consolas", Font.BOLD, 13); // Survival terminal font

        // Apply background and text colors to the dialog box and panels
        UIManager.put("OptionPane.background", darkDecay);
        UIManager.put("Panel.background", darkDecay);
        UIManager.put("OptionPane.messageForeground", toxicGreen);
        UIManager.put("OptionPane.messageFont", zombieFont);

        // Apply theme to the buttons (OK / Cancel / Yes / No)
        UIManager.put("Button.background", buttonBg);
        UIManager.put("Button.foreground", toxicGreen);
        UIManager.put("Button.font", zombieFont);
        UIManager.put("Button.focus", new Color(0, 0, 0, 0)); // Removes blue focus border

        // Apply theme to input text fields
        UIManager.put("TextField.background", inputFieldBg);
        UIManager.put("TextField.foreground", toxicGreen);
        UIManager.put("TextField.caretColor", toxicGreen); // Blinking cursor color
        UIManager.put("TextField.font", zombieFont);
    }

    public static void title() {
        String message = "==================================\n"
                       + "         ZOMBIE OUTBREAK          \n"
                       + "==================================\n\n"
                       + "Welcome to the Zombie Outbreak Simulation!\n"
                       + "The world has fallen into chaos as a zombie virus spreads rapidly.\n"
                       + "Your mission is to survive and find a cure for the virus.\n"
                       + "Will you be able to save humanity, or will you fall into the hands of the zombies?";

        JOptionPane.showMessageDialog(null, message, "Zombie Outbreak", JOptionPane.PLAIN_MESSAGE);
    }

    public static boolean identification() {
        String name = JOptionPane.showInputDialog(null, "Enter your name:", "Identification", JOptionPane.PLAIN_MESSAGE);
        if (name == null) System.exit(0);

        String ageInput = JOptionPane.showInputDialog(null, "Enter your age:", "Identification", JOptionPane.PLAIN_MESSAGE);
        if (ageInput == null) System.exit(0);
        
        int age = Integer.parseInt(ageInput.trim());

        // NOT
        if (!(age >= 18)) {
            JOptionPane.showMessageDialog(null, "Sorry, " + name + ". You are not eligible to participate in the simulation.", "Access Denied", JOptionPane.PLAIN_MESSAGE);
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Welcome, " + name + "! You are eligible to participate in the simulation.", "Access Granted", JOptionPane.PLAIN_MESSAGE);
            return true;
        }
    }

    public static int role() {
        String roleMenu = "Choose a role:\n"
                        + "1. Warrior\n"
                        + "2. Artillery\n"
                        + "3. Medic\n"
                        + "4. Engineer\n"
                        + "5. Scientist\n\n"
                        + "Enter your choice (1-5):";

        String choiceInput = JOptionPane.showInputDialog(null, roleMenu, "Choose Role", JOptionPane.PLAIN_MESSAGE);
        if (choiceInput == null) System.exit(0);

        int role = Integer.parseInt(choiceInput.trim());

        switch (role) {
            case 1:
                JOptionPane.showMessageDialog(null, "You have chosen the Warrior class.", "Class Selected", JOptionPane.PLAIN_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "You have chosen the Artillery class.", "Class Selected", JOptionPane.PLAIN_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "You have chosen the Medic class.", "Class Selected", JOptionPane.PLAIN_MESSAGE);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "You have chosen the Engineer class.", "Class Selected", JOptionPane.PLAIN_MESSAGE);
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "You have chosen the Scientist class.", "Class Selected", JOptionPane.PLAIN_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice.", "Error", JOptionPane.PLAIN_MESSAGE);
        }

        return role;
    }

    public static int firstAttack() {
        JOptionPane.showMessageDialog(null, 
            "A zombie appeared out of nowhere and attacked your party!\nYou have been bitten. HP down to 20.", 
            "Ambush!", 
            JOptionPane.PLAIN_MESSAGE
        );

        int hp = 20;

        String potion = JOptionPane.showInputDialog(null, "Would you like to use a health potion? (yes/no):", "Health Potion", JOptionPane.PLAIN_MESSAGE);
        if (potion == null) potion = "no";

        // OR
        if (potion.equalsIgnoreCase("yes")) {
            String potionClass = JOptionPane.showInputDialog(null, "Would you like to use A-Class (100 HP) or B-Class (50 HP) health potion? (A/B):", "Potion Selection", JOptionPane.PLAIN_MESSAGE);
            if (potionClass == null) potionClass = "";

            if (potionClass.equalsIgnoreCase("A")) {
                hp += 100;
                JOptionPane.showMessageDialog(null, "You have used an A-Class health potion, +100 HP.", "Healed", JOptionPane.PLAIN_MESSAGE);
            } 
            else if (potionClass.equalsIgnoreCase("B")) {
                hp += 50;
                JOptionPane.showMessageDialog(null, "You have used a B-Class health potion, +50 HP.", "Healed", JOptionPane.PLAIN_MESSAGE);
            } 
            else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please enter A or B.", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } 
        else if (potion.equalsIgnoreCase("no")) {
            JOptionPane.showMessageDialog(null, "You have chosen not to use a health potion. Your HP remains at 20.", "Status", JOptionPane.PLAIN_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, "Current HP: " + hp, "Status", JOptionPane.PLAIN_MESSAGE);

        String continueGame = JOptionPane.showInputDialog(null, "Would you like to continue to the next stage? (yes/no):", "Next Stage", JOptionPane.PLAIN_MESSAGE);
        if (continueGame == null || continueGame.equalsIgnoreCase("no")) {
            JOptionPane.showMessageDialog(null, "You have chosen to exit the simulation. Game Over.", "Game Over", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }

        return hp;
    }

    public static void bossFight(int role, int hp) {
        String bossIntro = "You have reached the base of the Zombie King, the final boss.\n"
                         + "Preparing for the final battle...\n"
                         + "Your attacks seem to have no effect on the Zombie King.\n"
                         + "Your party is in a predicament.";
        JOptionPane.showMessageDialog(null, bossIntro, "Final Boss", JOptionPane.PLAIN_MESSAGE);

        String swordIntro = "A legendary sword has appeared in front of you, capable of defeating the Zombie King.\n"
                          + "However, certain conditions must be met in order to wield the sword.";
        JOptionPane.showMessageDialog(null, swordIntro, "Legendary Sword", JOptionPane.PLAIN_MESSAGE);

        String attemptSword = JOptionPane.showInputDialog(null, "Would you like to attempt to wield the legendary sword? (yes/no):", "Legendary Sword", JOptionPane.PLAIN_MESSAGE);
        if (attemptSword == null) attemptSword = "no";

        if (attemptSword.equalsIgnoreCase("yes")) {
            String conditions = "To use the legendary sword, you must meet the following conditions:\n"
                              + "1. You must be a Warrior (role 1).\n"
                              + "2. Your HP must be at least 80.";
            JOptionPane.showMessageDialog(null, conditions, "Sword Conditions", JOptionPane.PLAIN_MESSAGE);

            // AND
            if (role == 1 && hp >= 80) {
                String victoryMessage = "You have met the conditions to wield the legendary sword.\n"
                                      + "With one strike, you have taken down the Zombie King!\n"
                                      + "The zombie outbreak has ended and humanity has been saved.\n"
                                      + "Congratulations, player! You have completed the Zombie Outbreak Simulation.";
                JOptionPane.showMessageDialog(null, victoryMessage, "Victory!", JOptionPane.PLAIN_MESSAGE);
            } else {
                String defeatMessage = "You have not met the conditions to wield the legendary sword.\n"
                                     + "The Zombie King has defeated you and your party.\n"
                                     + "Once again, humanity has lost its hope.\n"
                                     + "Game Over.";
                JOptionPane.showMessageDialog(null, defeatMessage, "Defeat", JOptionPane.PLAIN_MESSAGE);
            }
        } 
        else if (attemptSword.equalsIgnoreCase("no")) {
            String forfeitMessage = "You have chosen not to attempt to wield the legendary sword.\n"
                                  + "The Zombie King has defeated you and your party.\n"
                                  + "Once again, humanity has lost its hope.\n"
                                  + "Game Over.";
            JOptionPane.showMessageDialog(null, forfeitMessage, "Game Over", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Apply custom theme first
        applyZombieTheme();

        title();

        boolean eligible = identification();

        if (eligible) {
            int playerRole = role();
            int playerHP = firstAttack();
            bossFight(playerRole, playerHP);
        }
    }
}