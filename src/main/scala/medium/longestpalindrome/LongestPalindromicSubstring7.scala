package com.soumen.leetcodesolutions
package medium.longestpalindrome

object LongestPalindromicSubstring7 extends App {
  def longestPalindrome(s: String): String = {
    def isPalindrome(s: String, start: Int, len: Int) = (0 until len).find(i => s.charAt(start + i) != s.charAt(start + len - 1 - i)) match {
      case Some(_) => false
      case _ => true
    }

    @scala.annotation.tailrec
    def longestPalindrome(s: String, len: Int): String = (0 to s.length - len).find(i => isPalindrome(s, i, len)) match {
      case Some(i) => s.substring(i, i + len)
      case _ => longestPalindrome(s, len - 1)
    }

    longestPalindrome(s, s.length)
  }

  def time[A, B](f: Function[A, B], arg: A): (B, Double) = {
    val start = System.currentTimeMillis
    f(arg) -> (System.currentTimeMillis - start) / 1000.0
  }

  println(longestPalindrome("abba"))
  println(time(longestPalindrome, "abb"))
  println(time(longestPalindrome, "babad"))
  println(time(longestPalindrome, "a"))
  println(time(longestPalindrome, "aba"))
  println(time(longestPalindrome, "ac"))
  println(time(longestPalindrome, "cbbd"))
  println(time(longestPalindrome, "eabcb"))
  println(time(longestPalindrome, "bacabab"))
  println(time(longestPalindrome, "lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc"))
  println(time(longestPalindrome, "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"))
  println(time(longestPalindrome, "okfzopfdxngrcukpqwmgyfbwzkqegoglsqszdihswhcnwaajuiagxscrwoicsdvyowbowaddignjgsjrhhhookusgnykutrkpogmvruwdkpjucslsoluhnooysjichvobriksbanovvynfwtooygdtflnchtgcycjiziytrhsomevozdxxbiwiuxrhxtyefogphgavlhbvdjpcosexyrmphcyuhqymnzkngqyitzekwimveydjrxkhvhckqcjetpmhxzisdlkhmotwcgejllzdmfwrbpzuxcawgamamkziewwqnxpvyhvmzulivwrngrsnarsmeunbpbnnvvlxllvniskaerpawflwfdozfsmovvjtymsgnvmfepidyffwjxpvpgwceukgfplqcyccejatqqmefquirgztnyawkruasuitnjldxgmmqzzvwltetjyenbicgabtnkpfdcanggcensptcgyyygnkbvcgmvzichisofakajqtsfogqewegawcjtylxavxdxdznzyxyvvupnwfxogyjmbayeminbzthyidymnmuoevrgfbdpodbdrznmosuispnmimrglgrkdrdsjmyacfmuntvgpjaginmyknawgonibhifpyhqoswyefidrtsqgwqviseayzxqwgelgtnvxlrdhpnuhxhianiqjiyygagwwmyklszbyhcykhejijhnfmrsagsbfthmzmzractm"))
}
//Runtime: 2841 ms, faster than 26.67% of Scala online submissions for Longest Palindromic Substring.
//Memory Usage: 532.1 MB, less than 25.84% of Scala online submissions for Longest Palindromic Substring.