package TempConverter;
import java.awt.*;
import javax.swing.*;
import TempConverter.TempConverter.ButtonHandler;
import TempConverter.TempConverter.MenuHandler;
import TempConverter.TempConverter.TextHandler;


public class TempGUI {

	JFrame frame;
	JMenuBar menuBar;
	JMenu menuAbout;
	JButton btnC2K, btnK2C, btnC2F, btnF2C, btnF2K, btnK2F, btnConvert;
	JTextPane txtGetValue, txtConvertValue;
	JLabel lblStartUnit, lblEndUnit;
	
	public void GUI(MenuHandler mHandler, ButtonHandler bHandler, TextHandler tHandler) {
		
	/**************************************************************************************************/
	/* Initial Window */
		
		frame = new JFrame("Temperature Converter");
		frame.setBounds(750, 200, 460, 480);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		
		menuAbout = new JMenu("About");
		menuAbout.addMenuListener(mHandler);
		menuBar.add(menuAbout);
		
		frame.setJMenuBar(menuBar);
		
	/**************************************************************************************************/	
	/* Add selection Buttons */
		
		btnC2F = new JButton("°C to °F");
		btnC2F.setBounds(50, 25, 90, 50);
		btnC2F.addActionListener(bHandler);
		frame.getContentPane().add(btnC2F);
		
		btnF2C = new JButton("°F to °C");
		btnF2C.setBounds(50, 100, 90, 50);
		btnF2C.addActionListener(bHandler);
		frame.getContentPane().add(btnF2C);
		
		btnC2K = new JButton("°C to °K");
		btnC2K.setBounds(170, 25, 90, 50);
		btnC2K.addActionListener(bHandler);
		frame.getContentPane().add(btnC2K);
		
		btnK2C = new JButton("°K to °C");
		btnK2C.setBounds(170, 100, 90, 50);
		btnK2C.addActionListener(bHandler);
		frame.getContentPane().add(btnK2C);
		
		btnF2K = new JButton("°F to °K");
		btnF2K.setBounds(290, 25, 90, 50);
		btnF2K.addActionListener(bHandler);
		frame.getContentPane().add(btnF2K);
		
		btnK2F = new JButton("°K to °F");
		btnK2F.setBounds(290, 100, 90, 50);
		btnK2F.addActionListener(bHandler);
		frame.getContentPane().add(btnK2F);
		
	/**************************************************************************************************/	
	/* Add input box and label */
		
		txtGetValue = new JTextPane();
		txtGetValue.setBounds(50, 190, 290, 55);
		txtGetValue.setFont(new Font("Dialog", Font.BOLD, 35));
		txtGetValue.addKeyListener(tHandler);
		txtGetValue.setAutoscrolls(false);
		frame.getContentPane().add(txtGetValue);
		disableKeys(txtGetValue.getInputMap());
		
		lblStartUnit = new JLabel("", SwingConstants.CENTER);
		lblStartUnit.setBounds(360, 190, 40, 55);
		lblStartUnit.setFont(new Font("Dialog", Font.BOLD, 35));
		frame.getContentPane().add(lblStartUnit);
		
	/**************************************************************************************************/	
	/* Conversion Button */
		
		btnConvert = new JButton("Convert");
		btnConvert.setBounds(130, 260, 170, 40);
		btnConvert.addActionListener(bHandler);
		frame.getContentPane().add(btnConvert);
		
	/**************************************************************************************************/
	/* Output box and label */
		
		txtConvertValue = new JTextPane();
		txtConvertValue.setBounds(50, 320, 290, 55);
		txtConvertValue.setFont(new Font("Dialog", Font.BOLD, 35));
		txtConvertValue.setBackground(Color.decode("#D4D4D4"));
		txtConvertValue.setEditable(false);
		frame.getContentPane().add(txtConvertValue);
		
		lblEndUnit = new JLabel("", SwingConstants.CENTER);
		lblEndUnit.setBounds(360, 320, 40, 55);
		lblEndUnit.setFont(new Font("Dialog", Font.BOLD, 35));
		frame.getContentPane().add(lblEndUnit);
		
	/**************************************************************************************************/
	/* Show window */
		
		frame.setVisible(true);
		
	}
	
	private void disableKeys(InputMap inputMap) {
		
		String[] keys = {"ENTER"};
		for (String key : keys) {
			inputMap.put(KeyStroke.getKeyStroke(key), "none");
		}
		
	}
	
	
}
