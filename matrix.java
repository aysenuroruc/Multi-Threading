 /* Matrix Multiplication with by multithreading */
 
 
  package paralell;
  import java.util.Scanner;
  import java.util.Random;
  import java.lang.Math;

     public class matrix3 {
    
    class Runner extends Thread {  //Thread sınıfından miras alındı

     public long[][] mult(long a[][], long b[][]){//a[m][n], b[n][p]

        if(a.length == 0) return new long[0][0];
        if(a[0].length != b.length) return null;

          int n = a[0].length;
          int m = a.length;
          int p = b[0].length;

          long ans[][] = new long[m][p];

             for(int i = 0;i<m/4;i++){ // 1.blok
                for(int j = 0;j<p;j++){
                   for(int k =0;k<n;k++){
                      ans[i][j] += a[i][k] * b[k][j];
                   }
                }
             }
          return ans;

              }
           }
        }
     
      class Runner extends Thread {

      private Scanner klavye;

      public static long[][] mult(long a[][], long b[][]){//a[m][n], b[n][p]

         if(a.length == 0) return new long[0][0];
         if(a[0].length != b.length) return null;

           int n = a[0].length;
           int m = a.length;
           int p = b[0].length;

                long ans[][] = new long[m][p];

               for(int i = m/4;i < m/2;i++){  // 2.blok 
                   for(int j = 0;j < p;j++){
                       for(int k = 0;k < n;k++){
            ans[i][j] += a[i][k] * b[k][j];
            
                 }
                }
               }
            return ans;

           }
      
           public static long[][] mult2(long a[][], long b[][]){//a[m][n], b[n][p]
 
              if(a.length == 0) return new long[0][0];
              if(a[0].length != b.length) return null;

              int n = a[0].length;
              int m = a.length;
              int p = b[0].length;

               long ans[][] = new long[m][p];

                 for(int i = m/2;i <3*m/4;i++){  // 3.blok
                    for(int j = 0;j < p;j++){
                       for(int k = 0;k < n;k++){
                    	   
                          ans[i][j] += a[i][k] * b[k][j];
                    }     
             }
       }    
             return ans;

       }
            public static long[][] mult1(long a[][], long b[][]){//a[m][n], b[n][p]

              if(a.length == 0) return new long[0][0];
              if(a[0].length != b.length) return null;

               int n = a[0].length;
               int m = a.length;
               int p = b[0].length;

                 long ans[][] = new long[m][p];

              for(int i = 3*m/4;i < m;i++){ // 4.blok
                  for(int j = 0;j < p;j++){
                      for(int k = 0;k < n;k++){
                    	  
                   ans[i][j] += a[i][k] * b[k][j];
              }
        }
  }
              
        return ans;
 }
            public static long[][] mult9(long a[][], long b[][],int x){//a[m][n], b[n][p]
            	 
                if(a.length == 0) return new long[0][0];
                if(a[0].length != b.length) return null;

                int n = a[0].length;
                int m = a.length;
                int p = b[0].length;

                 long ans[][] = new long[m][p];

                   for(int i =x;i <m;i=i+4){
                      for(int j = 0;j < p;j++){
                         for(int k = 0;k < n;k++){
                      	   
                            ans[i][j] += a[i][k] * b[k][j];
                     }     
                        }
         }
             return ans;
 }         
        public void main(String[] args) {

            klavye = new Scanner(System.in);

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
            Runner runner1= new Runner();  // ana class'ta runner nesneleri oluşturuldu . 
            Runner runner2= new Runner();
            Runner runner3= new Runner();
            Runner runner4= new Runner();

           runner1.start();         // threadlerin başlatılması
           runner2.start();
           runner3.start();
           runner4.start();
      }
    }
