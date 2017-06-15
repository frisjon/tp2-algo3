package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.utils.RandomUtils;

public class SuperficieDeCampoProvider {

	public static SuperficieDeCampo generarSerficieDeCampoComun(){
		return new SuperficieDeCampo(new SuperficieNube(), new SuperficieRocosa());
	}
	
	public static SuperficieDeCampo generarSuperficieDeCampoAleatoria(){
		SuperficieTerrestre superficieTerrestre = null;
		SuperficieAerea superficieAerea = null;
		int valueSupTerrestre = RandomUtils.generaNumeroAleatorio(1,3);
		
		switch(valueSupTerrestre){
			case 1: {
					superficieTerrestre = new SuperficieRocosa();
					break;							
			}
			case 2: {
					superficieTerrestre = new SuperficieEspinas();
					break;							
			}
			case 3:{
					superficieTerrestre = new SuperficiePantano();
					break;
			}
		}
		
		int valueSupAerea = RandomUtils.generaNumeroAleatorio(1,3);
		
		switch(valueSupAerea){
			case 1: {
					superficieAerea = new SuperficieNube();
					break;
			}
			case 2: {
					superficieAerea = new SuperficieTormentaPsionica();
					break;
			}
			case 3: {
					superficieAerea = new SuperficieNebulosaDeAndromeda();
					break;
			}	
		}
		
		return new SuperficieDeCampo(superficieAerea, superficieTerrestre);
	}
}
