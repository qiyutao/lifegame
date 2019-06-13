package qytdq.lifegame.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private int speed;
	private int initImage;

	/**
	 * Create the dialog.
	 */
	public Dialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("初始速度");
		lblNewLabel.setBounds(40, 27, 98, 39);
		contentPanel.add(lblNewLabel);

		JLabel label = new JLabel("预置图形");
		label.setBounds(40, 121, 98, 39);
		contentPanel.add(label);

		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		for (int i = 1; i <= 10; i++) {
			comboBox.addItem(i);
		}

		comboBox.setBounds(201, 34, 110, 27);
		contentPanel.add(comboBox);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("随机");
		comboBox_1.addItem("机枪");
		comboBox_1.addItem("飞船");
		comboBox_1.addItem("蝴蝶");
		comboBox_1.addItem("转轮");
		comboBox_1.addItem("子弹");
		comboBox_1.setBounds(201, 128, 110, 27);
		contentPanel.add(comboBox_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						speed = comboBox.getSelectedIndex() + 1;
						initImage = comboBox_1.getSelectedIndex();

						new AlgoFrame("Game of life",speed, initImage);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						speed = 1;
						initImage = 0;
						new AlgoFrame("Game of life",speed, initImage);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}