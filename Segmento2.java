package LD;

public class Segmento2 {
    //declarados os atributos dos segmentos
    String dado;
    //primeiro da lista
    Segmento2 header;
    Segmento2 fim;
    Segmento2 proximo;
    Segmento2 anterior;
    //contador para manter noção do tamanho
    int tamanho;

    //metodo para adicionar no incio
    public void addInicio(String dado){
        Segmento2 segmento = new Segmento2();
        //insere o dado no segmento e configura o proximo e anterior
        segmento.dado=dado; 
        segmento.proximo=header;
        segmento.header=segmento;
        //se nao houver inicio,o segmento sendo adicionado sera o inicio;
        if(header==null){
            header=segmento;
            fim=header;
            tamanho++;
        }else{
            //caso ja tiver inicio ele é atribuido como anterior ao inicio
            header.anterior=segmento;
            tamanho++;
        }
        
    }

    //metodo para adicionar no meio da lista utilizando posição
    public void addMeio(int posicao,String dado){
        //se a posição for o inicio, o metodo addInicio é reaproveitado
        if(posicao<=0){
            addInicio(dado);
        }else if(posicao>=tamanho){
            //se a posição for o fim,reaproveita o metodo addFim
            addFim(dado);
        }else{
            //segmento auxiliar para ajudar na navegação
            Segmento2 aux=header;
            //navega pela lista ate posição desejada
            for(int i=0;i<posicao-1;i++){
                aux=aux.proximo;
            }
            Segmento2 segmento=new Segmento2();
            //insere o dado no segmento e configura o proximo e anterior
            segmento.dado=dado;
            segmento.proximo=aux.proximo;
            segmento.anterior=aux;
            aux.proximo=segmento;
            segmento.proximo.anterior=segmento;
            tamanho++;
        }
    }
    public void addFim(String dado){
        Segmento2 segmento=new Segmento2();
        //insere o dado no segmento e configura o proximo e anterior
        segmento.dado=dado;
        segmento.proximo=null;
        segmento.anterior=fim;
        //declara quem é o fim
        if(fim!=null){
            fim.proximo=segmento;
        }
        fim=segmento;
        //se apenas um segmento na lista então ele e o inicio e fim
        if(tamanho==0){
            header=fim;
        }
        tamanho++;
    }

    //metodo para remover o inicio
    public String removeInicio(){
        //verifica se está vazio
        if(header==null){
            return null;
        }
        //cria uma string auxiliar para armazenar o dado
        String aux=header.dado;
        header=header.proximo;
        //altera quem é o primeiro da fila
        if(header!=null){
            //como nao ha ninguem antes do primeiro,a posição é nula
            header.anterior=null;
        }else{
            fim=null;
        }
        tamanho--;
        return "removendo:"+aux;
    }

    //metodo para remover no meio, utilizando posição especifica
    public String removeMeio(int posicao){
        //verifica posições
        if(posicao<=0 || posicao>=tamanho || header==null){
            //informa caso lista vazia ou posição que não existe
            return "Posição inexistente";
        }else if(posicao==0){
            //se for para remover no inicio, reutiliza metodo removeInicio
            removeInicio();
        }else if (posicao==tamanho-1){
            //se for um item no fim, reutiliza metodo removeFim
            removeFim();
        }
        //cria segmento auxiliar para ajudar na navegação
        Segmento2 aux=header;
        //navega pela lista
        for(int i=0;i<posicao;i++){
            aux=aux.proximo;
        }
        //se o anteriorfor nulo, é por que chegou no header
        if(aux.anterior!=null){
            aux.anterior.proximo=aux.proximo;
        }else if(aux.proximo!=null){
            //se proximo for nulo, chegou no fim da lista 
            aux.proximo.anterior=aux.anterior;
        }
        return "removendo:"+aux.dado+",na posição nº"+posicao;
    }

    //metodo para remover o ultimo item da lista
    public String removeFim(){
        //verifica se o fim existe
        if(fim==null){
            return "Não há";
        }
        //cria string para armazenar o dado temporariamente
        String aux=fim.dado;
        //altera qual o fim
        fim=fim.anterior;
        //por estar no fim,não ha um proximo item,logo ele é null
        if(fim!=null){
            fim.proximo=null;
        }else{
            header=null;
        }
        tamanho--;
        return "removendo:"+aux;
    }

    //override do metodo tostring para melhor organização
    @Override
    public String toString(){
        //personalização do metodo toString
        String compilado=" Tamanho:"+tamanho+"\n Itens:";
        Segmento2 aux=header;
        //navega pelos segmentos e adiciona na string
        while(aux!=null){
            compilado+=aux.dado+",";
            aux=aux.proximo;
        }
        return compilado;
    }
}
