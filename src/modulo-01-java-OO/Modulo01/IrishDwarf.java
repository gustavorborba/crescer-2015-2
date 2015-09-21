
/**
 * Write a description of class IrishDwarf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IrishDwarf extends Dwarf
{
    public IrishDwarf(){}
    
    public IrishDwarf(String novoNome){

    }
    public IrishDwarf(String novoNome,DataTerceiraEra data){
    }
   
    public void tentarSorte(){
        if(getNumeroSorte()==-3333.0){
            for(int i=0;i<inventario.getTamanhoArray();i++){
                inventario.getItemEspecifico(i).lepreSortudo();
            }
        }
    }
}
