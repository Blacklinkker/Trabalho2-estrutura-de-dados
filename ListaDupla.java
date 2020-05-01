package LD;
//importa biblioteca para exibição de caixas de dialogo
import javax.swing.*;
public class ListaDupla {
    public static void main(String[] args) {
        //Instanciação da lista duplamente encadeada
        Segmento2 listadupla=new Segmento2();

        //chamada dos metodos de adição
        listadupla.addInicio("Von neumann"); //adiciona no inicio
        listadupla.addFim("Alan turing"); //adiciona no fim
        listadupla.addMeio(1,"Linus torvalds"); //adiciona no meio
        
        //exibição da lista
        JOptionPane.showMessageDialog(null, "Lista:"+listadupla.toString());

        //chamada dos metodos de remoção
        JOptionPane.showMessageDialog(null,listadupla.removeMeio(1)); //remove no meio
        JOptionPane.showMessageDialog(null,listadupla.removeInicio()); //remove no inicio
        JOptionPane.showMessageDialog(null,listadupla.removeFim()); //remove no fim
    }
}
