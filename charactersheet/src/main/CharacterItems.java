package main;

import java.awt.event.ItemEvent;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.io.Serializable;

public class CharacterItems implements Serializable, ItemListener
{
    private static final long serialVersionUID = 1L;
    String name;
    String race;
    String gender;
    String charClass;
    String background;
    int level;
    String alignment;
    String personality;
    String ideals;
    String flaws;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    boolean language1;
    boolean language2;
    boolean language3;
    boolean language4;
    transient JTextArea textArea;
    transient JTextArea textArea1;
    transient JTextArea textArea2;
    transient JTextArea textArea3;
    transient JTextArea textArea4;
    transient JTextArea textArea5;
    transient JTextArea textArea6;
    transient JTextArea textArea7;
    transient JTextArea textArea8;
    transient JTextArea textArea9;
    transient JTextArea rightTextArea;
    transient JTextArea rightTextArea1;
    transient JTextArea rightTextArea2;
    transient JTextArea rightTextArea3;
    transient JTextArea rightTextArea4;
    transient JTextArea rightTextArea5;
    transient JTextArea rightTextArea6;
    transient JTextArea rightTextArea7;
    transient JTextArea rightTextArea8;
    transient JTextArea rightTextArea9;
    transient JCheckBox lang1Button;
    transient JCheckBox lang2Button;
    transient JCheckBox lang3Button;
    transient JCheckBox lang4Button;
    
    public static void main(final String[] args) {
    }
    
    public JPanel setupInfoPanel(final JPanel panel) {
        final JLabel label = new JLabel("Name :");
        panel.add(label);
        panel.add(this.textArea = new JTextArea(this.getName()));
        final JLabel label2 = new JLabel("Race :");
        panel.add(label2);
        panel.add(this.textArea1 = new JTextArea(this.getRace()));
        final JLabel label3 = new JLabel("Gender");
        panel.add(label3);
        panel.add(this.textArea2 = new JTextArea(this.getGender()));
        final JLabel label4 = new JLabel("Class");
        panel.add(label4);
        panel.add(this.textArea3 = new JTextArea(this.getCharClass()));
        final JLabel label5 = new JLabel("Background :");
        panel.add(label5);
        panel.add(this.textArea4 = new JTextArea(this.getBackground()));
        final JLabel label6 = new JLabel("Level :");
        panel.add(label6);
        panel.add(this.textArea5 = new JTextArea(this.getLevel()));
        final JLabel label7 = new JLabel("Alignment :");
        panel.add(label7);
        panel.add(this.textArea6 = new JTextArea(this.getAlignment()));
        final JLabel label8 = new JLabel("Personality :");
        panel.add(label8);
        panel.add(this.textArea7 = new JTextArea(this.getPersonality()));
        final JLabel label9 = new JLabel("Ideals :");
        panel.add(label9);
        panel.add(this.textArea8 = new JTextArea(this.getIdeals()));
        final JLabel label10 = new JLabel("Flaws : ");
        panel.add(label10);
        panel.add(this.textArea9 = new JTextArea(this.getFlaws()));
        return panel;
    }
    
    public void refreshPanel(final JPanel panel) {
        panel.revalidate();
        panel.repaint();
    }
    
    public JPanel displayRight(JPanel panel) {
        panel = this.displayAbility(panel);
        return panel;
    }
    
    public JPanel displayRight(JPanel panel, final String displayType) {
        switch (displayType) {
            case "ability": {
                panel = this.displayAbility(panel);
                return panel;
            }
            case "lang": {
                panel = this.displayLang(panel);
                return panel;
            }
            default:
                break;
        }
        panel = this.displayAbility(panel);
        return panel;
    }
    
    private JPanel displayAbility(final JPanel panel) {
        final JLabel label = new JLabel("Strength :");
        panel.add(label);
        panel.add(this.rightTextArea = new JTextArea(this.getStrength()));
        final JLabel label2 = new JLabel("Dexterity :");
        panel.add(label2);
        panel.add(this.rightTextArea2 = new JTextArea(this.getDexterity()));
        final JLabel label3 = new JLabel("Constitution :");
        panel.add(label3);
        panel.add(this.rightTextArea3 = new JTextArea(this.getConstitution()));
        final JLabel label4 = new JLabel("Intelligencce :");
        panel.add(label4);
        panel.add(this.rightTextArea4 = new JTextArea(this.getIntelligence()));
        final JLabel label5 = new JLabel("Wisdom :");
        panel.add(label5);
        panel.add(this.rightTextArea5 = new JTextArea(this.getWisdom()));
        final JLabel label6 = new JLabel("Charisma :");
        panel.add(label6);
        panel.add(this.rightTextArea6 = new JTextArea(this.getCharisma()));
        return panel;
    }
    
