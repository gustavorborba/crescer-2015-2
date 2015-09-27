import java.util.ArrayList;
class NoturnoEmUltimo extends EstrategiaPreparacao implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ultimoAtaque=new ArrayList<>();
    public NoturnoEmUltimo(){}
    public void atacar(ArrayList<Dwarf> anoesHorda,ArrayList<Elfo> elfosArmy){
        this.ultimoAtaque.clear();
        for(Elfo elfo : elfosArmy){
            if(eElfoVerde(elfo)){
                ultimoAtaque.add(elfo);
                    for(Dwarf anao : anoesHorda){
                         elfo.atirarFlecha(anao);
                        }
                    }
            }
        for(Elfo elfo : elfosArmy){
            if(eElfoNoturno(elfo)){
                ultimoAtaque.add(elfo);
                    for(Dwarf anao : anoesHorda){
                         elfo.atirarFlecha(anao);
                        }
                    }
                }
    }
    public ArrayList<Elfo> getUltimoAtaque(){
        return ultimoAtaque;
    }
}
