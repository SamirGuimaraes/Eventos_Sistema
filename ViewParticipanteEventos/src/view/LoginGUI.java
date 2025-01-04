package view;

/* 
 * java.awt.EventQueue - Pacote necessário para agendar e gerenciar eventos da interface gráfica.
 * java.awt.Font - Pacote para manipular e configurar diferentes fontes de texto na interface gráfica.
 * java.awt.event.ActionEvent - Pacote para tratar eventos de ações do usuário, como cliques de botão.
 * java.awt.event.ActionListener - Interface que permite a implementação de classes que reagem a eventos de ação.
 * javax.swing.JButton - Pacote para criar botões na interface gráfica.
 * javax.swing.JFrame - Pacote para criar a janela principal da interface gráfica.
 * javax.swing.JLabel - Pacote para criar rótulos de texto na interface gráfica.
 * javax.swing.JOptionPane - Pacote para exibir caixas de diálogo para mensagens e interações com o usuário.
 * javax.swing.JTextField - Pacote para criar campos de texto de entrada.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Classe que representa a interface gráfica de login do sistema.
 * Esta classe permite que o usuário insira seu login e senha para acessar a próxima tela.
 * 
 * @author Davi Justino
 * @since 24/12/2020
 */
public class LoginGUI extends JFrame {

	

	/**
	 * Método principal que inicia a aplicação.
	 * Cria uma nova instância da tela de login e a torna visível.
	 *
	 * O campo {@code senha} é um JTextField onde o usuário insere sua senha.
	 *
	 * @param args argumentos da linha de comando (não utilizados)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * O campo {@code login} é um JTextField onde o usuário insere seu nome de usuário.
	 */
	private JTextField login;

	/**
	 * O campo {@code senha} é um JTextField onde o usuário insere sua senha.
	 */
	private JTextField senha;
	
	   /**
     * Método principal que inicia a aplicação.
     * Cria uma instância da classe e torna a interface gráfica visível.
     * 
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginGUI frame = new LoginGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Método que verifica as credenciais de login, verifica o login e a senha, caso sejam válidas, o atendente consiguirá seguir no processo de cadastro
     * Caso contrário, exibe uma mensagem de erro.
     */
    public void proximaTela() {
        if (login.getText().equals("aluno")) {
            if (senha.getText().equals("2024")) {
                this.dispose();
                ParticipanteGUI window = new ParticipanteGUI();
                window.frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Senha digitada: " + senha.getText() + "\nNão é válida.",
                    "Erro na senha",
                    JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Login digitado: " + login.getText() + "\nNão é válido.",
                "Erro no login",
                JOptionPane.ERROR_MESSAGE);
        }
    };
    /**
     * Método que limpa os seguintes campos: login e senha 
     * 
     */
    public void limparCampoDeTexto() {
    	login.setText("");
    	senha.setText("");
    }
    /**
     * Parte visual da classe LoginGUI.
     * Inicializa a interface gráfica, configurando os componentes da tela de login e adicionando ações para os botões, caso sejam clicados.
     */
    public LoginGUI() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
	setLocationRelativeTo(null); 

        JLabel senhaLabel = new JLabel("Senha");
        senhaLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
        senhaLabel.setBounds(20, 102, 98, 41);
        getContentPane().add(senhaLabel);

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
        loginLabel.setBounds(20, 10, 98, 41);
        getContentPane().add(loginLabel);

        login = new JTextField();
        login.setText("Digite seu login");
        login.setToolTipText("");
        login.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        login.setBounds(20, 54, 387, 41);
        getContentPane().add(login);
        login.setColumns(10);

        senha = new JTextField();
        senha.setText("Digite a sua senha");
        senha.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        senha.setColumns(10);
        senha.setBounds(20, 153, 387, 41);
        getContentPane().add(senha);

        JButton limpar = new JButton("Limpar");
        limpar.setFont(new Font("Arial", Font.BOLD, 20));
        limpar.setBounds(20, 212, 156, 41);
        getContentPane().add(limpar);

        limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	limparCampoDeTexto();
            }
        });

        JButton entrar = new JButton("Entrar");
        entrar.setFont(new Font("Arial", Font.BOLD, 20));
        entrar.setBounds(232, 212, 156, 41);
        getContentPane().add(entrar);
        entrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                proximaTela();
            }
        });
    }
}
