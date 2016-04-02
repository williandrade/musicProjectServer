package me.williandrade.service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;

import me.williandrade.dto.LyricDTO;
import me.williandrade.dto.RemoveWord;
import me.williandrade.util.Constants;

public class LyricService {

	MusixMatch musixMatch = new MusixMatch(Constants.XMATCH_API);

	public LyricDTO getLyric(int id, int percent) throws MusixMatchException {
		LyricDTO retorno = new LyricDTO();
		Set<RemoveWord> toRemove = new HashSet<>();

		Lyrics lyrics = musixMatch.getLyrics(id);
		String replaced = lyrics.getLyricsBody();
		retorno.setLyric(lyrics.getLyricsBody());

		String[] words = separeWords(lyrics.getLyricsBody());

		Set<Integer> randons = getRandons(words, (int) Math.round(words.length * ((double) percent / 100)));

		for (Integer random : randons) {

			RemoveWord removeWord = new RemoveWord();
			removeWord.setRandom(random);
			removeWord.setWord(words[random]);

			toRemove.add(removeWord);
			replaced = replaced.replaceFirst("\\b" + words[random] + "\\b", "\\$" + random + "\\$");

		}

		retorno.setWords(toRemove);
		retorno.setPercent(percent);
		retorno.setReplaceableLyric(replaced);

		return retorno;
	}

	private String[] separeWords(String lyric) {
		lyric = lyric.replace("******* This Lyrics is NOT for Commercial use *******", "");
		lyric = lyric.replaceAll("\\n", " ");
		lyric = lyric.replace("(", " ( ");
		lyric = lyric.replace(")", " ) ");
		lyric = lyric.replace(",", " , ");
		lyric = lyric.replace(".", " . ");
		String[] words = lyric.split("\\s");

		return words;
	}

	private Set<Integer> getRandons(String[] words, int length) {
		Set<Integer> retorno = new LinkedHashSet<Integer>();

		Random random = new Random();

		while (retorno.size() < length) {
			Integer number = random.nextInt(words.length);

			if (!retorno.contains(number + 1) && !retorno.contains(number - 1) && number != 0) {
				if (words[number].length() > 1) {
					retorno.add(number);
				}
			}

		}

		return retorno;
	}

}
