package conversor_de_moneda;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import javax.swing.JTextPane;

public class Menu_inicial extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_monto;
	private JButton btn_convertir;
	Choice opcionesMoneda = new Choice();
	private JTextPane monedaConvertida;
	
	int dolar = 4000;
	int euro =  4340;
	int libras = 5000;
	int yen = 28;
	int won = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_inicial frame = new Menu_inicial();
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
	public Menu_inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Conversor de moneda");
		setLocationRelativeTo(null);
		setResizable(false);
		
		componentes();
	
	}
		
	private void componentes() {
		JLabel lblNewLabel = new JLabel("Ingrese el monto de dinero que desea convertir  (sin . ni ,):");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(52, 26, 347, 28);
		contentPane.add(lblNewLabel);
		
		txt_monto = new JTextField();
		txt_monto.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txt_monto.setBounds(122, 65, 187, 20);
		contentPane.add(txt_monto);
		txt_monto.setColumns(10);
		txt_monto.addActionListener(this);
		
		btn_convertir = new JButton("Convertir");
		btn_convertir.setBackground(new Color(192, 192, 192));
		btn_convertir.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btn_convertir.setBounds(138, 195, 157, 23);
		contentPane.add(btn_convertir);
		btn_convertir.addActionListener(this);
		
		operaciones();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn_convertir) {
			String monto_Convertir = txt_monto.getText();
	        String monedaSeleccionada = opcionesMoneda.getSelectedItem();

	        int monto = Integer.parseInt(monto_Convertir);

	        int resultadoConversion = realizarConversion(monedaSeleccionada, monto);
	        monedaConvertida.setText("Tu monto equivale a: " + resultadoConversion);
		}
		
	}
	
	private int realizarConversion(String monedaSeleccionada, int monto) {
	    switch (monedaSeleccionada) {
	        case "COP a Dolares":
	            return monto / dolar;
	        case "COP a Euros":
	            return monto / euro;
	        case "COP a Libras esterlinas":
	            return monto / libras;
	        case "COP a Yen Japones":
	            return monto / yen;
	        case "COP a Won sul-coreano":
	            return monto / won;
	        case "Dolares a COP":
	            return monto * dolar;
	        case "Euros a COP":
	            return monto * euro;
	        case "Libras esterlinas a COP":
	            return monto * libras;
	        case "Yen Japones a COP":
	            return monto * yen;
	        case "Won sul-coreano a COP":
	            return monto * won;
	        
	        default:
	            return 0; 
	    }
	}


	public void operaciones() {
		opcionesMoneda.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		opcionesMoneda.setBounds(122, 150, 187, 20);
		contentPane.add(opcionesMoneda);
		
		opcionesMoneda.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					//String monedaSelec = opcionesMoneda.getSelectedItem();
				} 
				
			}
		});
		
		monedaConvertida = new JTextPane();
		monedaConvertida.setText("Tu monto equivale a :");
		monedaConvertida.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 15));
		
		monedaConvertida.setBounds(122, 238, 187, 62);
		contentPane.add(monedaConvertida);
		
		JLabel lblNewLabel_1 = new JLabel("Selcciona el tipo de conversion:");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel_1.setBounds(122, 107, 195, 14);
		contentPane.add(lblNewLabel_1);
		opcionesMoneda.add("COP a Dolares");
		opcionesMoneda.add("COP a Euros");
		opcionesMoneda.add("COP a Libras esterlinas");
		opcionesMoneda.add("COP a Yen Japones");
		opcionesMoneda.add("COP a Won sul-coreano");
		opcionesMoneda.add("Dolares a COP");
		opcionesMoneda.add("Euros a COP");
		opcionesMoneda.add("Libras Esterlinas a COP");
		opcionesMoneda.add("Yen Japones a COP");
		opcionesMoneda.add("Won sul-coreano a COP");
		
	}
}
