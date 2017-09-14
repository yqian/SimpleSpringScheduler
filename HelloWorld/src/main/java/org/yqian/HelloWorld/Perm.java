package org.yqian.Recursive;
import java.util.ArrayList;import java.util.List;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
public class Permutation {
 private static final Logger LOGGER = LoggerFactory.getLogger(Permutation.class);
 private List<String> list = new ArrayList<String>();
 public List<String> permute(String s) {  return permute("", s); }
 public List<String> permute(String prefix, String s) {
  int n = s.length();
  if (n == 0) {   list.add(prefix);  } else {   for (int i = 0; i < n; i++) {    permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));   }  }  return list; }
 public static void main(String[] args) {  Permutation permutation = new Permutation();  List<String> list1 = permutation.permute("abcde");  String s = "adbdcebdaeacdebbcade";  int i = 0;  for (String s1 : list1)   if ((i = s.indexOf(s1)) != -1)    LOGGER.info(Integer.toString(i)); }}
