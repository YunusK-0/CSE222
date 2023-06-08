import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * it gets data from txt file that is given from main which is in TestClass.java
 */

public class CSE222Map
{
    private int[] startPosition;
    private int[] endPosition;
    private ArrayList<ArrayList<Integer>> map;
    BufferedImage image;
    String file;
    public CSE222Map(String inputFile)
    {
        try
        {
            Scanner scanner= new Scanner(new File(inputFile));
            startPosition= new int[2];
            endPosition = new int[2];
            map= new ArrayList<ArrayList<Integer>>();
            
            fill_start(scanner);
            fill_end(scanner);
            fill_map(scanner);

            System.out.println("Start -> " + startPosition[0] + " -- " + startPosition[1]);
            System.out.println("End -> " + endPosition[0] + " -- " + endPosition[1]);
            //System.out.println("map =>"+ map);

        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        file = inputFile;
    }

    private void fill_start(Scanner scanner)
    {
        scanner.useDelimiter(",|\\s+");
        int i=0;
        while(scanner.hasNextInt() && i<2)
        {
            startPosition[i] = scanner.nextInt();
            i++;
        }

    }
    private void fill_end(Scanner scanner)
    {
        int i=0;
        scanner.useDelimiter(",|\\s+");
        while(scanner.hasNextInt() && i<2)
        {
            endPosition[i] = scanner.nextInt();
            i++;
        }
    }
    /**
     * fill the map from the txt
     * @param scanner that takes input from txt
     */
    private void fill_map(Scanner scanner)
    {
        int i=0;
        /**
         * igonorlamak için var virgülü .
         */
        scanner.useDelimiter(",|\\s+");
        ArrayList<Integer> auxLine = new ArrayList<>();
        String auxChar;
        String[] auxArray;
        int auxNum;
        while(scanner.hasNext())
        {
            auxChar=scanner.nextLine();
            auxArray= auxChar.split(",");
            for(String iterate: auxArray)
            {
                if(!iterate.equals(""))
                {
                    auxNum = Integer.parseInt(iterate);
                    auxLine.add(auxNum);
                }
            }
            if(auxLine.size()!=0)
            {
                @SuppressWarnings("unchecked")
				ArrayList<Integer> colone = (ArrayList<Integer>) auxLine.clone();
                map.add(i,colone);
                auxLine.removeAll(auxLine);
                i++;
            }
        }
    }
    /**
     * map döndürüyor
     * @return map tipinde obje döndürüyor.
     */
	public ArrayList<ArrayList<Integer>> getMap()
	{
		return map;
	}
	public int getStart_x()
	{
		return startPosition[0];
	}
	public int getStart_y()
	{
		return startPosition[1];
	}
	public int getEndPosition_x()
	{
		return endPosition[0];
	}
	public int getEndPosition_y()
	{
		return endPosition[1];
	}
    /**
     * png burada oluşturyor.
     * @throws IOException nolur nolmaz.
     */
    public void convertPNG() throws IOException {
        int width = map.get(0).size();
        int height = map.size();
    
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixelValue = (map.get(y).get(x) == 1) ? 128 : 255;
                int rgb = (255 << 24) | (pixelValue << 16) | (pixelValue << 8) | pixelValue;
                image.setRGB(x, y, rgb);
            }
        }
    
        File outputFile = new File("image.png");
        try {
            ImageIO.write(image, "PNG", outputFile);
            System.out.println("Image saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving the image: " + e.getMessage());
        }
    }
    /**
     * çizgiyi burada çiziyorum
     * @param aux bu arraylisti okuyorum.
     * @throws IOException çalıştırmak için gerekli
     */
    public void drawLine(ArrayList<Integer> aux)throws IOException {
    
        for (int i = 0; i < aux.size(); i += 2) {
                int rgb = (255 << 16) | (0 << 8) | 0; // Red color (255, 0, 0)
                int x1 = aux.get(i + 1);
                int y1 = aux.get(i);
        
                if (x1 >= 0 && x1 < image.getWidth() && y1 >= 0 && y1 < image.getHeight()) {
                    image.setRGB(x1, y1, rgb);
                }
            }
        
    
    
        File outputFile = new File("imageResult.png");
        try {
            ImageIO.write(image, "PNG", outputFile);
            System.out.println("Image saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving the image: " + e.getMessage());
        }
    
    }
    public void writePath(ArrayList<Integer> aux) throws IOException
    {
        try(PrintWriter yazici = new PrintWriter(file+"DJIKSTRA.txt"))
        {
            for(int i =aux.size()-1;i>=0;i-=2)
            {
                yazici.print(aux.get(i-1));
                yazici.print(',');
                yazici.print(aux.get(i));
                yazici.print('\n');
            }
        }
        catch(IOException excep)
        {
            System.out.println(excep);
        }
    }
    
    
}