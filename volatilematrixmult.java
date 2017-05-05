package paralell;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class matrix2 {
	public static long[][] mult(long a[][], long b[][]){//a[m][n], b[n][p]
		
		   if(a.length == 0) return new long[0][0];
		   if(a[0].length != b.length) return null;
		 
		   int n = a[0].length;
		   int m = a.length;
		   int p = b[0].length;
		 
		  long sonuc[][] = new long[m][p];
		 
		   for(int i = 0;i < m;i++){
		      for(int j = 0;j < p;j++){
		         for(int k = 0;k < n;k++){
		            sonuc[i][j] += a[i][k] * b[j][k];// 1.versiyona ek olarak j ve k yer değiştirmiş olup paralellik, yerel lokallik sağndı.
		         }
		      }
		   }
		   return sonuc;  
		  
		}
	
	public static void main(String[] args) {
    Scanner klavye = new Scanner(System.in);

    System.out.println("Boyutu Giriniz : ");

    int boyut = klavye.nextInt();
    
    long matris1 [][] = new long [boyut][boyut];

    long matris2 [][] = new long [boyut][boyut];

    for (int i = 0; i < boyut ; i++) {

        for (int j = 0; j < boyut; j++) {

            int random1 = (int)(Math.random()*10);

            int random2 = (int)(Math.random()*10);

            matris1[i][j] = random1;

            matris2[i][j] = random2;  
        }
    }
  long startTime=System.currentTimeMillis();
    
 mult(matris1,matris2);
 
    long endTime=System.currentTimeMillis();
	   
	   long estimatedTime=endTime-startTime;
	   
	   double seconds=(double)estimatedTime/1000;
	   
	   System.out.println(seconds+"saniyedir");
 }
}
