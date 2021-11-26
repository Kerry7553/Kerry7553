package main;

import java.awt.LayoutManager;
import javax.swing.JFileChooser;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JFrame;
import java.io.File;

public class FileChooserController
{
    static File file;
    
    public static void main(final String[] args) {
    }
    
    void createWindow(final String mode) {
        final JFrame frame = new JFrame("Swing Tester");
        frame.setDefaultCloseOperation(3);
        createUI(frame, mode);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
    }
    
    private static File createUI(final JFrame frame, final String mode) {
        final JPanel panel = new JPanel();
        final LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);
        final JFileChooser fileChooser = new JFileChooser();
        int option;
        if (mode.equals("save")) {
            option = fileChooser.showSaveDialog(frame);
        }
        else {
            option = fileChooser.showOpenDialog(frame);
        }
        if (option == 0) {
            FileChooserController.file = fileChooser.getSelectedFile();
            String fname = FileChooserController.file.getAbsolutePath();
            if (!fname.endsWith("ser")) {
                fname = fname.substring(0, fname.lastIndexOf(46));
                fileChooser.setSelectedFile(FileChooserController.file = new File(String.valueOf(fname) + ".ser"));
            }
        }
        frame.dispose();
        return FileChooserController.file;
    }
    
    public File getFile() {
        System.out.println("Returned file = " + FileChooserController.file.getName());
        return FileChooserController.file;
    }
}
