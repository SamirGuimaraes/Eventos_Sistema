package view;

/* 
 * java.awt.EventQueue - Pacote necessário para agendar e gerenciar eventos da interface gráfica.
 * java.awt.Font - Pacote para manipular e configurar diferentes fontes de texto na interface gráfica.
 * java.awt.event.ActionEvent - Pacote para tratar eventos de ações do usuário, como cliques de botão.
 * java.awt.event.ActionListener - Interface que permite a implementação de classes que reagem a eventos de ação.
 * java.util.ArrayList - Pacote para trabalhar com listas dinâmicas de objetos.
 * javax.swing.JButton - Pacote para criar botões na interface gráfica.
 * javax.swing.JComboBox - Pacote para criar caixas de seleção suspensas na interface gráfica.
 * javax.swing.JFrame - Pacote para criar a janela principal da interface gráfica.
 * javax.swing.JLabel - Pacote para criar rótulos de texto na interface gráfica.
 * javax.swing.JOptionPane - Pacote para exibir caixas de diálogo para mensagens e interações com o usuário.
 * javax.swing.JScrollPane - Pacote para adicionar barras de rolagem a componentes da interface.
 * javax.swing.JTable - Pacote para criar tabelas para exibição de dados tabulares.
 * javax.swing.table.DefaultTableModel - Pacote para definir o modelo de dados para tabelas.
 * javax.swing.JSeparator - Pacote para inserir separadores visuais horizontais e verticais.
 * javax.swing.SwingConstants - Pacote para definir alinhamento e posicionamento de componentes em layouts.
 * model.aluno - Importa a classe personalizada 'aluno' do pacote 'model', representando a entidade 'aluno'.
 * ExemploGUI - Classe principal que implementa uma interface gráfica para manipular e exibir dados relacionados.
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import model.aluno;

/**
 * Classe que representa a interface gráfica de cadastro de participantes.
 * Permite ao atendente cadastrar os alunos nos eventos
 * Os participantes cadastrados são exibidos em uma tabela.
 * 
 * @author [Davi Justino]
 * @since [27/12]
 */
