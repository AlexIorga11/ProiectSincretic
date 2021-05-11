package problema8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Fraza
{
	String F;

	Fraza(String F)
	{
		this.F = F;
	}

	public int Cuvinte()
	{
		String[] aux = F.split(" ");
		return aux.length;
	}

	public int Vocale()
	{
		String vocale = "AEIOUYWaeiouyw";
		char[] aux=F.toCharArray();
		short count_vocale = 0;
		short count_consoane = 0;

		for(int i = 0; i < aux.length; i++)
		{
			String a = String.valueOf(aux[i]);

			if(vocale.contains(a))
			{
				count_vocale++;
			}
			
			else
				count_consoane++;
		}
		return count_vocale & count_consoane;
	}

	public boolean Final(String F)
	{
		if(F.endsWith(F))
		{
			return true;
		}
		return false;
	}

	public void Majuscule()
	{
		F = F.toUpperCase();
	}

}

public class Text {
	public static void main(String[] args) throws IOException
	{
		Fraza[] frz = new Fraza[3000];
		
		short i = 0;
		short j = 0;
		
		BufferedReader write = new BufferedReader(new InputStreamReader(new FileInputStream("src\\problema8\\Cantec_in.txt")));
	}
}
