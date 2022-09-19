package org.bgc.uk

import org.bgc.uk.config.DataConfigs
import org.bgc.uk.service.LoadIMDBData

/** Object class with main function
  *
  * @author
  *   Gaurhari
  */
object SparkScalaBcgMainApp {

  /** Main function of the application to do all the execution calls
    *
    * @param args
    *   Array of String input
    */
  def main(args: Array[String]) = {

    /** check for configuration file if passed by user then it will load that
      * file otherwise load from resources folder
      */
    if (args.length > 0 && args(0) != null) DataConfigs.getConfig(args(0))
    LoadIMDBData.getTopNMovies()
    LoadIMDBData.getTitlesOfTopNMovies
    LoadIMDBData.getPersonsMostOftenCredited()
    println(LoadIMDBData.getTopNMovies().count())
  }
}
