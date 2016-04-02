package me.williandrade.dto;

public class RemoveWord {

	private int random;
	private String word;
	private String writed;
	private boolean correct;

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWrited() {
		return writed;
	}

	public void setWrited(String writedWord) {
		this.writed = writedWord;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
