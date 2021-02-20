
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.security.SecureRandom;

public class Main
{
	public static void main(String[] args) {
	    int sizeList;
	    Scanner in = new Scanner(System.in);
	    
	    do {
            	System.out.print("Enter a size list: \n");
            	sizeList = in.nextInt();
	    } while (sizeList == 0);

	    ArrayList<int[]> list = createList(sizeList);
	    for (int[] array : list) {
		     System.out.println(Arrays.toString(array)+"\n");
	    }

	    in.close();
	    list.clear();
	}
	
	public static ArrayList<int[]> createList(int n) {
		ArrayList<int[]> list = new ArrayList<>();
		int[] sizeArrays = new int[n];
		int sizeArr;
		boolean checkUnq;
		Random random = new Random();

		for (int idx=0; idx<n; idx++){
		    // каждый массив имеет случайный размер
		    sizeArr = random.nextInt(100) + 1; 
		    //  Размеры массивов не должны совпадать
		    checkUnq = checkUnique(sizeArrays, sizeArr, idx);
		    if (checkUnq==false){
		       do {
			    sizeArr = random.nextInt(100) + 1;
			    checkUnq = checkUnique(sizeArrays, sizeArr, idx);
		       } while (checkUnq == false);
		   }
		    sizeArrays[idx] = sizeArr;  
		};
		//сгенерировать n-массивов
		for(int i=0;i<n;i++){
		    int[] arr = new int[sizeArrays[i]];
		    //заполнить их случайными числами
		    for(int j = 0;j<arr.length;j++){
			arr[j] = random.nextInt(100) + 1;
		    }
		    //Массивы с четным порядковым номером отсортировать по возрастанию, с нечетным порядковым номером - по убыванию
		   Arrays.sort(arr); 
		   if (i%2 != 0){
		      reversArray(arr);
		    }
		   list.add(arr);
		}
		return list;
    }
    
    public static void reversArray(int[] arr){
        int tmp;
        for (int i = arr.length-1, j = 0; i >=arr.length/2 ; i--,j++) {
            tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
    }
    
    public static boolean checkUnique(int[] arr, int var, int n){
        for(int i=0;i<n;i++){
           if (var == arr[i]) {
               return false;
           } 
        }
        return true;
    }
}
