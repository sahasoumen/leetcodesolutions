package com.soumen.leetcodesolutions
package medium.tinyurl

import scala.collection.mutable
import scala.util.Random


class Codec {
  val keyLen = 6
  val urlMap: mutable.Map[String, String] = mutable.Map()

  def newKey: String = Random.alphanumeric.take(keyLen).mkString("") match {
    case key => if (urlMap contains key) newKey else key
  }

  // Encodes a URL to a shortened URL.
  def encode(longURL: String): String = newKey match {
    case key => urlMap += key -> longURL
      key
  }

  // Decodes a shortened URL to its original URL.
  def decode(shortURL: String): String = urlMap(shortURL)
}

//Runtime: 805 ms, faster than 100.00% of Scala online submissions for Encode and Decode TinyURL.
//Memory Usage: 69.8 MB, less than 100.00% of Scala online submissions for Encode and Decode TinyURL.
