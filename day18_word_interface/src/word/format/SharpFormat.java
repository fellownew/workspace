package word.format;

public class SharpFormat implements Format{

	@Override
	public String getFormat(String message) {
		return "##########\n"+message+"\n##########\n";
	}
}