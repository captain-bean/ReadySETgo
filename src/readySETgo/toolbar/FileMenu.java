package readySETgo.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import backend.FileManager;
import readySETgo.MenuItemFactory;
import readySETgo.PrintManager;

public class FileMenu extends JMenu {
	
	public FileMenu() {
		super("File");
        MenuItemFactory mf = new MenuItemFactory();
        
        JMenuItem open = mf.createJMenuItem("Open", "Open a File");
        open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileManager.displayOpenPrompt();
			}});
        this.add(open);
        
        JMenuItem save = mf.createJMenuItem("Save", "Save current file");
        save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileManager.attemptSaveSilently();
			}});
        this.add(save);
        
        JMenuItem saveAs = mf.createJMenuItem("Save as", "Save current file as...");
        saveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileManager.displaySavePrompt();
			}});
        this.add(saveAs);
        
        this.addSeparator();
        
		JMenuItem printMenuItem = new JMenuItem("Print...");
		printMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintManager.getManager().print();
			}});
		this.add(printMenuItem);
		this.addSeparator();
		this.add(this.createExitMenuItem()); 
	}

	private JMenuItem createExitMenuItem() {
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
            								public void actionPerformed(ActionEvent e) {
                							System.exit(0);
                						}});
		return exitMenuItem;
	}
}