    private JPanel displayLang(final JPanel panel) {
        (this.lang1Button = new JCheckBox("lang1")).setSelected(this.getLang1());
        panel.add(this.lang1Button);
        this.lang1Button.addItemListener(this);
        (this.lang2Button = new JCheckBox("lang2")).setSelected(this.getLang2());
        panel.add(this.lang2Button);
        this.lang2Button.addItemListener(this);
        (this.lang3Button = new JCheckBox("lang3")).setSelected(this.getLang3());
        panel.add(this.lang3Button);
        this.lang3Button.addItemListener(this);
        (this.lang4Button = new JCheckBox("lang4")).setSelected(this.getLang4());
        panel.add(this.lang4Button);
        this.lang4Button.addItemListener(this);
        return panel;
    }
    
    private boolean getLang1() {
        return this.language1;
    }
    
    private boolean getLang2() {
        return this.language2;
    }
    
    private boolean getLang3() {
        return this.language3;
    }
    
    private boolean getLang4() {
        return this.language4;
    }
    
    private void setLang1(final Boolean update) {
        this.language1 = update;
    }
    
    private void setLang2(final Boolean update) {
        this.language2 = update;
    }
    
    private void setLang3(final Boolean update) {
        this.language3 = update;
    }
    
    private void setLang4(final Boolean update) {
        this.language4 = update;
    }
    
    public String getName() {
        if (this.name == null) {
            return "Enter character name here!";
        }
        return this.name;
    }
    
    public void setName(final String newName) {
        this.name = newName;
    }
    
    public String getRace() {
        if (this.race == null) {
            return "Enter character race here!";
        }
        return this.race;
    }
    
    public void setRace(final String newRace) {
        this.race = newRace;
    }
    
    public String getGender() {
        if (this.gender == null) {
            return "Enter character gender here!";
        }
        return this.gender;
    }
    
    public void setGender(final String newGender) {
        this.gender = newGender;
    }
    
    public String getCharClass() {
        if (this.charClass == null) {
            return "Enter character class here!";
        }
        return this.charClass;
    }
    
    public void setCharClass(final String newCharClass) {
        this.charClass = newCharClass;
    }
    
    public String getBackground() {
        if (this.background == null) {
            return "Enter character background here!";
        }
        return this.background;
    }
    
    public void setBackground(final String newBackground) {
        this.background = newBackground;
    }
    
    public String getLevel() {
        String newString;
        if (this.level == 0) {
            newString = "Enter character level here!";
        }
        else {
            newString = String.valueOf(this.level);
        }
        return newString;
    }
    
    public void setLevel(final String newLevel) {
        try {
            this.level = Integer.parseInt(newLevel);
        }
        catch (NumberFormatException e) {
            this.level = 0;
        }
    }
    
    public String getAlignment() {
        if (this.alignment == null) {
            return "Enter character alignment here!";
        }
        return this.alignment;
    }
    
    public void setAlignment(final String newAlignment) {
        this.alignment = newAlignment;
    }
    
    public String getPersonality() {
        if (this.personality == null) {
            return "Enter character personality here!";
        }
        return this.personality;
    }
    
    public void setPersonality(final String newPersonality) {
        this.personality = newPersonality;
    }
    
    public String getIdeals() {
        if (this.ideals == null) {
            return "Enter character ideals here!";
        }
        return this.ideals;
    }
    
    public void setIdeals(final String newIdeals) {
        this.ideals = newIdeals;
    }
    
    public String getFlaws() {
        if (this.flaws == null) {
            return "Enter character flaws here!";
        }
        return this.flaws;
    }
    
    public void setFlaws(final String newFlaws) {
        this.flaws = newFlaws;
    }
    
    public String getStrength() {
        String newString;
        if (this.level == 0) {
            newString = "Enter character strength here!";
        }
        else {
            newString = String.valueOf(this.strength);
        }
        return newString;
    }
    
    public void setStrength(final String strengthInp) {
        try {
            this.level = Integer.parseInt(strengthInp);
        }
        catch (NumberFormatException e) {
            if (this.strength != 0) {
                this.strength = 0;
                final JFrame frame = new JFrame("Strength Warning");
                JOptionPane.showMessageDialog(frame, "Strength must be set to numerical value.");
            }
        }
    }
    
    public String getDexterity() {
        String newString;
        if (this.level == 0) {
            newString = "Enter character Dexterity here!";
        }
        else {
            newString = String.valueOf(this.dexterity);
        }
        return newString;
    }
    
    public void setDexterity(final String dexterityInp) {
        try {
            this.level = Integer.parseInt(dexterityInp);
        }
        catch (NumberFormatException e) {
            this.dexterity = 0;
        }
    }
    
