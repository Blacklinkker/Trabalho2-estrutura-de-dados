package Trab2;
//biblioteca que fornece janelas de mensgaem pré-montadas
import javax.swing.JOptionPane;

public class AtvA{
    public static void main(String[] args) {
        //lista do tipo segmento criada
        Segmento lista=new Segmento();
        int tamanho=0;
        //lista pre-preenchida para facilitar testes de inicio meio e fim
        lista.addInicio("John eckert");
        tamanho++;
        lista.addMeio(1,"Von neumann");
        tamanho++; 
        lista.addFim("Alan turing");
        tamanho++;
        lista.addFim("linus torvalds");
        tamanho++;
        
        JOptionPane.showMessageDialog(null,"Lista:"+lista.toString());
        JOptionPane.showMessageDialog(null,"removendo meio: "+lista.removeMeio(1));
        JOptionPane.showMessageDialog(null,"removendo inicio: "+lista.removeInicio());
        JOptionPane.showMessageDialog(null,"removendo fim:"+lista.removeFim());
        JOptionPane.showMessageDialog(null,"removendo meio:"+lista.removeMeio(1));
        

        
    }
}