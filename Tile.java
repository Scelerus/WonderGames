public class Tile {

	private MCQ q;
	private String fileName;

	public Tile(MCQ question, String imageFile) {
		this.q = question;
		this.fileName = imageFile;
	}

	public String getFileName() {
		return fileName;
	}

}
