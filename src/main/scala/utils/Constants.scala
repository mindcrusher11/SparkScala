package org.bgc.uk
package utils

import config.DataConfigs

/** A Singleton Class for adding Constants
  *
  * @author
  *   Gaurhari
  */
object Constants {

  val config = DataConfigs.getConfig()

  val sparkMasterUrl = config.getString("spark.masterurl")
  val sparkAppName = config.getString("spark.appName")
  val checkPointDir = config.getString("spark.checkpointDir")
  val batchDuration = config.getInt("spark.batchDuration")

  val rankingCol = "ranking"
  val numberOfVotesCol = "numVotes"
  val averageRatingCol = "averageRating"
  val topNMovies = 20
  val votesFilterCondition = "numVotes > 50"

}
