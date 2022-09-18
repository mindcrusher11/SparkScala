package org.bgc.uk
package service

import config.DataConfigs
import iservice.ILoadData
import utils.Constants

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.{avg, broadcast, col, desc}

/** A class to perform operations on IMDB data
  * @author
  *   Gaurhari
  *
  * Load and Process IMDBData
  */
object LoadIMDBData extends ILoadData {

  val conf = DataConfigs.getConfig()

  /** A function to get top N Movies from Data
    *
    * @return
    *   DataFrame
    */
  def getTopNMovies(): DataFrame = {

    val titleRatings = SparkProcessFile.getTSVData(
      conf.getString("file.titleRatingsPath")
    )

    val ratingAboveVotes = titleRatings.filter(Constants.votesFilterCondition)

    val avgNumberOfVotes =
      ratingAboveVotes.agg(avg(Constants.numberOfVotesCol)).first().getDouble(0)

    val topNMovies = ratingAboveVotes
      .withColumn(
        Constants.rankingCol,
        (col(Constants.numberOfVotesCol) / avgNumberOfVotes) * col(
          Constants.averageRatingCol
        )
      )
      .sort(desc(Constants.rankingCol))
      .limit(Constants.topNMovies)

    topNMovies
  }

  /** A function to get name of Persons Most often credited
    *
    * @return
    *   DataFrame
    */
  def getPersonsMostOftenCredited(): DataFrame = {
    val titlePrincipals = SparkProcessFile.getTSVData(
      conf.getString("file.titlePrincipalPath")
    )

    val nameBasics = SparkProcessFile.getTSVData(
      conf.getString("file.nameBasicsPath")
    )

    val titlePrincipalsRating =
      titlePrincipals.join(
        broadcast(LoadIMDBData.getTopNMovies()),
        Seq("tconst")
      )

    val titleNameRating =
      nameBasics.join(broadcast(titlePrincipalsRating), Seq("nconst"))

    titleNameRating
  }

  /** A function to return titles of top N movies
    *
    * @return
    *   DataFrame
    */
  def getTitlesOfTopNMovies(): DataFrame = {
    val titleBasics = SparkProcessFile.getTSVData(
      conf.getString("file.titleBasicsPath")
    )
    val titleOfTop20Movies =
      titleBasics.join(broadcast(getTopNMovies()), Seq("tconst"))

    titleOfTop20Movies
  }
}
