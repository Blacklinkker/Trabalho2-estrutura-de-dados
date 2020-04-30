package LD;

public class Segmento2 {
    String dado;
    Segmento2 header;
    Segmento2 fim;
    Segmento2 proximo;
    Segmento2 anterior;
    int tamanho;

    
    public void addInicio(String dado){
        Segmento2 segmento = new Segmento2();
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
            Segmento2 aux=header;
            for(int i=0;i<posicao-1;i++){
                aux=aux.proximo;
            }
            Segmento2 segmento=new Segmento2();
            segmento.dado=dado;
            segmento.proximo=aux.proximo;
            segmento.anterior=aux;
            aux.proximo=segmento;
            segmento.proximo.anterior=segmento;
            tamanho++;
        }
    }
}