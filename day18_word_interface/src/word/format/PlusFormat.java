package word.format;

public class PlusFormat implements Format {

	@Override
	public String getFormat(String message) {
		return "++++++++++\n"+message+"\n++++++++++\n";
	}
}