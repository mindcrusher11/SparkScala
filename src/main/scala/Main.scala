package org.bgc.uk

import org.bgc.uk.service.LoadIMDBData

object Main {

  def main(args: Array[String]) = {
    LoadIMDBData.getTopNMovies()
    LoadIMDBData.getTitlesOfTopNMovies
    LoadIMDBData.getPersonsMostOftenCredited()
    println(LoadIMDBData.getTopNMovies().count())
  }
}