    public String getConstitution() {
        String newString;
        if (this.level == 0) {
            newString = "Enter character Constitution here!";
        }
        else {
            newString = String.valueOf(this.constitution);
        }
        return newString;
    }
    
    public void setConstitution(final String constitutionInp) {
        try {
            this.level = Integer.parseInt(constitutionInp);
        }
        catch (NumberFormatException e) {
            this.constitution = 0;
        }
    }
    
    public String getIntelligence() {
        String newString;
        if (this.level == 0) {
            newString = "Enter character Intelligence here!";
        }
        else {
            newString = String.valueOf(this.intelligence);
        }
        return newString;
    }
    
    public void setIntelligence(final String intelligenceInp) {
        try {
            this.level = Integer.parseInt(intelligenceInp);
        }
        catch (NumberFormatException e) {
            this.intelligence = 0;
        }
    }
    
    public String getWisdom() {
        String newString;
        if (this.level == 0) {
            newString = "Enter character Wisdom here!";
        }
        else {
            newString = String.valueOf(this.wisdom);
        }
        return newString;
    }
    
    public void setWisdom(final String wisdomInp) {
        try {
            this.level = Integer.parseInt(wisdomInp);
        }
        catch (NumberFormatException e) {
            this.wisdom = 0;
        }
    }
    
    public String getCharisma() {
        String newString;
        if (this.level == 0) {
            newString = "Enter character Charisma here!";
        }
        else {
            newString = String.valueOf(this.charisma);
        }
        return newString;
    }
    
    public void setCharisma(final String charismaInp) {
        try {
            this.level = Integer.parseInt(charismaInp);
        }
        catch (NumberFormatException e) {
            this.charisma = 0;
        }
    }
    
    public void saveData(final File file, final CharacterItems myItems) {
        this.setName(this.textArea.getText());
        this.setRace(this.textArea1.getText());
        this.setGender(this.textArea2.getText());
        this.setCharClass(this.textArea3.getText());
        this.setBackground(this.textArea4.getText());
        this.setLevel(this.textArea5.getText());
        this.setAlignment(this.textArea6.getText());
        this.setPersonality(this.textArea7.getText());
        this.setIdeals(this.textArea8.getText());
        this.setFlaws(this.textArea9.getText());
        this.setStrength(this.rightTextArea.getText());
        System.out.println("Strength = " + this.strength);
        this.setDexterity(this.rightTextArea2.getText());
        this.setConstitution(this.rightTextArea3.getText());
        this.setIntelligence(this.rightTextArea4.getText());
        this.setWisdom(this.rightTextArea5.getText());
        this.setCharisma(this.rightTextArea6.getText());
        System.out.println("data saved");
        System.out.println("Name =" + this.name);
        if (file != null) {
            this.serializeData(file, myItems);
        }
        else {
            System.out.println("no valid file");
        }
    }
    
    private void serializeData(final File file, final CharacterItems myItems) {
        try {
            final FileOutputStream fileOut = new FileOutputStream(file);
            final ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myItems);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + file, new Object[0]);
        }
        catch (IOException i) {
            i.printStackTrace();
        }
    }
    
    public CharacterItems openData(final File file, final CharacterItems myItems) {
        CharacterItems returnCharItems = new CharacterItems();
        if (file != null) {
            System.out.println("Getting data from file");
            returnCharItems = this.deserializeData(file);
        }
        else {
            System.out.println("ERROR!");
        }
        return returnCharItems;
    }
    
    private CharacterItems deserializeData(final File file) {
        CharacterItems temp = new CharacterItems();
        try {
            final FileInputStream fileIn = new FileInputStream(file);
            final ObjectInputStream in = new ObjectInputStream(fileIn);
            final Object input = in.readObject();
            temp = (CharacterItems)input;
            in.close();
            fileIn.close();
        }
        catch (IOException i) {
            i.printStackTrace();
        }
        catch (ClassNotFoundException c) {
            System.out.println("CharacterItems class not found");
            c.printStackTrace();
        }
        return temp;
    }
    
    public boolean checkName() {
        return this.name != null;
    }
    
    @Override
    public void itemStateChanged(final ItemEvent e) {
        final Object source = e.getItemSelectable();
        if (source == this.lang1Button) {
            this.setLang1(this.lang1Button.isSelected());
        }
        else if (source == this.lang2Button) {
            this.setLang2(this.lang2Button.isSelected());
        }
        else if (source == this.lang3Button) {
            this.setLang3(this.lang3Button.isSelected());
        }
        else if (source == this.lang4Button) {
            this.setLang4(this.lang4Button.isSelected());
        }
    }
}