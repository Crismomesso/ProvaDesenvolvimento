
import java.util.ArrayList;
import java.util.List;

public class StreamImpl implements Stream{

	String palavra;
	private int pos;
	
	public StreamImpl(String palavra){
		this.palavra=palavra;
		this.pos = -1;
	}
	
	
	@Override
	public char getNext() {
		if(this.hasNext()){
			pos++;
			return palavra.charAt(pos);
		}
		return 0;
	}

	@Override
	public boolean hasNext() {
		if (palavra.length()-1 > pos) {
			return true;
		}
		return false;
	}
	
	public static char fistChar(Stream input){
		List<Character> resultado = new ArrayList<Character>();
		List<Character> excluidos = new ArrayList<Character>();
		while(input.hasNext()){
			Character letra = input.getNext();
			if(resultado.contains(letra)){
				resultado.remove(letra);
				excluidos.add(letra);
			}else{
				if(!excluidos.contains(letra));
			 	resultado.add(letra);
			}
		}
		if(resultado.size()>0){
			return resultado.get(0);
		}
		return 0;	
	}

}
