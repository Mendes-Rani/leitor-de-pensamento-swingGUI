/**
 * O código abaixo é uma implementação de um jogo de adivinhação em Java utilizando a biblioteca Swing para criar a interface gráfica do usuário (GUI).
 * O jogo consiste em o usuário tentar adivinhar um número aleatório gerado pelo programa, que está entre 1 e 10.
 * O usuário insere seu palpite usando um JSpinner, e ao clicar no botão "btnClick",
 * o programa compara o palpite do usuário com o número gerado e exibe uma mensagem indicando se o usuário acertou ou errou, juntamente com o número que o programa pensou.
 * A interface é configurada para ser simples e direta, com um JLabel para instruções e feedback, e um JSpinner para entrada do usuário.
 */

package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaGenio {
    private JButton btnClick;
    private JSpinner lblSpin;
    private JPanel painel;
    private JLabel lblFrase;

    public telaGenio() {
        lblSpin.setModel(new SpinnerNumberModel(1, 1, 10, 1)); //configura o modelo do spinner lblSpin para aceitar apenas numeros inteiros entre 1 e 10, com um passo de 1
        lblSpin.setBounds(50, 50, 50, 30); //configura a posicao e o tamanho do spinner lblSpin
        lblFrase.setText("<html> Advinhe o numero que estou pensando, entre 1 e 10 </html>"); //configura o texto do label lblFrase para a mensagem de instrução do jogo

        btnClick.addActionListener(new ActionListener() { //adiciona um listener para o botao btnClick, que sera acionado quando o usuario clicar no botao
            @Override //sobrescreve o metodo actionPerformed da interface ActionListener, que sera chamado quando o evento de clique ocorrer
            public void actionPerformed(ActionEvent e) {

                double n = 1 + Math.random() * (11 - 1); //gera um numero aleatorio entre 0 e 10, considerando o menor numero igual a 0, utilizando a formula para gerar numeros aleatorios em um intervalo: min + Math.random() * (max - min)
                //System.out.println(n); //imprime o numero gerado no console para fins de teste
                int valor = (int) n; //converte o numero gerado para inteiro, descartando a parte decimal, para que o numero fique entre 1 e 10, considerando o menor numero igual a 1
                //System.out.println(valor); //imprime o numero gerado convertido para inteiro no console para fins de teste

                int numDigitado = Integer.parseInt(lblSpin.getValue().toString()); //obtém o valor digitado no spinner lblSpin, converte para string e depois para inteiro, para comparar com o numero gerado

                String f1 = "<html> ACERTOU!! </html>";
                String f2 = "<html> ERROU!! O numero que pensei foi </html>" + valor;
                String resultado = (numDigitado == valor)?f1:f2; //se o numero digitado for igual ao numero gerado, resultado recebe a mensagem de acerto, senão resultado recebe a mensagem de erro com o numero que o programa pensou

                //metodo alternativo para evitar a repeticao de codigo, utilizando variaveis para armazenar as mensagens de acerto e erro, e depois utilizando o operador ternario para escolher qual mensagem exibir com base na comparação entre o numero digitado e o numero gerado
                //String resultado = (numDigitado == valor)?"<html> ACERTOU!! </html>":"<html> ERROU!! O numero que pensei foi " + valor + "</html>"; //se o numero digitado for igual ao numero gerado, resultado recebe a mensagem de acerto, senão resultado recebe a mensagem de erro com o numero que o programa pensou

                lblFrase.setFont(new Font("Arial Black", Font.PLAIN, 18)); //configura a fonte do label lblFrase para Arial Black, com estilo normal e tamanho 16
                lblFrase.setText(resultado); //configura o texto do label lblFrase para o resultado da comparação entre o numero digitado e o numero gerado, informando se o usuario acertou ou errou

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("telaGenio");
        frame.setContentPane(new telaGenio().painel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
