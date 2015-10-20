

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste DwarfTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class DwarfTest
{
   @Test
   public void DwarfNasceCom110DeVida(){
       Dwarf gimli=new Dwarf("O");
       assertEquals(110,gimli.getVida(),0.00001);
    }
   @Test
    public void dwarfPerdeVidaSerFlechado(){
        Elfo elrond=new Elfo("Elrond");
        Dwarf gloin=new Dwarf("Gloin");
        elrond.atirarFlecha(gloin);
        assertEquals(100,gloin.getVida(),0.00001);
    }
    @Test
    public void dwarfNaoPerdeVidaSerFlechado(){
        Elfo elrond=new Elfo("Elrond");
        Dwarf gloin=new Dwarf("Gloin");
        elrond.atirarFlecha(gloin);
        assertEquals(100,gloin.getVida(),0.00001);
    }
    @Test
    public void dwarfPerdeVidasSempreQueAtacado(){
        Elfo elrond=new Elfo("Elrond");
        Dwarf gloin=new Dwarf("Gloin");
        elrond.atirarFlecha(gloin);
        assertEquals(100,gloin.getVida(),0.00001);
        elrond.atirarFlecha(gloin);
        elrond.atirarFlecha(gloin);
        assertEquals(80,gloin.getVida(),0.00001);
        
    }
    @Test
    public void dwarfMorreEm0DeVidaENaoTemVidaNegativa(){
        Elfo elf=new Elfo("Odin");
        Dwarf anao=new Dwarf("Gloin");
        for(int i=0;i<11;i++){
            elf.atirarFlecha(anao);
        }
        assertEquals(Status.MORTO,anao.getStatus());
        elf.atirarFlecha(anao);
        elf.atirarFlecha(anao);
        assertEquals(0,anao.getVida(),0.00001);
    }
    @Test
    public void DwarfNasceComNome(){
        Dwarf bifur=new Dwarf("Bifur");
        assertEquals("Bifur",bifur.getNome());
        assertNotSame("Odin",bifur.getNome());
    }
    @Test
    public void DwarfTemNumeroSorteValido(){
        DataTerceiraEra data=new DataTerceiraEra(1,1,2016);
        Dwarf bifur=new Dwarf("Bifur",data);
        Elfo elf=new Elfo("Jack");
        elf.atirarFlecha(bifur);
        elf.atirarFlecha(bifur);
        elf.atirarFlecha(bifur);
        assertEquals(-3333,bifur.getNumeroSorte(),0.0001);
    }
    @Test
    public void DwarfSeixasTemNumeroSorteValido(){
        DataTerceiraEra data=new DataTerceiraEra(1,1,2015);
        Dwarf bifur=new Dwarf("Seixas",data);
        assertEquals(33,bifur.getNumeroSorte(),0.0001);
    }
    @Test
    public void DwarfTemNumeroSorteValidoEGanhaExperiencia(){
        DataTerceiraEra data=new DataTerceiraEra(1,1,2016);
        Dwarf bifur=new Dwarf("Bifur",data);
        Elfo elf=new Elfo("Jack");
        elf.atirarFlecha(bifur);
        elf.atirarFlecha(bifur);
        elf.atirarFlecha(bifur);
        assertEquals(-3333,bifur.getNumeroSorte(),0.0001); //seu numero da sorte é menor que 0
        assertEquals(90,bifur.getVida(),0.00001);   //tem que possuir obrigatoriamente 90 de vida
        assertEquals(2,bifur.getExperiencia()); //e 2 pontos de experiencia
    }
    @Test
    public void DwarfSeixasAtacado(){
        DataTerceiraEra data=new DataTerceiraEra(1,1,2015);
        Dwarf bifur=new Dwarf("Seixas",data);
        Elfo johnny=new Elfo("Johnny");
        johnny.atirarFlecha(bifur);
        assertEquals(33,bifur.getNumeroSorte(),0.0001); //seu numero e maior que 0 e menor que 100, nada deve acontecer
        assertEquals(110,bifur.getVida(),0.00001);  //Não pode ter tomado dano
        assertEquals(0,bifur.getExperiencia()); //não pode ter ganho experiencia
    }
    @Test
    public void DwarfOdinAtacadoRecebeDano(){
        DataTerceiraEra data=new DataTerceiraEra(1,1,2015);
        Dwarf odin=new Dwarf("Odin",data);
        Elfo johnny=new Elfo("Johnny");
        johnny.atirarFlecha(odin);
        assertEquals(101.0,odin.getNumeroSorte(),0.0001); //seu numero da sorte obrigatoriamente é 101.0
        assertEquals(100,odin.getVida(),0.00001);  //Recebeu o dano
        assertEquals(0,odin.getExperiencia()); //não pode ter ganho experiencia
    }
    @Test
    public void DwarfNasceComDataEspecifica(){
        DataTerceiraEra data=new DataTerceiraEra(06,06,2006);
        Dwarf ollin=new Dwarf("Ollin",data);
        assertEquals(06,ollin.getNascimento().getDia());
        assertEquals(06,ollin.getNascimento().getMes());
        assertEquals(2006,ollin.getNascimento().getAno());
    }
    @Test
    public void DwarfGanha1000Itens(){
        Dwarf anao=new Dwarf("Anao",new DataTerceiraEra(1,1,2016));
        anao.atacado();
        anao.atacado();
        anao.atacado();
        anao.getInventario().adicionarItem(new Item("Machado",2));
        anao.getInventario().adicionarItem(new Item("Potion",1));
        anao.getInventario().adicionarItem(new Item("Lança",3));
        anao.tentarSorte();
        assertEquals(1002,anao.getInventario().getItemEspecifico(0).getQuantidade());
        assertEquals(1001,anao.getInventario().getItemEspecifico(1).getQuantidade());
        assertEquals(1003,anao.getInventario().getItemEspecifico(2).getQuantidade());
    }
        @Test
    public void DwarfGanha1000ItensEmVarios(){
        Dwarf anao=new Dwarf("Anao",new DataTerceiraEra(1,1,2016));
        anao.atacado();
        anao.atacado();
        anao.atacado();
        anao.getInventario().adicionarItem(new Item("Machado",2));
        anao.getInventario().adicionarItem(new Item("Potion",2));
        anao.getInventario().adicionarItem(new Item("Lança",2));
        anao.getInventario().adicionarItem(new Item("Escudo",2));
        anao.getInventario().adicionarItem(new Item("Bota",2));
        anao.getInventario().adicionarItem(new Item("Ombreiras",2));
        anao.getInventario().adicionarItem(new Item("CabecaDeElfo",2));
        anao.tentarSorte();
        for(int i=0;i<7;i++){
            assertEquals(1002,anao.getInventario().getItemEspecifico(i).getQuantidade());
        }
    }
    @Test
    public void NaoGanhaMilSeNaoForMenos3333(){
        Dwarf anao=new Dwarf("Anao",new DataTerceiraEra(1,1,2015));
        anao.atacado();
        anao.atacado();
        anao.atacado();
        anao.getInventario().adicionarItem(new Item("Machado",2));
        anao.tentarSorte();
        assertEquals(2,anao.getInventario().getItemEspecifico(0).getQuantidade());
    }
   @Test
   public void dwarfTemitens(){
       String desc="";
       Dwarf anao=new Dwarf("Machado");
       anao.getInventario().adicionarItem(new Item("Martelo",1));
       anao.getInventario().adicionarItem(new Item("Varinha",2));
       Item item2=new Item("Martelo",1);
       Item item3=new Item("Varinha",2);
       desc+=item2.getDescricao();
       desc+=",";
       desc+=item3.getDescricao();
       assertEquals(true,anao.getInventario().getDescricoesItens().equals(desc));
    }
}
