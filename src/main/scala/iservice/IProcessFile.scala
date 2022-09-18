package org.bgc.uk
package iservice

/**
 *
 *An interface to define methods for define basic function for file processing
 *
 * @author Gaurhari
 *
  */
trait IProcessFile {
  def getTSVData(path: String): AnyRef
}
