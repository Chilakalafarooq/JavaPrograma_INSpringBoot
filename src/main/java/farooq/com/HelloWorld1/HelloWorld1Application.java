package farooq.com.HelloWorld1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloWorld1Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorld1Application.class, args);
	}
	
	//http://localhost:8383/farooq?name=
		@GetMapping("/farooq")
		public String hello(@RequestParam("name") String name) {
			return "hi " + name + "  ..how are you!";
		}

		//Remove duplicate elements
		//http://localhost:8383/api/remove-duplicates?arr=1,2,3,3,4,5,6,6,6,6,
		@GetMapping("/api/remove-duplicates")
	//[1,2,3,4,5,6]

		int[] RemoveDuplicateArray(@RequestParam int[] arr) {
			int[] array = Arrays.stream(arr).distinct().toArray();
			return array;

		}

		//http://localhost:8383/api/array-duplicatElements/1,2,3,3,4,4,4,4,5,5,5,5,6,7,7,7
		@GetMapping("/api/array-duplicatElements/{arr}")
		String removeduplicate(@PathVariable long[] arr) {
			long[] array = Arrays.stream(arr).distinct().toArray();
			String output = Arrays.stream(array).
					mapToObj(String::valueOf).collect(Collectors.joining(","));
			return output;
		}

		//http://localhost:8383/api/reverse-String/Chilakala farooq
		@GetMapping("/api/reverse-String/{string}")

		public StringBuilder ReverseString(@PathVariable String string) {
			StringBuilder stringBuilder = new StringBuilder(string).reverse();
			return stringBuilder;
		}

		//
		@GetMapping("/api/Max-Min/farooq/{arr}")
		public String maxminvalues(@PathVariable int[] arr) {
			int n = arr.length;
			// Here ia m sorting the array in ascending order
			Arrays.sort(arr);
			//Find firstmax & firstmin values
			//http://localhost:8383/api/Max-Min/farooq/100,91,80,81,70,71,60,61,50,51,40,41,30,31,20,21,10
//			int firstmax= arr[n-1];
//			int firstmin= arr[0];
//			return firstmax+","+firstmin;
			//100,10


			//Find secondmax & secondmin values
			//http://localhost:8383/api/Max-Min/farooq/100,91,80,81,70,71,60,61,50,51,40,41,30,31,20,21,10
//			int secondmax =arr[n-2];
//			int secondmin = arr[1];
//			return secondmax+","+secondmin;
			//91,20

	//
//			//Find thirdmax & thirdmin values
//			//http://localhost:8383/api/Max-Min/farooq/100,91,80,81,70,71,60,61,50,51,40,41,30,31,20,21,10
//			int thirdmax =arr[n-3];
//			int thirdmin = arr[2];
//			return thirdmax+","+thirdmin;
//			//81,21

			//Find fourthmax & fourthmin values
			//http://localhost:8383/api/Max-Min/farooq/100,91,80,81,70,71,60,61,50,51,40,41,30,31,20,21,10
			int fourthmax = arr[n - 4];
			int fourthmin = arr[3];
			return fourthmax + "," + fourthmin;
			//80,30
		}

		//Array Sorting
		//Using @Pathvariable
		//http://localhost:8383/array-sort/farooq/23,4,56,78,90,1,2,3,45,78
		@GetMapping("/array-sort/farooq/{ArrayNumbers}")
		String Array_Sorting(@PathVariable String ArrayNumbers) {
			String[] Numbers = ArrayNumbers.split(",");
			long[] arr = new long[Numbers.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(Numbers[i]);
			}
			Arrays.sort(arr);
			return Arrays.toString(arr);
			//[1, 2, 3, 4, 23, 45, 56, 78, 78, 90]
		}
		//Array Sorting along with remove duplicate elements
		//Using @Pathvariable
		//http://localhost:8383/api/array-sort/farooq/23,4,56,78,90,1,2,3,45,78,100,78,22,34,22,12,23
		@GetMapping("/api/array-sort/farooq/{k}")
		String Array_Sort(@PathVariable String k) {
			String[] x = k.split(",");
			int[] arr = new int[x.length];
			for (int i = 0; i < x.length; i++) {
				arr[i] = Integer.parseInt(x[i]);
			}
			Arrays.sort(arr);
			Set<Integer> set  = new LinkedHashSet<>();
			for (int i:arr) {
				 set.add(i);
			}
			return set.toString();
			//return Arrays.toString(arr);
			//input -23,4,56,78,90,1,2,3,45,78,100,78,22,34,22,12,23
			//output -[1, 2, 3, 4, 12, 22, 23, 34, 45, 56, 78, 90, 100]
		}
	//http://localhost:8383/pattern/15http://localhost:8383/pattern/15
			@GetMapping("/pattern/{rows}")
			public String printPattern(@PathVariable int rows) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j <= i; j++) {
						sb.append("* ");
					}
					sb.append("\n");
				}
				return sb.toString();
			}
		}

	

