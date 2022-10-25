import javax.swing.*;
import java.awt.*;

public class  AgendaGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon boloImg = new ImageIcon("./src/imagens/boloImg.jpg");
    ImageIcon addImg = new ImageIcon("./src/imagens/addImg.jpg");
    ImageIcon removeImg = new ImageIcon("./src/imagens/removeImg.jpg");
    JButton botaoAdicionar, botaoPesquisar, botaoRemover;
    Agenda agenda = new AgendaPOO();
    JMenuBar barraDeMenu = new JMenuBar();


    public AgendaGUI(){
        setTitle("Agenda de Aniversários");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);

        linha1 = new JLabel("Minha Agenda de Aniversários", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        
        linha2 = new JLabel(boloImg, JLabel.CENTER);
        botaoAdicionar = new JButton("Adicionar", addImg);
        botaoAdicionar.addActionListener(new AgendaAddController(agenda, this));
        botaoRemover = new JButton("Remover", removeImg);
        botaoRemover.addActionListener(new AgendaRemoveController(agenda, this));
        
        getContentPane().setLayout(new GridLayout(2,2));
        getContentPane().add(linha1);
        getContentPane().add(botaoAdicionar);
        getContentPane().add(linha2);
        getContentPane().add(botaoRemover);
        

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarAniversariante = new JMenuItem("Pesquisar Aniversariante");
        menuPesquisar.add(menuPesquisarAniversariante);
        menuPesquisarAniversariante.addActionListener(new AgendaSearchController(agenda, this));
        
        barraDeMenu.add(menuPesquisar);
        setJMenuBar(barraDeMenu);

    }

    public static void main(String[] args) {
        JFrame janela = new AgendaGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}