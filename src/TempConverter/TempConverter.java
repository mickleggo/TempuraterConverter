package TempConverter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Small temperature conversion app with the ability to go between
 * the three main temperature options of Celcius, Kelvin, and Farenheit
 * 
 * 
 * Author: Michael Legg
 */


public class TempConverter {
	
	private TempGUI gui = new TempGUI();
	private AboutWindow about = new AboutWindow();
	private ErrorMessage error = new ErrorMessage();
	private MenuHandler mHandler = new MenuHandler();
	private ButtonHandler bHandler = new ButtonHandler();
	private TextHandler tHandler = new TextHandler();
	
	DecimalFormat df = new DecimalFormat("##0.####E0");
	
	private boolean unitsSet;
	private String units;
	private String response;
	private double initTemp, convTemp;
	

	public static void main(String[] args) {

		new TempConverter();
		
	}
	
	public TempConverter() {
		
		units = "";
		unitsSet = false;
		gui.GUI(mHandler, bHandler, tHandler);
		
	}
	
	
	public void setC2F() {
		unitsSet = true;
		units = "C2F";
		gui.lblStartUnit.setText("°C");
		gui.lblEndUnit.setText("°F");
	}
	
	public void setC2K() {
		unitsSet = true;
		units = "C2K";
		gui.lblStartUnit.setText("°C");
		gui.lblEndUnit.setText("°K");
	}
	
	public void setF2K() {
		unitsSet = true;
		units = "F2K";
		gui.lblStartUnit.setText("°F");
		gui.lblEndUnit.setText("°K");
	}
	
	public void setF2C() {
		unitsSet = true;
		units = "F2C";
		gui.lblStartUnit.setText("°F");
		gui.lblEndUnit.setText("°C");
	}
	
	public void setK2C() {
		unitsSet = true;
		units = "K2C";
		gui.lblStartUnit.setText("°K");
		gui.lblEndUnit.setText("°C");
	}
	
	public void setK2F() {
		unitsSet = true;
		units = "K2F";
		gui.lblStartUnit.setText("°K");
		gui.lblEndUnit.setText("°F");
	}
	
	private void testInput() {
		
		response = gui.txtGetValue.getText();
		initTemp = Double.NaN;
		
		try {
			response.trim();
			initTemp = Double.parseDouble(response);
		}
		catch (Exception e) {
			gui.txtGetValue.setText("");
			error.Error();
			error.message.setText("Unrecognised value input.");
		}
		
		if ( Double.isNaN(initTemp) ) {
			
		}
		else {
			Convert();
		}
		
		
	}
	
	public void Convert() {
		
		switch (units) {
			
			case "C2F" : {
				if (initTemp < Double.valueOf(-273.15)) {
					initTemp = Double.valueOf(-273.15);
					gui.txtGetValue.setText(String.valueOf(initTemp));
				}
				convTemp = C2F(initTemp);
				break;
			}
			
			case "C2K" : {
				if (initTemp < Double.valueOf(-273.15)) {
					initTemp = Double.valueOf(-273.15);
					gui.txtGetValue.setText(String.valueOf(initTemp));
				}
				convTemp = C2K(initTemp);
				break;
			}

			case "F2K" : {
				if (initTemp < Double.valueOf(-459.67)) {
					initTemp = Double.valueOf(-459.67);
					gui.txtGetValue.setText(String.valueOf(initTemp));
				}
				convTemp = F2C(initTemp);
				convTemp = C2K(convTemp);
				break;
			}

			case "F2C" : {
				if (initTemp < Double.valueOf(-459.67)) {
					initTemp = Double.valueOf(-459.67);
					gui.txtGetValue.setText(String.valueOf(initTemp));
				}
				convTemp = F2C(initTemp);
				break;
			}

			case "K2C" : {
				if (initTemp < Double.valueOf(0.0)) {
					initTemp = Double.valueOf(0.0);
					gui.txtGetValue.setText(String.valueOf(initTemp));
				}
				convTemp = K2C(initTemp);
				break;
			}

			case "K2F" : {
				if (initTemp < Double.valueOf(0.0)) {
					initTemp = Double.valueOf(0.0);
					gui.txtGetValue.setText(String.valueOf(initTemp));
				}
				convTemp = K2C(initTemp);
				convTemp = C2F(convTemp);
				break;
			}
			
			default : {
				System.out.println("Error with conversion");
			}
		}
		
		gui.txtConvertValue.setText(df.format(convTemp));
		
	}
	
	
	public double C2K(double temp) {
		double convert = 0d;
		convert = (temp + 273.15);
		return convert;
	}
	
	public double K2C(double temp) {
		double convert = 0d;
		convert = temp - 273.15;
		return convert;
	}
	
	public double C2F(double temp) {
		double convert = 0d;
		convert = (((temp * 9) / 5) + 32 );
		return convert;
	}
	
	public double F2C(double temp) {
		double convert = 0d;
		convert = (((temp - 32) * 5 ) / 9 );
		return convert;
	}	
	
	
	public class MenuHandler implements MenuListener{

		public void menuSelected(MenuEvent e) {

			about.About();
			
		}

		public void menuDeselected(MenuEvent e) {
		}
		public void menuCanceled(MenuEvent e) {
		}
		
	}
	
	
	public class ButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String btn = String.valueOf(e);
			btn = GetButton.ButtonSubstring(btn);
			
			switch (btn) {
				case "°C to °F":
					setC2F();
					break;
					
				case "°C to °K":
					setC2K();
					break;
					
				case "°F to °K":
					setF2K();
					break;
	
				case "°F to °C":
					setF2C();
					break;
	
				case "°K to °C":
					setK2C();
					break;
	
				case "°K to °F":
					setK2F();
					break;
	
				case "Convert":
					if (unitsSet == true) {
						testInput();
					}
					else {
						error.Error();
						error.message.setText("Units need to be set first");
					}
					
					break;
					
				default:
					System.out.println("Button press error");
					
			}
			
		}
		
	}
	
	public class TextHandler implements KeyListener {

		public void keyPressed(KeyEvent e) {
			if ( e.getKeyCode() == 10 ) {
				if (unitsSet == true) {
					testInput();
				}
				else {
					error.Error();
					error.message.setText("Units need to be set first");
				}
			}
			else {
			}
			
		}

		public void keyReleased(KeyEvent e) {
		}
		public void keyTyped(KeyEvent e) {
		}
		
	}
	
	
	
	public static class GetButton {
		
		public static String ButtonSubstring(String e) {
			
			int subStrStart = e.lastIndexOf("cmd=") + 4;
			int subStrEnd = e.indexOf(',', subStrStart);
			e = e.substring(subStrStart, subStrEnd);
			
			return e;
		 }
		 
	}
}
