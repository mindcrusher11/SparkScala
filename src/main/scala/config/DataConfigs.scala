package org.bgc.uk
package config

import com.typesafe.config.{Config, ConfigFactory}

import java.io.File

/** A Singleton Class to get all data from config file
  *
  * @author
  *   Gaurhari
  */
object DataConfigs extends IConfig {

  private var conf: Config = null

  /*
   * A function to load config values from config file
   *
   * @param filePath the path of the config file which is default to application.conf in resources folder
   *
   * @return conf as Config object of typesafe
   * */
  def getConfig(filePath: String = "application.conf"): Config = {
    if (conf == null)
      if (filePath.contains("/"))
        conf = ConfigFactory.parseFile(
          new File(filePath)
        )
      else conf = ConfigFactory.load(filePath)
    conf
  }
}
