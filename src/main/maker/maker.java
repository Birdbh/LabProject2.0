package maker;

import ui.main;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class maker {
    public JPanel panel;
    private JButton button1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    public String input;
    public String prompt;

    //Modifies: Constructs JFrame objects, including size, and visibility
    //Effects: Displays UI
    public maker() throws FileNotFoundException, UnsupportedEncodingException {
        JFrame frame = new JFrame("To Do List Application");
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,500);
        frame.setVisible(true);
    }

    //Modifies: all JFrame Objects: button1, textField1, label1, and label 2
    //Effects: sets the label1 text to be the list of tasks and sets label2 to be te specific prompt for that field
    //Resets the textField1 when the button is pressed
    private void createUIComponents() {


        panel = new JPanel();
        button1 = new JButton("Enter");
        textField1 = new JTextField();
        label1 = new JLabel(main.listTasks());
        label2 = new JLabel();
        label3 = new JLabel("");
        label4 = new JLabel();

        button1.addActionListener(e -> {
            input = textField1.getText();
            label1.setText(main.listTasks());
            label2.setText(prompt);
            textField1.setText("");
            try {
                commonSound();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }
        });

        textField1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    input = textField1.getText();
                    label1.setText(main.listTasks());
                    label2.setText(prompt);
                    textField1.setText("");
                    try {
                        commonSound();
                    } catch (UnsupportedAudioFileException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (LineUnavailableException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
    }


    //Requires: A string of any size
    //Modifies: the prompt, label2, and label 1
    //Effects: sets the prompt to a new string and updates the label1 and label2
    public void setPrompt(String prompt){
        this.prompt = prompt;
        label2.setText(prompt);
        label1.setText(main.listTasks());
    }

    //Effects: Waits until input value is not null and returns the value of the input and then resets it to null
    public String getInput() throws InterruptedException {
        while (input == null) {
            Thread.sleep(1000);
        }
        String tempvalue = input;
        input = null;
        return tempvalue;
    }

    public static void playSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        String soundName = "maker/sound.wav";
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\birdl\\IdeaProjects\\Lab Project\\src\\main\\maker\\sound.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    public void commonSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String soundName = "maker/commonsound.wav";
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\birdl\\IdeaProjects\\Lab Project\\src\\main\\maker\\commonsound.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    public void setSublist(String subList){
        label3.setText(subList);
    }

    public void setSublistHeader(String subListHeader){
        label4.setText(subListHeader);
    }
}
