package models

import play.api.libs.json._ // JSON library
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

//TODO refactor here

case class SearchResult(
    albums: Option[Page[AlbumSimple]],
    artists: Option[Page[Artist]],
    tracks: Option[Page[Track]],
    playlists: Option[Page[PlaylistSimple]]
)

object SearchResult {
  implicit val searchResultReads: Reads[SearchResult] = (
    (__ \ "albums").readNullable[Page[AlbumSimple]] and
      (__ \ "artists").readNullable[Page[Artist]] and
      (__ \ "tracks").readNullable[Page[Track]] and
      (__ \ "playlists").readNullable[Page[PlaylistSimple]]
    )(SearchResult.apply _)
}


