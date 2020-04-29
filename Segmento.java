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
        String aux=primeiro.nome;
        tamanho--;
        return aux;   
    }
    public void addMeio(int posicao,String nome){
        if(posicao<=0){
            addInicio(nome);
        }else if(posicao>=tamanho){
            addFim(nome);
        }else{
            Segmento aux=primeiro;
            for(int i=0;i<posicao-1;i++){
                aux=aux.proximo;
            }
            Segmento segmento=new Segmento();
            segmento.nome=nome;
            segmento.proximo=segmento;
            tamanho++;
        }
    }

    public String removeMeio(int posicao){
        if(tamanho==0 || posicao>tamanho){
            return null;
        }else if(posicao==0){
            return removeInicio();
        }else if(posicao==tamanho-1){
            return removeFim();
        }else{
            Segmento aux=primeiro;
            for(int i=0;i<posicao-1;i++){
                aux=aux.proximo;
            }
            String nome=aux.proximo.nome;
            aux.proximo=aux.proximo.proximo;
            tamanho--;
            return nome;
        }
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
    public String removeFim(){
        if(primeiro==null){
            return null;
        }
        Segmento aux=primeiro;
        while(aux.proximo!=null){
            aux=aux.proximo;
            if(aux.proximo==null){
                tamanho--;
                return aux.nome;
            }
        }
        primeiro=null;
        tamanho--;
        return aux.nome;
    }
    @Override
    public String toString(){
        String compilado="";
        Segmento aux=primeiro;
        while(aux!=null){
            compilado+=aux.nome+",";
            aux=aux.proximo;
        }
        return compilado;
    }
}