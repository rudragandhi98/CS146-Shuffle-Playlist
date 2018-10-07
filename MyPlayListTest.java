package ShufflePlaylist;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;
/**
 * This class is a JUnit tester for the MyPlaylist class
 * @author Rudra Gandhi
 * @copyright 9/24/2018
 *
 */
class MyPlayListTest 
{
	@Test
	void test() throws IOException 
	{
		BufferedReader Out=new BufferedReader (new FileReader ("/Users/rudragandhi/Desktop/Fall 2018 /CS 146/Project 1/Project1/src/ShufflePlaylist/GandhiRudraPlaylist.txt"));
		BufferedReader In=new BufferedReader (new FileReader ("/Users/rudragandhi/Desktop/Fall 2018 /CS 146/Project 1/Project1/src/ShufflePlaylist/Target2.txt"));          
		String expectedLine;
		while ((expectedLine = In.readLine ()) != null) 
		{
			String actualLine = Out.readLine ();
			assertEquals (expectedLine, actualLine);
		}
		In.close();
		Out.close();
	}
}
