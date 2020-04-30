package LD;

public class Segmento {
    String dado;
    Segmento header;
    Segmento fim;
    Segmento proximo;
    Segmento anterior;
    int tamanho;

    
    public void addInicio(String dado){
        Segmento segmento = new Segmento();
        segmento.dado=dado; 
        segmento.proximo=header;
        segmento.header=segmento;
        if(header==null){
            header=segmento;
            fim=header;
            tamanho++;
        }else{
            header.anterior=segmento;
            tamanho++;
        }
        
    }

    public void addMeio(int posicao,String dado){
        if(posicao<=0){
            addInicio(dado);
        }else if(posicao>=tamanho){
            addFim(dado);
        }else{
            Segmento aux=header;
            for(int i=0;i<posicao-1;i++){
                aux=aux.proximo;
            }
            Segmento segmento=new Segmento();
            segmento.dado=dado;
            segmento.proximo=aux.proximo;
            segmento.anterior=aux;
            aux.proximo=segmento;
            segmento.proximo.anterior=segmento;
            tamanho++;
        }
    }
}