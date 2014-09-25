import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame {
	private String[] options = {"Temperature", "°F --> °C", "°C --> °F", "°F -->  K", " K --> °F", "°C -->  K", " K --> °C"};
	private JTextField input;
	private JComboBox optionBox;
	private JLabel output;
	private double num;
	private String answer;

	public Gui() {
		super("JUnitConverter");
		setLayout(new FlowLayout());

		input = new JTextField(10);
		add(input);

		optionBox = new JComboBox(options);
		optionBox.addItemListener(
			new ItemListener() {
				public void itemStateChanged(ItemEvent event) {
					switch(optionBox.getSelectedIndex()) {
					
					// °F --> °C
					case 1:
						num = Double.parseDouble(input.getText());
						num = (num - 32) / 1.8;
						answer = Double.toString(num);
						output.setText(answer + " °C");
						break;

					// °C --> °F
					case 2:
						num = Double.parseDouble(input.getText());
						num = (num * 1.8) + 32;
						answer = Double.toString(num);
						output.setText(answer + " °F");
						break;

					// °F --> K
					case 3:
						num = Double.parseDouble(input.getText());
						num = ((num - 32) / 1.8) + 273.15;
						answer = Double.toString(num);
						output.setText(answer + " K");
						break;

					// K --> °F
					case 4:
						num = Double.parseDouble(input.getText());
						num = num - 273.15;
						num = (num * 1.8) + 32;
						answer = Double.toString(num);
						output.setText(answer + " °F");
						break;

					// °C --> K
					case 5:
						num = Double.parseDouble(input.getText());
						num = num + 273.15;
						answer = Double.toString(num);
						output.setText(answer + " K");
						break;

					// K --> °C
					case 6:
						num = Double.parseDouble(input.getText());
						num = num - 273.15;
						answer = Double.toString(num);
						output.setText(answer + " °C");
						break;
					
					}
				}
			}
		);
		
		add(optionBox);

		output = new JLabel();
		add(output);
	}
}
