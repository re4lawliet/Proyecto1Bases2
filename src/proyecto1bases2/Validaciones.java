package proyecto1bases2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validaciones {
	
	
	public boolean esAlfanumerico(String cadena){
		
		String patron = "[A-Za-z0-9\\s]+";
		Pattern r = Pattern.compile(patron);
		Matcher m = r.matcher(cadena);
		return m.matches();
	}
	
	public boolean esIdentificador(String cadena){
		
		String patron = "[A-Za-z0-9]+";
		Pattern r = Pattern.compile(patron);
		Matcher m = r.matcher(cadena);
		return m.matches();
	}
	
	public boolean esNumero(String cadena){
		
		String patron = "[0-9]+";
		Pattern r = Pattern.compile(patron);
		Matcher m = r.matcher(cadena);
		return m.matches();
	}
        
        public boolean esDecimal(String cadena){
		String patron = "[0-9]+\\.[0-9]+";
		Pattern r = Pattern.compile(patron);
		Matcher m = r.matcher(cadena);
		return m.matches();
	}
	
	public boolean entraEnLimite(String cadena, int limite){
		
		return cadena.length() <= limite;
	}
	
	
	public boolean esCorreo(String cadena){
		
		String patron = "([A-Za-z0-9\\.]+)@([A-Za-z]+)\\.([A-Za-z]+)";
		Pattern r = Pattern.compile(patron);
		Matcher m = r.matcher(cadena);
		return m.matches();
	}
        
        public boolean esDireccion(String cadena){
		
		String patron = "[A-Za-z0-9\\s\\.\\-]+";
		Pattern r = Pattern.compile(patron);
		Matcher m = r.matcher(cadena);
		return m.matches();
	}
	
        public boolean esFecha(String cadena){
		
		String patron = "[0-9][0-9]/[0-9][0-9]/[0-9][0-9]";
		Pattern r = Pattern.compile(patron);
		Matcher m = r.matcher(cadena);
		return m.matches();
	}
}


