package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class no3 {
	
	static int number = 325489;
	static int dimension = (int)Math.ceil(Math.sqrt(number));
	static int[][] a = new int[dimension+2][dimension+2];
	
	public static int get(int x, int y) {
		int value = 0;
		
		for(int i = y-1; i <= y+1;i++) {
			for(int j = x-1; j <= x+1; j++) {
				if(i<0 || j< 0)
					continue;
				//System.out.println(j + " " + i);
				value+= a[i][j];
			}
		}
		
		return value;
	}
	
	public static void main(String[] args) {
		
		int value = 0;
		int value2 = 0;
		
		
		
		int mid = (int)Math.floor(dimension/2);
		int x,y,s=3,c=1;
		x=y=mid;
		
		a[y][x++] = 1;c++;
		boolean br = false;
		while(s <= dimension) {
			//next
			//up
			for(int i=0; i < s-2; i++) {
				a[y][x] = get(x,y);c++;
				y--;
				if(number == c) {
					br=true;
					break;
				}
			}
			if(br)break;
			//left
			for(int i=0; i < s-1; i++){
				a[y][x] = get(x,y);c++;
				x--;
				if(number == c) {
					br=true;
					break;
				}
			}
			if(br)break;
			//down
			for(int i=0; i < s-1; i++) {
				a[y][x] = get(x,y);c++;
				y++;
				if(number == c) {
					br=true;
					break;
				}
			}
			if(br)break;
			//right
			for(int i=0; i < s; i++){
				a[y][x] = get(x,y);c++;
				x++;
				if(number == c) {
					br=true;
					break;
				}
			}
			if(br)break;
			
			s+=2;
		}
		value = Math.abs(x - mid) + Math.abs(y - mid);
		
		s=3;c=1;
		x=y=mid;
		x++;
		br = false;
		while(s <= dimension) {
			//next
			//up
			for(int i=0; i < s-2; i++) {				
				if(a[y][x] > number) {
					value2 = a[y][x];
					br=true;break;
				}
				y--;
			}
			if(br)break;
			//left
			for(int i=0; i < s-1; i++){
				if(a[y][x] > number) {
					value2 = a[y][x];
					br=true;break;
				}
				x--;
			}
			if(br)break;
			//down
			for(int i=0; i < s-1; i++) {
				if(a[y][x] > number) {
					value2 = a[y][x];
					br=true;break;
				}
				y++;
			}
			if(br)break;
			//right
			for(int i=0; i < s; i++){
				if(a[y][x] > number) {
					value2 = a[y][x];
					br=true;break;
				}
				x++;
			}
			if(br)break;
			
			s+=2;
		}
		/*
		for(int i = 0; i < dimension; i++) {
			for(int j = 0; j< dimension; j++)
				//System.out.print(a[i][j]+" ");
			//System.out.println();
		}
		**/
		System.out.println(value);
		System.out.println(value2);
	}
}
