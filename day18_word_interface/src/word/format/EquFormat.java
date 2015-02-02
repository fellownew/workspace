package word.format;

public class EquFormat implements Format {

	@Override
	public String getFormat(String message) {
		return  "==========\n"+message+"\n==========\n";
	}
}