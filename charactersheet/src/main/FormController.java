package main;

import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class FormController implements ActionListener
{
    static CharacterItems myItems;
    JFrame frame;
    JMenuBar menuBar;
    JMenu menu;
    JMenu menuRight;
    JMenuItem menuItemNew;
    JMenuItem menuItemSave;
    JMenuItem menuItemOpen;
    JMenuItem menuItemExit;
    JMenuItem menuItemAbility;
    JMenuItem menuItemLang;
    JPanel infoPanel;
    JPanel rightPanel;
    FileChooserController fileChooser;
    
    public FormController() {
        FormController.myItems = new CharacterItems();
        this.fileChooser = new FileChooserController();
        (this.frame = new JFrame("Character Sheet")).setLayout(new GridLayout(1, 2));
        this.frame.setDefaultCloseOperation(3);
        this.setupPanels();
        this.frame.add(this.infoPanel);
        this.frame.add(this.rightPanel);
        this.menuBar = new JMenuBar();
        (this.menu = new JMenu("File")).setMnemonic(70);
        this.menu.getAccessibleContext().setAccessibleDescription("Access file options");
        this.menu.setActionCommand("file");
        this.menu.addActionListener(this);
        this.menuBar.add(this.menu);
        this.menuItemNew = new JMenuItem("New", 78);
        this.menuItemNew.getAccessibleContext().setAccessibleDescription("Create new character sheet");
        this.menuItemNew.setActionCommand("new");
        this.menuItemNew.addActionListener(this);
        this.menu.add(this.menuItemNew);
        this.menuItemOpen = new JMenuItem("Open", 79);
        this.menuItemOpen.getAccessibleContext().setAccessibleDescription("Open existing character sheet");
        this.menuItemOpen.setActionCommand("open");
        this.menuItemOpen.addActionListener(this);
        this.menu.add(this.menuItemOpen);
        this.menuItemSave = new JMenuItem("Save", 83);
        this.menuItemSave.getAccessibleContext().setAccessibleDescription("Save current character sheet");
        this.menuItemSave.setActionCommand("save");
        this.menuItemSave.addActionListener(this);
        this.menu.add(this.menuItemSave);
        this.menuItemExit = new JMenuItem("Exit", 69);
        this.menuItemExit.getAccessibleContext().setAccessibleDescription("Exit program");
        this.menuItemExit.setActionCommand("exit");
        this.menuItemExit.addActionListener(this);
        this.menu.add(this.menuItemExit);
        (this.menuRight = new JMenu("Options")).setMnemonic(79);
        this.menuRight.getAccessibleContext().setAccessibleDescription("Access right hand display options");
        this.menuRight.setActionCommand("options");
        this.menuRight.addActionListener(this);
        this.menuBar.add(this.menuRight);
        this.menuItemAbility = new JMenuItem("Ability Scores", 65);
        this.menuItemAbility.getAccessibleContext().setAccessibleDescription("Display ability scores on right hand panel");
        this.menuItemAbility.setActionCommand("ability");
        this.menuItemAbility.addActionListener(this);
        this.menuRight.add(this.menuItemAbility);
        this.menuItemLang = new JMenuItem("Languages", 76);
        this.menuItemLang.getAccessibleContext().setAccessibleDescription("Display languages on right hand panel");
        this.menuItemLang.setActionCommand("lang");
        this.menuItemLang.addActionListener(this);
        this.menuRight.add(this.menuItemLang);
        this.frame.setJMenuBar(this.menuBar);
        this.infoPanel = FormController.myItems.setupInfoPanel(this.infoPanel);
        this.rightPanel = FormController.myItems.displayRight(this.rightPanel);
    }
    
    public static void main(final String[] args) {
    }
    
    public void display() {
        System.out.println("In Display");
        FormController.myItems.refreshPanel(this.infoPanel);
        FormController.myItems.refreshPanel(this.rightPanel);
        this.frame.setSize(750, 750);
        this.frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String actionCommand;
        switch (actionCommand = e.getActionCommand()) {
            case "ability": {
                this.rightPanel.removeAll();
                FormController.myItems.displayRight(this.rightPanel);
                this.display();
                return;
            }
            case "new": {
                FormController.myItems = new CharacterItems();
                this.infoPanel.removeAll();
                this.rightPanel.removeAll();
                this.infoPanel = FormController.myItems.setupInfoPanel(this.infoPanel);
                this.rightPanel = FormController.myItems.displayRight(this.rightPanel);
                this.display();
                return;
            }
            case "exit": {
                this.frame.dispose();
                return;
            }
            case "lang": {
                this.rightPanel.removeAll();
                FormController.myItems.displayRight(this.rightPanel, e.getActionCommand());
                this.display();
                return;
            }
            case "open": {
                this.fileChooser.createWindow("open");
                FormController.myItems = FormController.myItems.openData(this.fileChooser.getFile(), FormController.myItems);
                this.infoPanel.removeAll();
                this.rightPanel.removeAll();
                this.infoPanel = FormController.myItems.setupInfoPanel(this.infoPanel);
                this.rightPanel = FormController.myItems.displayRight(this.rightPanel);
                this.display();
                System.out.println(FormController.myItems.checkName());
                if (FormController.myItems.checkName()) {
                    this.frame.setTitle(String.valueOf(FormController.myItems.getName()) + "'s Character Sheet");
                }
                return;
            }
            case "save": {
                this.fileChooser.createWindow("save");
                FormController.myItems.saveData(this.fileChooser.getFile(), FormController.myItems);
                return;
            }
            default:
                break;
        }
        this.display();
    }
    
    public void setupPanels() {
        (this.infoPanel = new JPanel(new GridLayout(10, 2, 10, 10))).setBounds(50, 50, 200, 200);
        this.infoPanel.setBackground(Color.gray);
        this.infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        (this.rightPanel = new JPanel(new GridLayout(10, 2, 10, 10))).setBounds(50, 50, 200, 200);
        this.rightPanel.setBackground(Color.gray);
        this.rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
