package Trab2;

public class Segmento {
    Segmento primeiro=null;
    String nome;
    Segmento proximo;
    int tamanho=0;

    public void addInicio(String nome){
        Segmento segmento = new Segmento();
        segmento.nome=nome; 
        segmento.proximo=primeiro;
        primeiro=segmento;
        tamanho++;
    }
    public String removeInicio(){
        if(primeiro==null){
            return "Lista vazia";
        }
        String nomeAux=primeiro.nome;
        tamanho--;
        return nomeAux;   
    }
    public void addFim(String nome){
        Segmento segmento = new Segmento();
        segmento.nome=nome;
        Segmento aux=primeiro;
        if(primeiro==null){
            addInicio(nome);
        }else{
            while(aux.proximo!=null){
                aux=aux.proximo;
            }
            aux.proximo=segmento;
            segmento.proximo=null;
            tamanho++;
        }
    }
}