import java.util.ArrayList;
public class EstrategiaIntercalada extends EstrategiaPreparacao implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ultimoAtaque=new ArrayList<>();
    //-----------------                 //                  //                      //              -----------------
    //Estou trabalhando para desenvolver um codigo mais claro, assim que foi resolvido esse comentário será apagado
    //-----------------                 //                  //                      //              -----------------
    public int getMenorQuantidade(ArrayList<Elfo> elfosArmy){
        int quantidadeVerde=0,quantidadeNoturno=0;
            for(Elfo elfo : elfosArmy){
                if(eElfoVerde(elfo)){
                    quantidadeVerde++;
                }else{
                    quantidadeNoturno++;
                }
            }
            if(quantidadeVerde<=quantidadeNoturno){
                return quantidadeVerde;
            }else{
                return quantidadeNoturno;
            }
    }
    public ArrayList<Elfo> fazerOrdenacao(ArrayList<Elfo> elfosArmy){
        ArrayList<Elfo> verdes=new ArrayList<>();
        ArrayList<Elfo> noturnos=new ArrayList<>();
        ArrayList<Elfo> ordenados=new ArrayList<>();
        for(Elfo elfo : elfosArmy){
            if(eElfoVerde(elfo)){
                verdes.add(elfo);
            }else{
                noturnos.add(elfo);
            }
        }
        int menorQuantidade=getMenorQuantidade(elfosArmy);
        for(int i=0;i<menorQuantidade;i++){
            ordenados.add(verdes.get(i));
            ordenados.add(noturnos.get(i));
        }
        return ordenados;
    }
    public void atacar(ArrayList<Dwarf> anoesHorda,ArrayList<Elfo> elfosArmy){
        ultimoAtaque.clear();
        elfosArmy=fazerOrdenacao(elfosArmy);
        for(Elfo elfo : elfosArmy){
            for(Dwarf anao : anoesHorda){
                elfo.atirarFlecha(anao);
            }
            ultimoAtaque.add(elfo);
        }
    }
    public ArrayList<Elfo> getUltimoAtaque(){
        return ultimoAtaque;
    }
}
