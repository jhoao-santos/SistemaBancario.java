package sistemabancario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Criando o JFrame (Janela principal)
        JFrame frame = new JFrame("Sistema Bancário");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definindo layout e painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        frame.add(panel);

        // Criando as contas
        Cliente fulano = new Cliente();
        fulano.nome = "Fulano";
        fulano.cpf = "01234567890";

        Conta contaFulano = new Conta();
        contaFulano.titular = fulano;
        contaFulano.numero = 1000;
        contaFulano.saldo = 50;

        Cliente cicrano = new Cliente();
        cicrano.nome = "Cicrano";
        cicrano.cpf = "09876543210";

        Conta contaCicrano = new Conta();
        contaCicrano.titular = cicrano;
        contaCicrano.numero = 2000;
        contaCicrano.saldo = 0;

        Banco sistemaBancario = new Banco();

        // Criando componentes da interface gráfica
        JLabel titleLabel = new JLabel("Sistema Bancário");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        JLabel saldoLabel = new JLabel("Saldo do Fulano: R$" + contaFulano.saldo);
        saldoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(saldoLabel, gbc);

        JButton depositarButton = new JButton("Depositar R$100");
        depositarButton.setBackground(Color.GREEN);
        depositarButton.setForeground(Color.WHITE);
        depositarButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(depositarButton, gbc);

        JButton sacarButton = new JButton("Sacar R$30");
        sacarButton.setBackground(Color.RED);
        sacarButton.setForeground(Color.WHITE);
        sacarButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(sacarButton, gbc);

        JButton transferirButton = new JButton("Transferir R$120 para Cicrano");
        transferirButton.setBackground(Color.ORANGE);
        transferirButton.setForeground(Color.WHITE);
        transferirButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(transferirButton, gbc);

        // Adicionando ações aos botões
        depositarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sistemaBancario.depositar(contaFulano, 100d);
                saldoLabel.setText("Saldo do Fulano: R$" + contaFulano.saldo);
            }
        });

        sacarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sistemaBancario.sacar(contaFulano, 30d);
                saldoLabel.setText("Saldo do Fulano: R$" + contaFulano.saldo);
            }
        });

        transferirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sistemaBancario.transferir(contaFulano, contaCicrano, 120d);
                saldoLabel.setText("Saldo do Fulano: R$" + contaFulano.saldo);
            }
        });

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
