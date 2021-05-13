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
		String vocale = "AEIOUaeiou";
		char[] aux=F.toCharArray();
		short count_vocale = 0;

		for(int i = 0; i < aux.length; i++)
		{
			String a = String.valueOf(aux[i]);

			if(vocale.contains(a))
			{
				count_vocale++;
			}

		}
		return count_vocale;
	}

	public int Consoane()
	{
		String consoane = "qwrtypsdfghjklzxcvbnmQWRTYPSDFGHJKLZXCVBNM";
		char[] aux=F.toCharArray();
		short count_consoane = 0;

		for(int i = 0; i < aux.length; i++)
		{
			String a = String.valueOf(aux[i]);

			if(consoane.contains(a))
			{
				count_consoane++;
			}

		}
		return count_consoane;
	}

	public boolean Final(String F)
	{
		if(F.endsWith(F))
		{
			return true;
		}
		return false;
	}
}

public class Text {
	public static void main(String[] args) throws IOException
	{
		Fraza[] fraze = new Fraza[3000];

		short i = 0;
		short j = 0;

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./src/problema8/text.txt")));

		String buffer;
		while((buffer = reader.readLine()) != null)
		{
			fraze[i] = new Fraza(buffer);
			i++;
		}

		reader.close();

		for(j = 0; j < i; j++)
		{
			System.out.printf("Randul %d " + " \n" , j + 1);
			float M = (float)(fraze[j].Consoane() + fraze[j].Vocale()) / (fraze[j].Cuvinte());
			float N = 1/M;
			float p = (float)(fraze[j].Vocale()) / (fraze[j].Consoane());
			float P = p * N;
			System.out.println("Cuvinte = " + fraze[j].Cuvinte() + " | " + "Consoane = " + fraze[j].Consoane() + " | " + "Vocale = " + fraze[j].Vocale());
			/*System.out.printf("N = %.2f " + " ", N);
			System.out.printf("p = %.2f " + " ", p);*/
			System.out.printf("M = %.2f " + " ", M);
			System.out.printf("P = %.4f " + " \n" , P);
			System.out.println("=-----------------------------------------------=");
		}
		System.out.println("{ Legenda }");
		System.out.println("M - Lungimea medie a cuvintelor");
		System.out.println("P - Pronuntabilitatea");
		System.out.println("M = (nr. vocale + nr. consoane) / nr. cuvinte");
		System.out.println("P = (nr. vocale / nr. consoane) * (1 / M)");
	}
}
