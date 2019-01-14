import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class MadLibsGui extends JFrame {
	public  JTextField textField;
	public  static String message;
	private static JTextField questionTextField;
	public static int ctrIndex = 0;
	// The story I have used was found on 
	// https://docs.google.com/viewer?url=http://www.scholastic.ca/clubs/images/activities/ACT_HalloweenMadLibs_10_2012.pdf
	// declare global arrays and populate the type of words needed
		public static String [] wordTypeArray = {"Adjective", "Animal", "Place", "Verb", "Noun", "Verb (Past Tense)",
				"Adverb", "Exclamation", "Friend's Name", "Celebrity", "Silly Word", "Number",
				"Adjective", "Noun (Plural)", "Adjective", "Verb (Past Tense)", "Body Part (Plural)", 
				"Verb", "Noun (Plural)", "Verb (ending in -ing)", "Noun (Plural)", "Adjective"};
			public static String [] wordArray = new String[22];
			
			
	public MadLibsGui() {
		setSize(800, 600);
		setVisible(true);
		getContentPane().setBackground(Color.YELLOW);
		setForeground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.YELLOW);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The Best Halloween Party Ever");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(106, 49, 585, 39);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.ORANGE);
		textField.setForeground(Color.RED);
		textField.setFont(new Font("Dialog", Font.BOLD, 30));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ctrIndex <  wordTypeArray.length ) {
					updateWordArray();
//					if (ctrIndex < wordTypeArray.length - 1) {
					ctrIndex++;
					processWords();
					}
				}
//				else if (ctrIndex >= wordTypeArray.length) {
//					printStory();
//				}
//			}
		});
		textField.setBounds(574, 225, 161, 54);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		questionTextField = new JTextField();
		questionTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		questionTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
		questionTextField.setEditable(true);
		questionTextField.setText("Please enter a/an " + wordTypeArray[0] + ":");
		questionTextField.setForeground(Color.BLUE);
		questionTextField.setBackground(Color.YELLOW);
		questionTextField.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		questionTextField.setBounds(23, 240, 496, 54);
		questionTextField.setColumns(100);
		getContentPane().add(questionTextField);
		
		
		getContentPane().repaint();//used to fix problem with not all components showing on initial popup
		
		textField.requestFocusInWindow();// used to set the cursor to this text field for user entry
	}
		private void updateWordArray() {
			wordArray[ctrIndex] = textField.getText();
		//	System.out.println(wordArray[ctrIndex] + " " + ctrIndex);
			textField.setText(" ");
			textField.requestFocusInWindow();
			if (ctrIndex == wordTypeArray.length - 1) {
				printStory();
			}
		}
		public static void processWords() {
			
				if (ctrIndex < wordTypeArray.length) {
				questionTextField.setText("Please enter a/an " + wordTypeArray[ctrIndex] + ":");
			//	System.out.println(questionTextField.getText() + " " + ctrIndex);
				questionTextField.repaint();
			}
		}
		
		private static void printStory() {
			// Display story with user input words inserted in the story
			JFrame f = new JFrame("The Best Halloween Party Ever");
			f.setSize(1300, 600);// set the size of the frame
			f.setResizable(false); // make the frame so that it cannot be resized
			JTextArea story = new JTextArea();
			story.setBackground(Color.PINK);
			story.setForeground(Color.RED);
			Border typeBorder = BorderFactory.createLoweredBevelBorder();//set border type
			story.setBorder(typeBorder);
			story.setFont(new Font("Comic Sans MS", Font.BOLD, 30));// set the font type and size
			story.setText("Last night I went to the most "+ wordArray[0] + " Halloween party! The invitation was delivered\n ");
			story.append("by " + wordArray[1] + " and told me to go to the deep dark " + wordArray[2] + " and " + wordArray[3] + " all the \n");
			story.append("way to the very top of the spooky "+ wordArray[4] + ". I " + wordArray[5] + " the doorbell "+ wordArray[6] + ". \n");
			story.append("'" + wordArray[7] + "!' My friend "+ wordArray[8] + " answered the door dressed up as " + wordArray[9]  + "\n");
			story.append("and said  '" + wordArray[10] + "!' There were " + wordArray[11] + " different costumes, including \n");
			story.append(wordArray[12] + " ghouls and mummified " + wordArray[13] + ". The music was loud and " + wordArray[14] + ",\n");
			story.append("so I " + wordArray[15] + " until my " + wordArray[16] + " hurt. There were also delicious treats to \n");
			story.append(wordArray[17] + ", like candy corn and chocolate-covered "+ wordArray[18] + ", but my favourite part of \n");
			story.append("the party was the pumpkin " + wordArray[19] + " and bobbing for " + wordArray[20] + ". \n");
			story.append("I can't wait until next Halloween - it will be even more "+ wordArray[21] + "!");
			story.setEditable(false);// make the JTextField uneditable
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // handle the close of frame
			f.setAlwaysOnTop(true);
			f.setLocationRelativeTo(null);// set to middle of screen
			f.getContentPane().add(story);// add the text field to the JFrame
			f.setVisible(true);//make visible
		}


//	public static void main(String[] args) {
//		questionTextField = new JTextField();
//		questionTextField.setText("Please enter a/an " + wordTypeArray[0] + ":");
//		questionTextField.repaint();
//	
//	//	new MadLibsGui();
//		processWords();
//		
//
//	}
}
