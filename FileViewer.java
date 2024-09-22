import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileViewer extends JFrame 
{
    private JComboBox<String> fileComboBox;
    private JTextArea textArea;
    private JTextField textField;
    private JButton nextLineButton;
    private JButton nextFileButton;
    private BufferedReader reader;
    private File[] files;
    private int currentFileIndex = 0;

    public FileViewer() 
    {
        setTitle("File Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        files = new File[] 
        {
                new File("file1.txt"),
                new File("file2.txt"),
                new File("file3.txt")
        };

        fileComboBox = new JComboBox<>(new String[] { "file1.txt", "file2.txt", "file3.txt" });
        textArea = new JTextArea();
        textField = new JTextField(50);
        nextLineButton = new JButton("Next Line");
        nextFileButton = new JButton("Next File");

        JPanel topPanel = new JPanel();
        topPanel.add(fileComboBox);
        topPanel.add(nextLineButton);
        topPanel.add(nextFileButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);

        fileComboBox.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {loadSelectedFile();}
        });

        nextLineButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {showNextLine();}
        });

        nextFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {showNextFile();}
        });

        loadSelectedFile();
    }

    private void loadSelectedFile() 
    {
        if (reader != null) 
        {
            try 
            {reader.close();} 
            catch (IOException e) 
            {e.printStackTrace();}
        }

        String selectedFile = (String) fileComboBox.getSelectedItem();
        currentFileIndex = fileComboBox.getSelectedIndex();
        File file = new File(selectedFile);

        try 
        {
            reader = new BufferedReader(new FileReader(file));
            textArea.setText("");
            String line;
            while ((line = reader.readLine()) != null) 
            {textArea.append(line + "\n");}
            reader.close();
            reader = new BufferedReader(new FileReader(file));
            showNextLine();
        } 
        catch (IOException e) 
        {e.printStackTrace();}
    }

    private void showNextLine() 
    {
        try 
        {
            if (reader != null) 
            {
                String line = reader.readLine();
                if (line != null) 
                {textField.setText(line);}
            else 
                {textField.setText("End of file reached.");}
            }
        } 
        catch (IOException e) 
        {e.printStackTrace();}
    }

    private void showNextFile() 
    {
        currentFileIndex = (currentFileIndex + 1) % files.length;
        fileComboBox.setSelectedIndex(currentFileIndex);
    }

    public static void main(String[] args) 
    {FileViewer fv = new FileViewer();
    fv.setVisible(true);}        
    }

