import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class NotesApp
{
    JFrame f = new JFrame("NOTES APPLICATION");
    JTextArea textArea = new JTextArea(10,10);
    JButton SUBMIT = new JButton("SUBMIT");
    JButton DELETE = new JButton("DELETE");
    JButton UPDATE = new JButton("UPDATE");
    JButton READ = new JButton("READ");
    JList<String> notesList;
    DefaultListModel<String> listModel;
    ArrayList<String> notes = new ArrayList<>();
    int selectedIndex = -1;

    public NotesApp() 
    {
        f.setLayout(new FlowLayout());
        f.setSize(300, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        notesList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(notesList);
        scrollPane.setPreferredSize(new Dimension(280, 150));

        f.add(scrollPane);
        f.add(textArea);
        f.add(SUBMIT);
        f.add(UPDATE);
        f.add(DELETE);
        f.add(READ);

        SUBMIT.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String note = textArea.getText();
                if (!note.isEmpty()) 
                {
                    notes.add(note);
                    listModel.addElement(note);
                    textArea.setText("");
                }
            }
        });

        DELETE.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                selectedIndex = notesList.getSelectedIndex();
                if (selectedIndex != -1) 
                {
                    notes.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                    textArea.setText("");
                }
            }
        });

        UPDATE.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                selectedIndex = notesList.getSelectedIndex();
                if (selectedIndex != -1 && !textArea.getText().isEmpty()) 
                {
                    String updatedNote = textArea.getText();
                    notes.set(selectedIndex, updatedNote);
                    listModel.set(selectedIndex, updatedNote);
                    textArea.setText("");
                }
            }
        });

        READ.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                selectedIndex = notesList.getSelectedIndex();
                if (selectedIndex != -1) 
                {textArea.setText(notes.get(selectedIndex));}
            }
        });

        f.setVisible(true);
    }

    public static void main(String args[]) 
    {new NotesApp();}
}
