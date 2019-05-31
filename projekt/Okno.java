package projekt;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class Okno extends JFrame implements ActionListener,KeyListener {

	private JPanel contentPane;
	private JTextField text_wynik;
	private JTextField text_double;
	private JPanel panel;
	private JButton add;
	private JButton Button_1;
	private JButton Button_2;
	private JButton Button_3;
	private JButton Button_4;
	private JButton Button_5;
	private JButton Button_6;
	private JButton Button_7;
	private JButton Button_8;
	private JButton Button_9;
	private JButton Button_0;
	private JButton cc;
	private JButton min;
	private JButton mn;
	private JButton dz;
	private JButton wyn;
	private JButton lnaw;
	private JButton rnaw;
	private String napis="";
	private String napis2="";
	JProgressBar pasek;
	Integer wartosc_i=0;
	Double wartosc_d=0.0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okno frame = new Okno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Okno() {
		setTitle("Kalkulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		text_wynik = new JTextField();
		text_wynik.setBounds(0,0,312,41);
		text_wynik.setEditable(false);
		contentPane.add(text_wynik);
		text_wynik.setColumns(10);
		
		text_double = new JTextField();
		text_double.setBounds(0,258,312,35);
		text_double.setEditable(false);
		contentPane.add(text_double);
		text_double.setColumns(10);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 43, 342, 213);
		contentPane.add(panel);
		
		Button_1 = new JButton("1");
		Button_1.setBounds(10,110,50,50);
		Button_1.addActionListener(this);
		panel.add(Button_1);
		
		Button_2 = new JButton("2");
		Button_2.setBounds(60,110,50,50);
		Button_2.addActionListener(this);
		panel.add(Button_2);
		
		Button_3 = new JButton("3");
		Button_3.setBounds(110,110,50,50);
		Button_3.addActionListener(this);
		panel.add(Button_3);
		
		Button_4 = new JButton("4");
		Button_4.setBounds(10,60,50,50);
		Button_4.addActionListener(this);
		panel.add(Button_4);
		
		Button_5 = new JButton("5");
		Button_5.setBounds(60,60,50,50);
		Button_5.addActionListener(this);
		panel.add(Button_5);
		
		Button_6 = new JButton("6");
		Button_6.setBounds(110,60,50,50);
		Button_6.addActionListener(this);
		panel.add(Button_6);
		
		Button_7 = new JButton("7");
		Button_7.setBounds(10,10,50,50);
		Button_7.addActionListener(this);
		panel.add(Button_7);
		
		Button_8 = new JButton("8");
		Button_8.setBounds(60,10,50,50);
		Button_8.addActionListener(this);
		panel.add(Button_8);
		
		Button_9 = new JButton("9");
		Button_9.setBounds(110,10,50,50);
		Button_9.addActionListener(this);
		panel.add(Button_9);
		
		Button_0 = new JButton("0");
		Button_0.setBounds(60,160,50,50);
		Button_0.addActionListener(this);
		panel.add(Button_0);
		
		add = new JButton("+");
		add.setBounds(200,60,50,50);
		add.addActionListener(this);
		panel.add(add);
		
		cc = new JButton("c");
		cc.setBounds(200,10,50,50);
		cc.addActionListener(this);
		panel.add(cc);
		
		wyn = new JButton("=");
		wyn.setBounds(110,160,50,50);
		wyn.addActionListener(this);
		panel.add(wyn);
		
		min = new JButton("-");
		min.setBounds(200,110,50,50);
		min.addActionListener(this);
		panel.add(min);
		
		mn = new JButton("*");
		mn.setBounds(250,60,50,50);
		mn.addActionListener(this);
		panel.add(mn);
				
		dz = new JButton("/");
		dz.setBounds(250,110,50,50);
		dz.addActionListener(this);
		panel.add(dz);
		
		lnaw = new JButton("(");
		lnaw.setBounds(200,160,50,50);
		lnaw.addActionListener(this);
		panel.add(lnaw);
		
		rnaw = new JButton(")");
		rnaw.setBounds(250,160,50,50);
		rnaw.addActionListener(this);
		panel.add(rnaw);
		
		pasek = new JProgressBar();
		pasek.setMaximum(50);
		pasek.setBounds(0, 306, 312, 14);
		contentPane.add(pasek);
		
	}

	public String dzialanie(String dane)
	{
		String pom="";
		String suma="";
		wartosc_i=0;
		wartosc_d=0.0;
		int n=0;
		if(dane==null)return null;
		if(dane.charAt(0) == '(')
		{
			int ilosc_l=1;
			int ilosc_r=0;
			for(int i=1;i<dane.length();i++)
			{
				if(dane.charAt(i) == '(')ilosc_l++;
				if(dane.charAt(i) == ')')ilosc_r++;
				if(ilosc_r >= ilosc_l)break;
				pom+=dane.charAt(i);
				n++;
			}
			pom=dzialanie(pom);
			if(pom == "zle dane")return pom;
			suma+=pom;
			n+=2;
			if(dane.length() <= n)
			{
				return suma;
			}
			if((dane.charAt(n) != '+' )&& (dane.charAt(n) != '-' )&& (dane.charAt(n) != '*') && (dane.charAt(n) != '/'))
			{
				return "zle dane";
			}
			char znak=dane.charAt(n);
			dane=dane.substring(n+1);
			switch(znak)
			{
				case '+': wartosc_d=wartosc_d.parseDouble(suma)+wartosc_d.parseDouble(dzialanie(dane));break;
				case '-': wartosc_d=wartosc_d.parseDouble(suma)-wartosc_d.parseDouble(dzialanie(dane));break;
				case '*': wartosc_d=wartosc_d.parseDouble(suma)*wartosc_d.parseDouble(dzialanie(dane));break;
				case '/': wartosc_d=wartosc_d.parseDouble(suma)/wartosc_d.parseDouble(dzialanie(dane));break;
			}
			return wartosc_d.toString();
		}
		else
		{
			n=0;
			for(int i=0; i<dane.length();i++)
			{
				if((dane.charAt(n) == '+' )|| (dane.charAt(n) == '-') || (dane.charAt(n) == '*') || (dane.charAt(n) == '/') )break;
				suma+=dane.charAt(n);
				n++;
			}
			if(n>=dane.length())return suma;
			if((dane.charAt(n) != '+' )&& (dane.charAt(n) != '-' )&& (dane.charAt(n) != '*') && (dane.charAt(n) != '/'))
			{
				return "zle dane";
			}
			char znak=dane.charAt(n);
			dane=dane.substring(n+1);
			switch(znak)
			{
				case '+': wartosc_d=wartosc_d.parseDouble(suma)+wartosc_d.parseDouble(dzialanie(dane));break;
				case '-': wartosc_d=wartosc_d.parseDouble(suma)-wartosc_d.parseDouble(dzialanie(dane));break;
				case '*': wartosc_d=wartosc_d.parseDouble(suma)*wartosc_d.parseDouble(dzialanie(dane));break;
				case '/': wartosc_d=wartosc_d.parseDouble(suma)/wartosc_d.parseDouble(dzialanie(dane));break;
			}
			if(wartosc_d.isFinite(wartosc_d))return wartosc_d.toString();
			return "zle dane";
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("1"))napis += "1";
		if(arg0.getActionCommand().equals("2"))napis += "2";
		if(arg0.getActionCommand().equals("3"))napis += "3";
		if(arg0.getActionCommand().equals("4"))napis += "4";
		if(arg0.getActionCommand().equals("5"))napis += "5";
		if(arg0.getActionCommand().equals("6"))napis += "6";
		if(arg0.getActionCommand().equals("7"))napis += "7";
		if(arg0.getActionCommand().equals("8"))napis += "8";
		if(arg0.getActionCommand().equals("9"))napis += "9";
		if(arg0.getActionCommand().equals("0"))napis += "0";
		if(arg0.getActionCommand().equals("c")) {napis="";napis2="";}
		if(arg0.getActionCommand().equals("+"))napis += "+";
		if(arg0.getActionCommand().equals("-"))napis += "-";
		if(arg0.getActionCommand().equals("*"))napis += "*";
		if(arg0.getActionCommand().equals("/"))napis += "/";
		if(arg0.getActionCommand().equals("("))napis += "(";
		if(arg0.getActionCommand().equals(")"))napis += ")";
		if(arg0.getActionCommand().equals("=")) 
		{
			if(napis2=="zle dane")napis="zle dane";
			else 
			{
				try
				{
					napis2=dzialanie(napis);
					napis=""+((int)wartosc_d.parseDouble(napis2));
				}
				catch (Exception e)
				{
					napis ="zle dane";
				}
			}
		}
		text_wynik.setText(napis);
		text_double.setText(napis2);
		pasek.setValue(pasek.getValue()+1);
		if(pasek.getValue() == 50)System.exit(0);
		
	}
	
}
