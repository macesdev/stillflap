package org.macesdev.stillflap.scenes.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.json.JSONException;
import org.macesdev.stillflap.scripts.HTTPRequest;
import org.macesdev.stillflap.scripts.downloadUpdate;
import org.macesdev.stillflap.scripts.setLanguageVeriable;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class wBoot extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JLabel logo2 = new JLabel("foundation");
	static JLabel logo1 = new JLabel("macesdev");
	static JLabel subtext = new JLabel("$checkForUpdates_level1");
	static JLabel build_number = new JLabel("$build_number");
	static JLabel pressenter = new JLabel("Press ENTER to Start Game");


	/**
	 * Launch the application.
	 */
	
	public static void enableCompoments(Boolean enbc) {
		if (enbc == false) {
			logo2.setEnabled(false);
			logo1.setEnabled(false);
			subtext.setEnabled(false);
			build_number.setEnabled(false);
			pressenter.setEnabled(false);
		} else {
			logo2.setEnabled(true);
			logo1.setEnabled(true);
			subtext.setEnabled(true);
			build_number.setEnabled(true);
			pressenter.setEnabled(true);
		}
	}
	
	public static void runScene() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wBoot frame = new wBoot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws JSONException 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	
	public wBoot() throws IOException, JSONException, InterruptedException {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			    int key = e.getKeyCode();

			    if(key == KeyEvent.VK_ENTER){
			    	try {
						if (org.macesdev.stillflap.scripts.setLanguageVeriable.parseJSON("version").equals(org.macesdev.stillflap.scripts.HTTPRequest.parsed())) {
							pressenter.setVisible(false);
							pressenter.setEnabled(false);
							
							subtext.setVisible(true);
							build_number.setVisible(true);

							String lang;
							try {
								lang = setLanguageVeriable.parseJSON("language");
								
								if (lang.equals("tr_TR")) {
									subtext.setText(org.macesdev.stillflap.assets.lang.tr_TR.checkForUpdates_notFound);
									build_number.setText("v" + org.macesdev.stillflap.assets.lang.general.thisVersionDOU + "-dev");
									setVisible(false);
									org.macesdev.stillflap.scenes.main.wMainMenu.runScene();
								} else {
									subtext.setText(org.macesdev.stillflap.assets.lang.en_US.checkFOrUpdates_notFound);
									build_number.setText("v" + org.macesdev.stillflap.assets.lang.general.thisVersionDOU + "-dev");
									
									setVisible(false);
									org.macesdev.stillflap.scenes.main.wMainMenu.runScene();
								}
							} catch (JSONException | IOException e1) {
								e1.printStackTrace();
							}
							
							try {
								System.out.println(HTTPRequest.parsed());
							} catch (JSONException | IOException e1) {
								e1.printStackTrace();
							}							
						} else {
							pressenter.setVisible(false);
							pressenter.setEnabled(false);
							
							subtext.setVisible(true);
							build_number.setVisible(true);

							String lang;
							try {
								lang = setLanguageVeriable.parseJSON("language");
								
								if (lang.equals("tr_TR")) {
									subtext.setText(org.macesdev.stillflap.assets.lang.tr_TR.checkForUpdatest_found);
									build_number.setText("v" + org.macesdev.stillflap.assets.lang.general.thisVersionSTR + "-dev");
									org.macesdev.stillflap.scenes.main.wDownloadUpdate.run();
								} else {
									subtext.setText(org.macesdev.stillflap.assets.lang.en_US.checkForUpdatest_found);
									build_number.setText("v" + org.macesdev.stillflap.assets.lang.general.thisVersionSTR + "-dev");
								}
							} catch (JSONException | IOException e1) {
								e1.printStackTrace();
							}
							
							try {
								System.out.println(HTTPRequest.parsed());
							} catch (JSONException | IOException e1) {
								e1.printStackTrace();
							}
							
							org.macesdev.stillflap.scripts.downloadUpdate.writeNewVersionConfig();
							setVisible(false);
							org.macesdev.stillflap.scripts.downloadUpdate.runNewUpdate();
						}
					} catch (NumberFormatException | JSONException | IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (URISyntaxException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			    }
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

			}
		});
		
		ImageIcon img = new ImageIcon("/org/macesdev/stillflap/assets/img/loading.png");
		setIconImage(img.getImage());
		
		setTitle("StillFlap - Loading Assets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 65, 600, 400);
		setBackground(Color.BLACK);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		build_number.setHorizontalAlignment(SwingConstants.RIGHT);
		build_number.setForeground(Color.WHITE);
		build_number.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		build_number.setBounds(446, 327, 134, 24);
		build_number.setVisible(false);
		contentPane.add(build_number);
			
		subtext.setHorizontalAlignment(SwingConstants.LEFT);
		subtext.setForeground(Color.WHITE);
		subtext.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		subtext.setBounds(12, 327, 324, 24);
		subtext.setVisible(false);
		contentPane.add(subtext);

		logo1.setHorizontalAlignment(SwingConstants.CENTER);
		logo1.setForeground(Color.WHITE);
		logo1.setFont(new Font("Ubuntu", Font.BOLD, 28));
		logo1.setBounds(136, 142, 324, 42);
		contentPane.add(logo1);
		
		logo2.setHorizontalAlignment(SwingConstants.CENTER);
		logo2.setForeground(Color.WHITE);
		logo2.setFont(new Font("Ubuntu", Font.BOLD, 20));
		logo2.setBounds(136, 170, 324, 42);
		contentPane.add(logo2);
		
		pressenter.setHorizontalAlignment(SwingConstants.CENTER);
		pressenter.setForeground(Color.WHITE);
		pressenter.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		pressenter.setBounds(12, 308, 568, 30);
		contentPane.add(pressenter);
		
		String lang;
		try {
			lang = setLanguageVeriable.parseJSON("language");
			
			if (lang.equals("tr_TR")) {
				pressenter.setText(org.macesdev.stillflap.assets.lang.tr_TR.pressenter);
				setTitle(org.macesdev.stillflap.assets.lang.tr_TR.wBoot_Title);
			} else {
				pressenter.setText(org.macesdev.stillflap.assets.lang.en_US.pressenter);
			}
		} catch (JSONException | IOException e1) {
			e1.printStackTrace();
		}
	}
}