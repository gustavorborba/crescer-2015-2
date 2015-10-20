
/**
 * Write a description of class IrishDwarf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IrishDwarf extends Dwarf
{

    
    public IrishDwarf(String novoNome){
        super(novoNome);
       
    }
    public IrishDwarf(String novoNome,DataTerceiraEra data){
        super(novoNome,data);
    }
   
    public void tentarSorte(){
        if(getNumeroSorte()==-3333.0){
            for(int i=0;i<inventario.getTamanhoArray();i++){
                inventario.getItemEspecifico(i).lepreSortudo();
            }
        }
    }
}
