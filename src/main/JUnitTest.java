package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import JUnitStrategy.BubbleJUnitStrategy;
import JUnitStrategy.CombJUnitStrategy;
import JUnitStrategy.HeapJUnitStrategy;
import JUnitStrategy.InsertJUnitStrategy;
import JUnitStrategy.MergeJUnitStrategy;
import JUnitStrategy.QuickJUnitStrategy;
import JUnitStrategy.SelectionJUnitStrategy;
import JUnitStrategy.ShellJUnitStrategy;

@RunWith(Suite.class)
@SuiteClasses({ BubbleJUnitStrategy.class, CombJUnitStrategy.class,
		HeapJUnitStrategy.class, MergeJUnitStrategy.class,
		SelectionJUnitStrategy.class, ShellJUnitStrategy.class,
		InsertJUnitStrategy.class, QuickJUnitStrategy.class })
public class JUnitTest {
}
