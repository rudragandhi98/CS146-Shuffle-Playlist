package ShufflePlaylist;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/**
 * The MyPlaylist class reads the songs in the playlist file and then shuffles the songs and writes them into a new playlist. 
 * @author Rudra Gandhi
 * @copyright 9/24/2018
 */
public class MyPlaylist 
{
	private ArrayList<String> playlist = new ArrayList<String>();
	private Random myRandGen;
	int myrandom(int i) 
	{
		return myRandGen.nextInt(i); 
	}
	
	/**
	 * This is the constructor for MyPlaylist that creates a random function
	 * @param dimension_in This gives the dimension of the random function
	 */
	public MyPlaylist(int dimension_in)
	{
		myRandGen=new java.util.Random(20);
	}

	/**
	 * This method reads the songs in the file and reads each line
	 * @throws IOException
	 */
	public void readSongs() throws IOException
	{
		File textPlaylist = new File("/Users/rudragandhi/Desktop/Fall 2018 /CS 146/Project 1/Project1/src/ShufflePlaylist/Playlist.txt");
		FileReader fr = new FileReader(textPlaylist);
		BufferedReader br = new BufferedReader(fr);
		String music = "";
		while((music = br.readLine()) != null)
		{
			playlist.add(music);
		}
		br.close();
		fr.close();
	}
	
	/**
	 *  This method shuffles the songs randomly by its size
	 */
	public void shuffleSongs()
	{
		for(int i=playlist.size()-1; i> 0; i--)
		{
			int j = myrandom(i);
			String temp = playlist.get(i);
			playlist.set(i, playlist.get(j));
			playlist.set(j, temp);
		}
	}
	
	/**
	 * After reading each line of the playlist, this method writes the shuffled songs into a new playlist
	 * @throws IOException
	 */
	public void writeSongs() throws IOException
	{
		File shuffledSongs = new File("/Users/rudragandhi/Desktop/Fall 2018 /CS 146/Project 1/Project1/src/ShufflePlaylist/GandhiRudraPlaylist.txt");
		FileWriter fw = new FileWriter(shuffledSongs);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i<playlist.size(); i++)
		{
			bw.write(playlist.get(i));
			bw.newLine();
		}
		bw.close();
		fw.close();
	}
	
	/**
	 * This is the main method of the class
	 * @param args Passes through the String
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		MyPlaylist mp = new MyPlaylist(20);
		mp.readSongs();
		mp.shuffleSongs();
		mp.writeSongs();
	}
	
}