public class ParticipanteGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    /** Janela principal da aplicação. */
    public JFrame frame;

    /** Modelo da tabela que armazena os dados dos participantes. */
    private DefaultTableModel model;

    /** Tabela que exibe os participantes cadastrados. */
    private JTable table;

    /** Barra de rolagem para a tabela. */
    private JScrollPane barraScroll;

    /** Botão para adicionar um participante. */
    private JButton adicionar;

    /** Campo de texto para entrada do nome do participante. */
    private JTextField name;

    /** Campo de texto para entrada da matrícula do participante. */
    private JTextField matricula;

    /** Campo de texto para entrada do curso do participante. */
    private JTextField curso;

    /** Índice que representa o número total de participantes cadastrados. */
    int index = 0;
    
    /** Lista de opções de eventos: Necessário para conseguir pegar o item na lista de opções(Se não vai ter problema de escopo)*/
    private JComboBox<String> eventoOpcoes; 

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
                    ParticipanteGUI painelCadastro = new ParticipanteGUI();
                    painelCadastro.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Construtor da classe ParticipanteGUI.
     * Inicializa os componentes da interface gráfica e configurando os componentes da tela de cadastro e seus eventos associados(botões).
     */
    public ParticipanteGUI() {
        frame = new JFrame("Cadastro de Participantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(755, 475);
        frame.setLocationRelativeTo(null); 

        String[] columnNames = { "Index", "Nome", "Matrícula", "Curso", "Evento" };
        Object[][] data = {};
        model = new DefaultTableModel(data, columnNames);

        frame.getContentPane().setLayout(null);

        barraScroll = new JScrollPane();
        barraScroll.setBounds(374, 66, 343, 362);
        frame.getContentPane().add(barraScroll);

        table = new JTable(model);
        barraScroll.setViewportView(table);

        JLabel cadastroLabel = new JLabel("Cadastro");
        cadastroLabel.setBounds(109, 10, 105, 35);
        cadastroLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        frame.getContentPane().add(cadastroLabel);

        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setBounds(10, 54, 64, 28);
        nomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
        frame.getContentPane().add(nomeLabel);

        name = new JTextField();
        name.setBounds(10, 91, 312, 28);
        name.setFont(new Font("Arial", Font.PLAIN, 16));
        name.setColumns(10);
        frame.getContentPane().add(name);

        JLabel matriculaLabel = new JLabel("Matrícula");
        matriculaLabel.setBounds(10, 129, 83, 28);
        matriculaLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
        frame.getContentPane().add(matriculaLabel);

        matricula = new JTextField();
        matricula.setBounds(10, 167, 312, 28);
        matricula.setFont(new Font("Arial", Font.PLAIN, 16));
        matricula.setColumns(10);
        frame.getContentPane().add(matricula);

        JLabel cursoLabel = new JLabel("Curso");
        cursoLabel.setBounds(10, 205, 83, 28);
        cursoLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
        frame.getContentPane().add(cursoLabel);

        curso = new JTextField();
        curso.setBounds(10, 243, 312, 28);
        curso.setFont(new Font("Arial", Font.PLAIN, 16));
        curso.setColumns(10);
        frame.getContentPane().add(curso);

        JLabel eventoDesejado = new JLabel("Evento Desejado");
        eventoDesejado.setBounds(10, 281, 204, 28);
        eventoDesejado.setFont(new Font("Times New Roman", Font.BOLD, 19));
        frame.getContentPane().add(eventoDesejado);

        String[] opcoesDoEventos = { "Semana do IME", "SEMIC", "Semanas de Extensão", "Palestra de IA e seus desafios" };
        eventoOpcoes = new JComboBox<>(opcoesDoEventos);
        eventoOpcoes.setBounds(10, 313, 312, 35);
        eventoOpcoes.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.getContentPane().add(eventoOpcoes);

        JButton limpar = new JButton("Limpar");
        limpar.setBounds(10, 388, 146, 40);
        limpar.setFont(new Font("SansSerif", Font.BOLD, 19));
        frame.getContentPane().add(limpar);

        limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                matricula.setText("");
                curso.setText("");
            }
        });

        JLabel cadastradosLabel = new JLabel("Cadastrados");
        cadastradosLabel.setBounds(467, 10, 146, 35);
        cadastradosLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        frame.getContentPane().add(cadastradosLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(351, 10, 2, 428);
        separator.setOrientation(SwingConstants.VERTICAL);
        frame.getContentPane().add(separator);

        adicionar = new JButton("Adicionar");
        adicionar.setBounds(183, 388, 146, 40);
        adicionar.setFont(new Font("SansSerif", Font.BOLD, 19));
        adicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               cadastrar();
            }
        });

        frame.getContentPane().add(adicionar);
        frame.setVisible(true);
    }
    /**
     * Retorna o evento selecionado no JComboBox.
     * 
     * @return o evento selecionado como String
     */
    public String eventoSelecionado() {
        return (String) eventoOpcoes.getSelectedItem();
    }

    /**
     * Realiza o cadastro do participante, se estiver de acordo com os critérios
     */
    public void cadastrar() {
        ArrayList<aluno> alunos = new ArrayList<>();
        String eventos = eventoSelecionado(); 
        String nomes = name.getText().trim();
        String matriculas = matricula.getText().trim();
        String cursos = curso.getText().trim();

        if (!nomes.matches("[a-zA-Z\\s]+") || nomes.isEmpty()) {
        	  JOptionPane.showMessageDialog(
                      null,
                      "O nome digitado: " + nomes + "\nNão é válido. O nome deve conter apenas letras e não pode ser vazio.",
                      "Erro no Nome",
                      JOptionPane.ERROR_MESSAGE
                  );            return;
        }

        if (!matriculas.matches("\\d{3,}")) {
        	  JOptionPane.showMessageDialog(
                      null,
                      "A matrícula digitada: " + matriculas + "\nNão é válida. A matrícula deve conter apenas números e no mínimo 3 dígitos.",
                      "Erro na Matrícula",
                      JOptionPane.ERROR_MESSAGE
                  );            return;
        }

        if (!cursos.matches("[a-zA-Z\\s]+") || cursos.isEmpty()) {
        	JOptionPane.showMessageDialog(
                    null,
                    "O curso digitado: " + cursos + "\nNão é válido. O curso deve conter apenas letras e não pode ser vazio.",
                    "Erro no Curso",
                    JOptionPane.ERROR_MESSAGE
                );	            return;
        }

        aluno novoAluno = new aluno(index++, nomes, matriculas, cursos, eventos);
        alunos.add(novoAluno);

        Object[] dados = { novoAluno.getIndex(), novoAluno.getNome(), novoAluno.getMatricula(), novoAluno.getCurso(), novoAluno.getEvento() };
        model.addRow(dados);

        JOptionPane.showMessageDialog(null, "DADOS CADASTRADOS COM SUCESSO!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}

