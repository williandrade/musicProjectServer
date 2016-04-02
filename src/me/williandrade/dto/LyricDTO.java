package me.williandrade.dto;

import java.util.Set;

public class LyricDTO {

	private String lyric;
	private String replaceableLyric;
	private Set<RemoveWord> words;
	private int percent;

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public Set<RemoveWord> getWords() {
		return words;
	}

	public void setWords(Set<RemoveWord> words) {
		this.words = words;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public String getReplaceableLyric() {
		return replaceableLyric;
	}

	public void setReplaceableLyric(String replaceableLyric) {
		this.replaceableLyric = replaceableLyric;
	}

}
