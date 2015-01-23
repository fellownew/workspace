package test.komoran;
import java.util.List;
import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
//import kr.co.shineware.util.*;
import kr.co.shineware.util.common.model.Pair;

public class KomoranTest {
	public static void main(String[] args) {
		Komoran komoran = new Komoran("C:\\JAVA\\komoran_models"); 
		List<List<Pair<String,String>>> result = komoran.analyze("자바는 어려운듯 안어려운 어려운 언어로군"); 
		for (List<Pair<String, String>> eojeolResult : result) { 
			for (Pair<String, String> wordMorph : eojeolResult) {
				System.out.println(wordMorph); 
				} System.out.println(); 
			}
	}
}