package java;

public class Main {

	public static void main(String[] args) {
      Stream teste = new StreamImpl("aAbBABac"); 
      char resultado = StreamImpl.fistChar(teste);
      if(resultado!=0){
    	  System.out.println(resultado);    	  
      }
      else{
    	  System.out.println("Todas as letras se repetem.");
      }
	}
}
