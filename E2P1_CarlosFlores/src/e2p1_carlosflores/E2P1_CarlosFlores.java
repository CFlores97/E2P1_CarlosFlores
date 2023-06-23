package e2p1_carlosflores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class E2P1_CarlosFlores extends JFrame implements ActionListener {

    private JButton case1;
    private JButton case2;
    private JButton case3;
    private JLabel welcome;

    ArrayList<Integer> resultados = new ArrayList<>();

    public E2P1_CarlosFlores() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Menu");
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel canvas = new JPanel();
        canvas.setLayout(null);
        canvas.setBackground(Color.BLACK);

        welcome = new JLabel("Examen 2"); // titulo
        welcome.setBounds(200, 10, getWidth(), 30); // hasta donde se escribe
        welcome.setFont(new Font("Serif", Font.BOLD, 20)); // font
        welcome.setForeground(Color.WHITE); // color del font

        // case 1
        case1 = new JButton("Numeros");
        case1.setBounds(100, 100, 100, 50);
        case1.addActionListener(this);

        //case 2
        case2 = new JButton("Operaciones");
        case2.setBounds(100, 200, 100, 50);
        case2.addActionListener(this);

        //case 3
        case3 = new JButton("Salir");
        case3.setBounds(100, 300, 100, 50);
        case3.addActionListener(this);

        canvas.add(welcome); // agrega objetos al canvas
        canvas.add(case1);
        canvas.add(case2);
        canvas.add(case3);

        add(canvas); // agrega el canvas
        validate();

    }

    public static void main(String[] args) {
        new E2P1_CarlosFlores();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == case1) {
            int op = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Agregar un numero\n2. Eliminar un numero\n3. Menu principal", "Submenu", JOptionPane.INFORMATION_MESSAGE));
            switch (op) {
                case 1:
                    int valor_decimal = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un valor decimal"));
                    //TODO: validar que el valor decimal sea mayor a 1 
                    int valor_base = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la base"));
                    //TODO: validar que el valor de la base este entre 2 y 35

                    Numero numero = new Numero(valor_base, valor_decimal);

                    System.out.println(numero.decToBase(valor_decimal));
                    //System.out.println(numero.baseToDec(numero.decToBase(valor_decimal)));

                    break;
                case 2:
                    //TODO: Eliminar numero

                    break;
                case 3:

                    break;

                default:
                    break;
            }

        } else if (event.getSource() == case2) {
            int op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Sumar numeros\n2. Restar numeros\n3. Multiplicar numeros\n4. Menu principal", "Menu operaciones", JOptionPane.INFORMATION_MESSAGE));
            switch(op2){
                case 1:
                    //TODO: sumar numeros
                    break;
                case 2:
                    //TODO: restar numeros
                    break;
                case 3:
                    //TODO: multiplicar numeros
                    break;
                case 4:
                    break;
            }

        } else if (event.getSource() == case3) {
            System.exit(0);
        }
    }

}
