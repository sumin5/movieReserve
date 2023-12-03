package com.ezen.movie;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieApplicationTests {
	
	 public static void main(String[] args) {
	      int[][] dot = {{10, 1}, {9, 3}, {2, 2}, {4, 4}};
	      
	      
	      int answer = 0;
	      
	      for(int j=0; j<3; j++) {
	    	  
	    	  if(answer == 1 ) {
	    		  break;
	    	  }
	    	  int[] firstRow = dot[0];

	          // 배열의 첫 번째 배열을 맨 뒤로 이동
	          for (int i = 0; i < dot.length - 1; i++) {
	              dot[i] = dot[i + 1];
	          }

	          dot[dot.length - 1] = firstRow;
	          
	          answer = solution(dot);
	      }
	    
	    System.err.println("정답은 ? " + answer);

	   }
	   
	   
	   public static int solution(int[][] dots) {
	        int answer1 = 0;
	        
	        int x1 = dots[0][0];
	        int x2 = dots[1][0];
	        int x3 = dots[2][0];
	        int x4 = dots[3][0];

	        
	        int y1= dots[0][1];
	        int y2= dots[1][1];
	        int y3= dots[2][1];
	        int y4= dots[3][1];
	        
	        
	        double a = Math.abs(y2-y1)/Math.abs(x2-x1) ;
	        double b = Math.abs(y4-y3)/Math.abs(x4-x3) ;
	        
	        if(a==b) {
	        	answer1 = 1;
	        }
	        
	        System.err.println(answer1);
	        return answer1;
	    }
	@Test
	void contextLoads() {
	}

}
