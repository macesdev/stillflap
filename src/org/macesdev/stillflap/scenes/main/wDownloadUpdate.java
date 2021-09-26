package org.macesdev.stillflap.scenes.main;

import javax.swing.JDialog;

import org.json.JSONException;
import org.macesdev.stillflap.scripts.languageSettings;
import org.macesdev.stillflap.scripts.setLanguageVeriable;

import com.formdev.flatlaf.FlatIntelliJLaf;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JProgressBar;
import java.awt.Window.Type;

public class wDownloadUpdate extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void run() {
		try {
			wDownloadUpdate dialog = new wDownloadUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public wDownloadUpdate() throws MalformedURLException, IOException {
        String name = "os.name";
        
        if (System.getProperty(name).equals("Linux")) {
        	try {
        	      UIManager.setLookAndFeel(new FlatIntelliJLaf());
        	    } catch (Exception e1) {
        	      e1.printStackTrace();
        	    }
        }
		
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(-1);
			}
			@Override
			public void windowOpened(WindowEvent e) {

			}
		});
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JTextArea txtrdialogmessage = new JTextArea();
		txtrdialogmessage.setForeground(Color.WHITE);
		txtrdialogmessage.setText("$dialog_message");
		txtrdialogmessage.setBounds(297, 12, -284, 162);
		getContentPane().add(txtrdialogmessage);
		
		JLabel lblNewLabel = new JLabel("$text1");
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		lblNewLabel.setBounds(0, 0, 414, 42);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRestartedForIt = new JLabel("$text2");

		lblRestartedForIt.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestartedForIt.setForeground(Color.WHITE);
		lblRestartedForIt.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		lblRestartedForIt.setBounds(0, 28, 414, 42);
		getContentPane().add(lblRestartedForIt);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		
		int val = org.macesdev.stillflap.scripts.downloadUpdate.run("aaa");
		
		progressBar.setValue(val);
		
		if (progressBar.getValue() == 100) {
			System.out.println("Download Succesful!!");
		}
		
		progressBar.setBounds(10, 67, 382, 52);
		getContentPane().add(progressBar);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setTitle("Update Alert");
		setBounds(100, 100, 404, 167);
		
		String lang;
		try {
			lang = setLanguageVeriable.parseJSON();
			
			if (lang.equals("tr_TR")) {
				lblRestartedForIt.setText(org.macesdev.stillflap.assets.lang.tr_TR.downloadingNow_part2);	
				lblNewLabel.setText(org.macesdev.stillflap.assets.lang.tr_TR.downloadingNow_part1);	
				setTitle(org.macesdev.stillflap.assets.lang.tr_TR.wDownloadUpdate_Title);
			} else {
				lblRestartedForIt.setText(org.macesdev.stillflap.assets.lang.en_US.downloadingNow_part2);	
				lblNewLabel.setText(org.macesdev.stillflap.assets.lang.en_US.downloadingNow_part1);	
				setTitle(org.macesdev.stillflap.assets.lang.en_US.wDownloadUpdate_Title);
			}
		} catch (JSONException | IOException e1) {
			e1.printStackTrace();
		}
	}
}