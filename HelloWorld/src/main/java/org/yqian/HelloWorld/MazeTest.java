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
 
 package org.yqian.Recursive;
import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;
@Configurationpublic class BeanConfiguration { @Bean public Maze maze() {  return new Maze(); }
 @Bean public Permutation permutation() {  return new Permutation(); }}
 
 
 package org.yqian.Recursive;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)@SpringBootTestpublic class MazeTest {
 @Autowired private Maze maze;
 @Before public void setup() {  maze.initializeMaze(); }
 @Test public void testSolveRecursively() {  assertThat(maze.solveRecursively(0, 0)).isTrue(); }}
 
 
 package org.yqian.Recursive;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)@SpringBootTestpublic class PermutationTest {
 @Autowired private Permutation permutation;
 @Test public void testPermuntation() {  List<String> list = permutation.permute("abc");  assertThat(list.size()).isEqualTo(6); }}
 
 
 logging:

  level:

    org.yqian: DEBUG

  pattern:

    console: "%d{yyyy-MM-dd HH:mm:ss} - %msg%n"

    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"

  file: C:/FAST/eclipse/workspaces/default/Recursive/log
