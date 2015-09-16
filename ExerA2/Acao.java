public class acao{
	void AtirarFlecha(Elfo flec){
		if(flec.flechas>0){
			flec.exper();
			flec.sflechas();
		}
	}
}