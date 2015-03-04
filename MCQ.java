import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MCQ {

	private String q; // question
	private String ansRight; // answer choice A
	private String ansWrong1; // answer choice B
	private String ansWrong2; // answer choice C
	private String ansWrong3; // answer choice D

	public MCQ(String q, String ansRight, String ansWrong1, String ansWrong2,
			String ansWrong3) {
		this.q = q;
		this.ansRight = ansRight;
		this.ansWrong1 = ansWrong1;
		this.ansWrong2 = ansWrong2;
		this.ansWrong3 = ansWrong3;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getansRight() {
		return ansRight;
	}

	public void setansRight(String ansRight) {
		this.ansRight = ansRight;
	}

	public String getansWrong1() {
		return ansWrong1;
	}

	public void setansWrong1(String ansWrong1) {
		this.ansWrong1 = ansWrong1;
	}

	public String getansWrong2() {
		return ansWrong2;
	}

	public void setansWrong2(String ansWrong2) {
		this.ansWrong2 = ansWrong2;
	}

	public String getansWrong3() {
		return ansWrong3;
	}

	public void setansWrong3(String ansWrong3) {
		this.ansWrong3 = ansWrong3;
	}

	public static ArrayList<MCQ> MCQInput(String filename)
			throws FileNotFoundException {
		Scanner keyboard = new Scanner(new File(filename));
		ArrayList<MCQ> questionList = new ArrayList<MCQ>();
		while (keyboard.hasNextLine()) {
			String question = keyboard.nextLine();
			if (question.equals("#")) {
				break;
			}
			String rightAns = keyboard.nextLine();
			String wrongAns1 = keyboard.nextLine();
			String wrongAns2 = keyboard.nextLine();
			String wrongAns3 = keyboard.nextLine();

			MCQ MCquestion = new MCQ(question, rightAns, wrongAns1, wrongAns2,
					wrongAns3);
			questionList.add(MCquestion);

		}

		return questionList;

	}

}
