package org.bgc.uk
package config

import com.typesafe.config.{Config, ConfigFactory}

/** A Singleton Class to get all data from config file
  *
  * @author
  *   Gaurhari
  */
object DataConfigs extends IConfig {

  /*
   * A function to load config values from config file
   *
   * @param filePath the path of the config file which is default to application.conf in resources folder
   *
   * @return conf as Config object of typesafe
   * */
  def getConfig(filePath: String = "application.conf"): Config = {
    val conf = ConfigFactory.load(filePath)
    conf
  }
}
