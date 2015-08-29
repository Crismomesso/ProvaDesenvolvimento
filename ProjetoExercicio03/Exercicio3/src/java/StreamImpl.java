package java;

import java.util.ArrayList;
import java.util.List;

public class StreamImpl implements Stream{

	String palavra;
	private int pos;
	
	public StreamImpl(String palavra){
		this.palavra=palavra;
		this.pos = 0;
	}
	
	
	@Override
	public char getNext() {
		if(this.hasNext()){
			pos++;
			palavra.charAt(pos);
		}
		return 0;
	}

	@Override
	public boolean hasNext() {
		if (palavra.length() < pos) {
			return true;
		}
		return false;
	}
	
	public static char fistChar(Stream input){
		List<Character> resultado = new ArrayList<Character>();
		while(input.hasNext()){
			char letra = input.getNext();
			if(resultado.contains(letra)){
				resultado.remove(letra);
			}else{
				resultado.add(letra);
			}
		}
		if(resultado.get(0)!=null){
			return resultado.get(0);
		}
		return 0;	
	}

}
