package me.williandrade.service;

import java.util.ArrayList;
import java.util.List;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;

import me.williandrade.util.Constants;

public class SearchService {

	MusixMatch musixMatch = new MusixMatch(Constants.XMATCH_API);

	public List<TrackData> getByArtist(String artist) throws MusixMatchException {
		List<TrackData> retorno = new ArrayList<>();
		List<Track> tracks = musixMatch.searchTracks("", artist, "", 0, 20, true);

		tracks.forEach(item -> {
			TrackData t = new TrackData();

			TrackData trkData = item.getTrack();
			t.setAlbumName(trkData.getAlbumName());
			t.setArtistName(t.getArtistName());
			t.setTrackId(trkData.getTrackId());

			retorno.add(t);
		});

		return retorno;
	}

	public List<TrackData> getBySomeText(String text) throws MusixMatchException {
		List<TrackData> retorno = new ArrayList<>();
		List<Track> tracks = musixMatch.searchTracks(text, "", "", 0, 20, true);

		tracks.forEach(item -> {
			TrackData t = item.getTrack();

//			TrackData trkData = item.getTrack();
//			t.setAlbumName(trkData.getAlbumName());
//			t.setArtistName(trkData.getArtistName());
//			t.setTrackId(trkData.getTrackId());

			retorno.add(t);
		});

		return retorno;
	}

	public List<TrackData> getByAlbum(String album) throws MusixMatchException {
		List<TrackData> retorno = new ArrayList<>();
		List<Track> tracks = musixMatch.searchTracks("", "", album, 0, 20, true);

		tracks.forEach(item -> {
			TrackData t = new TrackData();

			TrackData trkData = item.getTrack();
			t.setAlbumName(trkData.getAlbumName());
			t.setArtistName(t.getArtistName());
			t.setTrackId(trkData.getTrackId());

			retorno.add(t);
		});

		return retorno;
	}

}
