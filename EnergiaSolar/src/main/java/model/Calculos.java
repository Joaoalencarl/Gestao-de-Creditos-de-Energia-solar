package model;

public class Calculos {
	public Float mediaIrradiacao(JavaBeans cidade) {
		Float media;
		Float jan = Float.valueOf(cidade.getJaneiro());
		Float fev = Float.valueOf(cidade.getFevereiro());
		Float mar = Float.valueOf(cidade.getMarco());
		Float abr = Float.valueOf(cidade.getAbril());
		Float mai = Float.valueOf(cidade.getMaio());
		Float jun = Float.valueOf(cidade.getJunho());
		Float jul = Float.valueOf(cidade.getJulho());
		Float ago = Float.valueOf(cidade.getAgosto());
		Float set = Float.valueOf(cidade.getSetembro());
		Float out = Float.valueOf(cidade.getOutubro());
		Float nov = Float.valueOf(cidade.getNovembro());
		Float dez = Float.valueOf(cidade.getDezembro());

		media = (jan + fev + mar + abr + mai + jun + jul + ago + set + out + nov + dez) / 12;
		return media;
	}
	
	public Float potenciaInstalada(ArmazenarCalcs calculos) {
		Float potencia;
		Float nummod = Float.valueOf(calculos.getNummod());
		Float potmod = Float.valueOf(calculos.getPotmod());
		potencia = (nummod*potmod)/1000;
		return potencia;
	}
	
	public ArmazenarCalcs energiaEsperada(ArmazenarCalcs resultados, JavaBeans cidade) {
		Float espjan = ((Float.valueOf(cidade.getJaneiro())*Float.valueOf(resultados.getPotencia()))*31)*(Float.valueOf(resultados.getEfi())/100);
		Float espfev = ((Float.valueOf(cidade.getFevereiro())*Float.valueOf(resultados.getPotencia()))*28)*(Float.valueOf(resultados.getEfi())/100);
		Float espmar = ((Float.valueOf(cidade.getMarco())*Float.valueOf(resultados.getPotencia()))*31)*(Float.valueOf(resultados.getEfi())/100);
		Float espabr = ((Float.valueOf(cidade.getAbril())*Float.valueOf(resultados.getPotencia()))*30)*(Float.valueOf(resultados.getEfi())/100);
		Float espmai = ((Float.valueOf(cidade.getMaio())*Float.valueOf(resultados.getPotencia()))*31)*(Float.valueOf(resultados.getEfi())/100);
		Float espjun = ((Float.valueOf(cidade.getJunho())*Float.valueOf(resultados.getPotencia()))*30)*(Float.valueOf(resultados.getEfi())/100);
		Float espjul = ((Float.valueOf(cidade.getJulho())*Float.valueOf(resultados.getPotencia()))*31)*(Float.valueOf(resultados.getEfi())/100);
		Float espago = ((Float.valueOf(cidade.getAgosto())*Float.valueOf(resultados.getPotencia()))*31)*(Float.valueOf(resultados.getEfi())/100);
		Float espset = ((Float.valueOf(cidade.getSetembro())*Float.valueOf(resultados.getPotencia()))*30)*(Float.valueOf(resultados.getEfi())/100);
		Float espout = ((Float.valueOf(cidade.getOutubro())*Float.valueOf(resultados.getPotencia()))*31)*(Float.valueOf(resultados.getEfi())/100);
		Float espnov = ((Float.valueOf(cidade.getNovembro())*Float.valueOf(resultados.getPotencia()))*30)*(Float.valueOf(resultados.getEfi())/100);
		Float espdez = ((Float.valueOf(cidade.getDezembro())*Float.valueOf(resultados.getPotencia()))*31)*(Float.valueOf(resultados.getEfi())/100);
		
		Float media = (espjan + espfev + espmar + espabr + espmai + espjun + espjul + espago + espset + espout + espnov + espdez)/12;
		Float soma = espjan + espfev + espmar + espabr + espmai + espjun + espjul + espago + espset + espout + espnov + espdez;
		
		resultados.setEspjan(String.valueOf(espjan));
		resultados.setEspfev(String.valueOf(espfev));
		resultados.setEspmar(String.valueOf(espmar));
		resultados.setEspabr(String.valueOf(espabr));
		resultados.setEspmai(String.valueOf(espmai));
		resultados.setEspjun(String.valueOf(espjun));
		resultados.setEspjul(String.valueOf(espjul));
		resultados.setEspago(String.valueOf(espago));
		resultados.setEspset(String.valueOf(espset));
		resultados.setEspout(String.valueOf(espout));
		resultados.setEspnov(String.valueOf(espnov));
		resultados.setEspdez(String.valueOf(espdez));
		resultados.setEspmedia(String.valueOf(media));
		resultados.setEspsoma(String.valueOf(soma));
		
		return resultados;
	}
}
