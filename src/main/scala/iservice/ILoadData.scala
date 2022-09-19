package org.bgc.uk
package iservice

/** 
  * An interface to define functions which need to be implemented to perform
  * data operations
  * 
  * @author Gaurhari
  */
trait ILoadData {
  def getTopNMovies(): AnyRef
  def getPersonsMostOftenCredited(): AnyRef
  def getTitlesOfTopNMovies(): AnyRef
}
