package com.soumen.leetcodesolutions
package medium.longestpalindrome

object LongestPalindromicSubstring2 extends App {
  def longestPalindrome(s: String): String = {
    @scala.annotation.tailrec
    def isPalindrome(s: String, palindrome: Boolean = true): Boolean = s match {
      case "" | null => palindrome
      case _ => if (s.length == 1) palindrome else isPalindrome(s.substring(1, s.length - 1), palindrome && (s.charAt(0) == s.charAt(s.length - 1)))
    }

    (2 to s.length).flatMap(i => s.sliding(i)).filter(s => isPalindrome(s)) match {
      case Seq() => s.substring(0, 1)
      case s => s.maxBy(_.length)
    }
  }

  def time[A, B](f: Function[A, B], arg: A): (B, Long) = {
    val start = System.currentTimeMillis
    f(arg) -> (System.currentTimeMillis - start)
  }

  println(time(longestPalindrome, "babad"))
  println(time(longestPalindrome, "a"))
  println(time(longestPalindrome, "aba"))
  println(time(longestPalindrome, "ac"))
  println(time(longestPalindrome, "cbbd"))
  println(time(longestPalindrome, "eabcb"))
  println(time(longestPalindrome, "bacabab"))
  println(time(longestPalindrome, "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"))
}
//Memory Limit Exceeded