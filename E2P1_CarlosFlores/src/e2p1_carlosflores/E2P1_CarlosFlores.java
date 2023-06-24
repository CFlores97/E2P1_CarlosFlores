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

    static ArrayList<Numero> numeros = new ArrayList<>();
    int c = 0; //verifica si se ha agregado algo a la lista

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
        welcome.setBounds(200, 10, getWidth(), 30); 
        welcome.setFont(new Font("Serif", Font.BOLD, 20)); 
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

                    while (valor_decimal <= 1) {
                        valor_decimal = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un valor decimal mayor que 1!"));
                    }

                    int valor_base = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la base"));

                    while (valor_base < 2 || valor_base > 35) {
                        valor_base = Integer.parseInt(JOptionPane.showInputDialog(null, "La base tiene que ser entre 2 y 35!"));
                    }

                    Numero numero = new Numero(valor_base, valor_decimal);
                    numeros.add(numero);

                    JOptionPane.showMessageDialog(null, "El resultado se ha agregado excitosamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    c++;
                    
                    break;
                case 2:
                    delNumList(numeros);
                    c--;

                    break;
                case 3:
                    //Sale al menu
                    break;

                default:
                    break;
            }

        } else if (event.getSource() == case2 && c != 0) {
            int op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Sumar numeros\n2. Restar numeros\n3. Multiplicar numeros\n4. Menu principal", "Menu operaciones", JOptionPane.INFORMATION_MESSAGE));
            switch (op2) {
                case 1:
                    sumNumList(numeros);
                    break;
                case 2:
                    subNumList(numeros);
                    break;
                case 3:
                    mulNumList(numeros);
                    break;
                case 4:
                    //Sale al menu
                    break;
            }

        } else if (event.getSource() == case3) {
            System.exit(0);
        }
    }

    public void delNumList(ArrayList<Numero> numeros) {
        String mess = "";

        for (Numero numero : numeros) {
            mess += numero.getNumero() + " base " + numero.getBase() + ": " + numero.baseToDec(numero.getNumero()) + "\n";
        }

        int sel_num = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIngrese el indice que desea eliminar", "Lista de numeros", JOptionPane.INFORMATION_MESSAGE));

        while (sel_num  > numeros.size() || sel_num < 1){
            sel_num = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIndice fuera de alcance!", "Lista de numeros", JOptionPane.ERROR_MESSAGE));
        }
        
        numeros.remove(sel_num - 1);

        JOptionPane.showMessageDialog(null, "El elemento se ha eliminado exitosamente!", "Eliminado", JOptionPane.INFORMATION_MESSAGE);

    }

    public void sumNumList(ArrayList<Numero> numeros) {
        String mess = "";
        Numero result;

        for (Numero numero : numeros) {
            mess += numero.getNumero() + " base " + numero.getBase() + ": " + numero.baseToDec(numero.getNumero()) + "\n";
        }

        int first_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIngrese el primer indice a sumar", "Lista de numeros", JOptionPane.INFORMATION_MESSAGE));
        while (first_op  > numeros.size() || first_op < 1){
            first_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIndice fuera de alcance, intente nuevamente", "Lista de numeros", JOptionPane.ERROR_MESSAGE));
        }
        int sec_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIngrese el segundo indice a sumar", "Lista de numeros", JOptionPane.INFORMATION_MESSAGE));
        while (sec_op > numeros.size() || sec_op < 1){
            sec_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIndice fuera de alcance, intente nuevamente", "Lista de numeros", JOptionPane.ERROR_MESSAGE));
        }

        int x = numeros.get(first_op - 1).baseToDec(numeros.get(first_op - 1).getNumero());
        int y = numeros.get(sec_op - 1).baseToDec(numeros.get(sec_op - 1).getNumero());

        int numRes = x + y;

        int a = numeros.get(first_op - 1).getBase();
        int b = numeros.get(sec_op - 1).getBase();

        if (a >= b) {
            result = new Numero(a, numRes);
        } else {
            result = new Numero(b, numRes);
        }

        JOptionPane.showMessageDialog(null, "El resultado es: " + result.getNumero() + " base " + result.getBase() + ": " + result.baseToDec(result.getNumero()), "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    public void subNumList(ArrayList<Numero> numeros) {
        String mess = "";
        Numero result;
        int numRes = 0;
        boolean positive = false;

        for (Numero numero : numeros) {
            mess += numero.getNumero() + " base " + numero.getBase() + ": " + numero.baseToDec(numero.getNumero()) + "\n";
        }

        int first_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIngrese el primer indice a restar", "Lista de numeros", JOptionPane.INFORMATION_MESSAGE));
        
        while (first_op  > numeros.size() || first_op < 1){
            first_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIndice fuera de alcance, intente nuevamente", "Lista de numeros", JOptionPane.ERROR_MESSAGE));
        }
        
        int sec_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIngrese el segundo indice a restar", "Lista de numeros", JOptionPane.INFORMATION_MESSAGE));

        while (sec_op  > numeros.size() || sec_op < 1){
            sec_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIndice fuera de alcance, intente nuevamente", "Lista de numeros", JOptionPane.ERROR_MESSAGE));
        }
        
        int x = numeros.get(first_op - 1).baseToDec(numeros.get(first_op - 1).getNumero());
        int y = numeros.get(sec_op - 1).baseToDec(numeros.get(sec_op - 1).getNumero());

        if (x > y) {
            positive = true;
            numRes = x - y;
        } else if (y > x) {
            JOptionPane.showMessageDialog(null, "El valor es negatvo!", "resultado", JOptionPane.INFORMATION_MESSAGE);
        }

        int a = numeros.get(first_op - 1).getBase();
        int b = numeros.get(sec_op - 1).getBase();

        if (a >= b) {
            result = new Numero(a, numRes);
        } else {
            result = new Numero(b, numRes);
        }

        if(positive){
            JOptionPane.showMessageDialog(null, "El resultado es: " + result.getNumero() + " base " + result.getBase() + ": " + result.baseToDec(result.getNumero()), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
        

    }
    
    public void mulNumList(ArrayList<Numero> numeros){
        String mess = "";
        Numero result;
        int numRes = 0;

        for (Numero numero : numeros) {
            mess += numero.getNumero() + " base " + numero.getBase() + ": " + numero.baseToDec(numero.getNumero()) + "\n";
        }

        int first_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIngrese el primer indice a multiplicar", "Lista de numeros", JOptionPane.INFORMATION_MESSAGE));
        
        while (first_op  > numeros.size() || first_op < 1){
            first_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIndice fuera de alcance, intente nuevamente", "Lista de numeros", JOptionPane.ERROR_MESSAGE));
        }
        
        int sec_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIngrese el segundo indice a multiplicar", "Lista de numeros", JOptionPane.INFORMATION_MESSAGE));

        while (sec_op  > numeros.size() || sec_op < 1){
            sec_op = Integer.parseInt(JOptionPane.showInputDialog(null, mess + "\nIndice fuera de alcance, intente nuevamente", "Lista de numeros", JOptionPane.ERROR_MESSAGE));
        }
        
        
        int x = numeros.get(first_op - 1).baseToDec(numeros.get(first_op - 1).getNumero());
        int y = numeros.get(sec_op - 1).baseToDec(numeros.get(sec_op - 1).getNumero());

        numRes = x*y;

        int a = numeros.get(first_op - 1).getBase();
        int b = numeros.get(sec_op - 1).getBase();

        if (a >= b) {
            result = new Numero(a, numRes);
        } else {
            result = new Numero(b, numRes);
        }

        JOptionPane.showMessageDialog(null, "El resultado es: " + result.getNumero() + " base " + result.getBase() + ": " + result.baseToDec(result.getNumero()), "Resultado", JOptionPane.INFORMATION_MESSAGE);

    }

}
