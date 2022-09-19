package org.bgc.uk

import org.bgc.uk.config.DataConfigs
import org.bgc.uk.service.LoadIMDBData

/** Object class with main function
  *
  * @author
  *   Gaurhari
  */
object SparkScalaBcgMainApp {

  def main(args: Array[String]) = {

    LoadIMDBData.getTopNMovies()
    LoadIMDBData.getTitlesOfTopNMovies
    LoadIMDBData.getPersonsMostOftenCredited()
    println(LoadIMDBData.getTopNMovies().count())
  }
}
