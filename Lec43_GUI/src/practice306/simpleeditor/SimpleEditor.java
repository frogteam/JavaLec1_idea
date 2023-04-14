package practice306.simpleeditor;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Simple Editor
 *
 *
 */

public class SimpleEditor extends JFrame implements ActionListener, DocumentListener {

	// text area
	JTextArea taText = new JTextArea();

	// menu
	JMenuItem miNew = new JMenuItem("New");
	JMenuItem miOpen = new JMenuItem("Open");
	JMenuItem miSave = new JMenuItem("Save");
	JMenuItem miClose = new JMenuItem("Close");
	JMenuItem miExit = new JMenuItem("Exit");

	// status
	private boolean isChanged = false;

	// file name
	private String fileName;

	// title
	private String title = "Simple Editor";

	// file chooser
	private JFileChooser chooser = new JFileChooser();

	// ------------------------------------------
	// constructor
	// ------------------------------------------
	public SimpleEditor() {
		super();
		buildGUI();
	}

	// ------------------------------------------
	// build gui
	// ------------------------------------------
	void buildGUI() {

		// build menu
		JMenuBar bar = new JMenuBar();
		JMenu muFile = new JMenu("File");
		bar.add(muFile);
		muFile.add(miNew);
		muFile.add(miOpen);
		muFile.add(miSave);
		muFile.add(miClose);
		muFile.addSeparator();
		muFile.add(miExit);

		setJMenuBar(bar);

		// build text area
		getContentPane().add(new JScrollPane(taText), BorderLayout.CENTER);

		// listener
		taText.getDocument().addDocumentListener(this);

		miNew.addActionListener(this);
		miOpen.addActionListener(this);
		miSave.addActionListener(this);
		miClose.addActionListener(this);
		miExit.addActionListener(this);

		// clear
		try {
			newFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// close operation
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

	}

	// ------------------------------------------
	// check updated
	// ------------------------------------------
	public boolean checkUpdated() throws Exception {

		if (isChanged) {

			int res = JOptionPane.showConfirmDialog(this, "Save File ?", "Save", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (res == JOptionPane.YES_OPTION) {
				save();
			} else if (res == JOptionPane.CANCEL_OPTION) {
				return true;
			}

		}

		return false;

	}

	// ------------------------------------------
	// new file
	// ------------------------------------------
	public void newFile() throws Exception {

		// check updated
		if (checkUpdated()) {
			return;
		}

		// clear
		taText.setText("");
		isChanged = false;
		setTitle(title + "[New File]");
		fileName = null;

	}

	// ------------------------------------------
	// open
	// ------------------------------------------
	public void open() throws Exception {

		// check updated
		if (checkUpdated()) {
			return;
		}

		// file chooser
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			// load file
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(chooser.getSelectedFile())));
			String line = "";
			taText.setText(line);
			while ((line = reader.readLine()) != null) {
				taText.append(line + "\n");
			}

			// title
			fileName = chooser.getSelectedFile().getPath();
			setTitle(title + "[" + chooser.getSelectedFile().getName() + "]");

			isChanged = false;

		}

	}

	// ------------------------------------------
	// close
	// ------------------------------------------
	public void close() throws Exception {

		// check updated
		if (checkUpdated()) {
			return;
		}

		newFile();

	}

	// ------------------------------------------
	// save
	// ------------------------------------------
	public void save() throws Exception {

		if (fileName == null) {
			int returnVal = chooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileName = chooser.getSelectedFile().getPath();
			} else {
				throw new Exception("Save Canceled !");
			}
		}

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
		System.out.println(taText.getText());
		writer.write(taText.getText());
		writer.close();

		isChanged = false;

	}

	// ------------------------------------------
	// exit
	// ------------------------------------------
	public void exit() throws Exception {

		// check updated
		if (checkUpdated()) {
			return;
		}

		// exit
		setVisible(false);
		dispose();
		System.exit(0);

	}

	// ------------------------------------------
	// action listener method
	// ------------------------------------------
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		try {

			if (obj == miNew) {
				newFile();
			} else if (obj == miOpen) {
				open();
			} else if (obj == miClose) {
				close();
			} else if (obj == miSave) {
				save();
			} else if (obj == miExit) {
				exit();
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	// ------------------------------------------
	// document listener methods
	// ------------------------------------------
	public void changedUpdate(DocumentEvent e) {
		isChanged = true;
	}

	public void insertUpdate(DocumentEvent e) {
		isChanged = true;
	}

	public void removeUpdate(DocumentEvent e) {
		isChanged = true;
	}

	// ------------------------------------------
	// main
	// ------------------------------------------
	public static void main(String[] args) throws Exception {

		SimpleEditor editor = new SimpleEditor();
		editor.setSize(800, 600);
		editor.setVisible(true);

	}

}