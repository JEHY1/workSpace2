package CalCulator;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Set;

public class CalculatorEx {
	static String valStr = "";
	
	public static void main(String[] args) {

		Frame frame = new Frame("Calculator");
		frame.setSize(350, 550);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;


	
		
		Panel status = new Panel(); //계산 식, 계산 결과를 나타내는 부분
		status.setBackground(Color.gray);
		status.setSize(350, 150);
		Panel buttonsPanel = new Panel(); //숫자 및 연산기호 버튼을 포함하는 panel
		buttonsPanel.setLayout(new GridLayout(6,4));
		Panel reloadPanel = new Panel();
		reloadPanel.setBackground(Color.black);

		Label val = new Label(valStr);

		//val.setSize(350, 70);
		
		val.setPreferredSize(new Dimension(300, 70));
		val.setBackground(Color.white);
		
		status.add(val);

		
		HashMap<String, Button> buttons = new HashMap<>();
		buttons.put("%", new Button("%"));
		buttons.put("CE", new Button("CE"));
		buttons.put("C", new Button("C"));
		buttons.put("del", new Button("del"));
		buttons.put("1/x", new Button("1/x"));
		buttons.put("x^2", new Button("x^2"));
		buttons.put("sqrt(x)", new Button("sqrt(x)"));
		buttons.put("/", new Button("/"));
		buttons.put("7", new Button("7"));
		buttons.put("8", new Button("8"));
		buttons.put("9", new Button("9"));
		buttons.put("*", new Button("*"));
		buttons.put("4", new Button("4"));
		buttons.put("5", new Button("5"));
		buttons.put("6", new Button("6"));
		buttons.put("-", new Button("-"));
		buttons.put("1", new Button("1"));
		buttons.put("2", new Button("2"));
		buttons.put("3", new Button("3"));
		buttons.put("+", new Button("+"));
		buttons.put("+/-", new Button("+/-"));
		buttons.put("0", new Button("0"));
		buttons.put(".", new Button("."));
		buttons.put("=", new Button("="));
		
		Button reload = new Button("reload");
		reloadPanel.add(reload);
		
		
		Set<String> keySet = buttons.keySet();
		for(String key : keySet) {
			buttonsPanel.add(buttons.get(key));
		}
		gbc.weighty = 0.01;
		gbc.weightx = 1.0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		frame.add(reloadPanel, gbc);
		gbc.weighty = 0.3;
		gbc.gridy = 1;
		frame.add(status, gbc);
		gbc.weighty = 0.7;
		gbc.gridy = 2;
		frame.add(buttonsPanel, gbc);

		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		buttons.get("0").addActionListener(e -> val.setText(valStr += 0));
		
		buttons.get("del").addActionListener(e -> val.setText(valStr = valStr.substring(0, valStr.length()-1)));
		
		
		
		double d = Double.parseDouble("100.24");
		System.out.println(d);
		
	}

}
