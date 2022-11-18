import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.*;

import java.util.*;

interface StringChecker { boolean checkString(String s); }

public class TestListExamples {
  @Test
  public void testFilter() {
    StringChecker st = new StringChecker() {
      public boolean checkString(String s) {
        return true;
      }
    };
    List<String> input1 = new ArrayList<String>();
    input1.add("first");
    input1.add("second");
    input1.add("third");
    List<String> output = new ArrayList<String>() {{
      add("third");
      add("second");
      add("first");
    }};
    assertEquals(output, ListExamples.filter(input1, st));
  }

  @Test (timeout = 100)
  public void testMerge() {
    List<String> input = new ArrayList<String>() {{
      add("a");
      add("c");
    }};
    List<String> input2 = new ArrayList<String>() {{
      add("b");
      add("d");
    }};
    List<String> output = new ArrayList<String>() {{
      add("a");
      add("b");
      add("c");
      add("d");
    }};
    assertEquals(output, ListExamples.merge(input, input2));
  }
}
