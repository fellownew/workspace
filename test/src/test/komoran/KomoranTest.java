package test.komoran;
import java.util.List;
import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
//import kr.co.shineware.util.*;
import kr.co.shineware.util.common.model.Pair;

public class KomoranTest {
	public static void main(String[] args) {
		Komoran komoran = new Komoran("C:\\JAVA\\komoran_models"); 
		List<List<Pair<String,String>>> result = komoran.analyze("�ڹٴ� ������ �Ⱦ���� ����� ���α�"); 
		for (List<Pair<String, String>> eojeolResult : result) { 
			for (Pair<String, String> wordMorph : eojeolResult) {
				System.out.println(wordMorph); 
				} System.out.println(); 
			}
	}
}