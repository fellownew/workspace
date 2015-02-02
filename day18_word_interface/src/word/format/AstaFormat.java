package word.format;

public class AstaFormat implements Format {

	@Override
	public String getFormat(String message) {
		return"**********\n"+message+"\n**********\n";
	}
}