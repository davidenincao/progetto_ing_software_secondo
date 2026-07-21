package myTest;

import java.util.*;
import org.junit.runner.notification.Failure;
import org.junit.runner.*;

public class TestRunner
{
	public static void main(String[] argv)
	{
		org.junit.runner.Result res = org.junit.runner.JUnitCore.runClasses(
			MapAdapterTest.class
		);
		System.out.println("Ho eseguito " + res.getRunCount() + " test");
		System.out.println("Ho eseguito i test in " + res.getRunTime() + " millisecondi");
		System.out.println("Sono falliti " + res.getFailureCount() + " test");
		List<Failure> l = res.getFailures();
		ListIterator<Failure> li = l.listIterator();
		while(li.hasNext())
		{
			System.out.println(li.next());
		}
	}
}
