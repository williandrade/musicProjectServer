package me.williandrade.main;

import static spark.Spark.*;

import java.util.List;

import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.TrackData;

import com.google.gson.Gson;

import me.williandrade.service.LyricService;
import me.williandrade.service.SearchService;
import me.williandrade.transformer.JsonTransformer;
import spark.Request;
import spark.Response;

public class Principal {

	private static SearchService searchService = new SearchService();
	private static LyricService lyricService = new LyricService();

	public static void main(String[] args) throws MusixMatchException {

		port(9090);

		post("/search/:someText", (Request request, Response response) -> {
			String someText = request.params(":someText");

			List<TrackData> retorno = searchService.getBySomeText(someText);

			return retorno;
		} , new JsonTransformer());

		post("/searchByArtist/:artist", (Request request, Response response) -> {
			String artist = request.params(":artist");

			List<TrackData> retorno = searchService.getByArtist(artist);

			return retorno;
		} , new JsonTransformer());

		post("/searchByAlbum/:album", (Request request, Response response) -> {
			String album = request.params(":album");

			List<TrackData> retorno = searchService.getByAlbum(album);

			return retorno;
		} , new JsonTransformer());

		post("/getLyric/:id/:percent", (Request request, Response response) -> {
			String id = request.params(":id");
			String percent = request.params(":percent");
			
			return lyricService.getLyric(Integer.parseInt(id), Integer.parseInt(percent));
		} , new JsonTransformer());

	}
}