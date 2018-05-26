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
    (JsPath \ "albums").readNullable[Page[AlbumSimple]] and
      (JsPath \ "artists").readNullable[Page[Artist]] and
      (JsPath \ "tracks").readNullable[Page[Track]] and
      (JsPath \ "playlists").readNullable[Page[PlaylistSimple]]
    )(SearchResult.apply _)
}


