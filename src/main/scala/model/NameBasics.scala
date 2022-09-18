package org.bgc.uk
package model

import java.sql.Date

/** Case Class for NameBasic File to convert data to objects
  *
  * @author
  *   Gaurhari
  * @param nconst
  *   (string) - alphanumeric unique identifier of the name/person
  * @param primaryName
  *   (string)– name by which the person is most often credited
  * @param birthYear
  *   – in YYYY format
  * @param deathYear
  *   – in YYYY format if applicable, else '\N'
  * @param primaryProfession
  *   (array of strings)– the top-3 professions of the person
  * @param knownForTitles
  *   (array of tconsts) – titles the person is known for
  */
case class NameBasics(
    nconst: String,
    primaryName: String,
    birthYear: Date,
    deathYear: Date,
    primaryProfession: Array[String],
    knownForTitles: String
)
