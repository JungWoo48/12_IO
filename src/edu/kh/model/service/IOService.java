package edu.kh.model.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOService {
	
	//IO
	
	//Input(입력) : 데이터를 내부로 들여오는것
	
	//Output(출력) : 데이터를 외부로 내보내는것
	
	//Stream : 입출력 통로, 기본적으로 Stream은 일반통행
	
	
	//작성 흐름 외우기
	
	//1) 파일출력 ( 내부 == 프로그램, 외부 == 파일)
	public void output1() {
		//바이트 기반 스트림
		FileOutputStream fos = null;
		//null값을 주고 try catch문으로 예외를 잡아내야한다.
		
	
		//*******FileOutputStream fos = new FileOutputStream("test.txt");
		//-> FileOutputStream 객체 생성시 FileNotFoundException 예외가 발생 가능성이 있다
		//예외 처리가 필요******
		
		try {
			fos = new FileOutputStream("test1.txt");
			//현재 프로그램에서 text1.txt라는 외부 파일로의 통로(stream)을 만든것
			
			//이 파일은 목적지가 필요하다, 프로그램이 알아서 12_IO가 기본 목적지로 설정되어있다
			
			//파일에 "Hello" 보내기
			String str = "Hellow";
			
			for(int i = 0; i < str.length(); i++ ) {
				
				//System.out.println(str.charAt(i)); 이렇게 바로 출력하면 오류 발생 가능성이 있다.
				
				//"hello"를 한 문자씩 끊어서 파일로 출력하기
				fos.write(str.charAt(i) );
				//Unhandled exception type IOException
				//write() 는 IOException을 발생시킬 가능성이 있다
				//밑에서 catch로 잡아줘야 한다
				
			}
			
		}catch(IOException e) {
			//*******FileNotFoundException 는 IOException의 자식 객체로 둘다 잡기 가능
			
		
			System.out.println("예외 발생");
			e.printStackTrace();//예외 발생 추적
			
		}finally {
			//예외가 밠갱 하든말든 무조건 수행
			
			//쓸데없는 통로 지우기
			//자원 반환
			
			//*********사용한 스트림 자원 반환(통로 끊기)--> 필수 작성
			//프로그램 메모리 관리차원에서 항상 필요
			//비작성시 문제 생김
			
			
		}try {
			fos.close();//통로 끊기
			
		}catch (IOException e) {
			e.printStackTrace();
		}
			
	
	}
	
	public void input1() {
		//파일 입력 외부 파일 들여오기
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("test1.txt");
			
			//FileInputStream은 1byte씩만 읽어 올수 있다
			
			while(true) { 
				
				int data = fis.read(); // 다음 1byte를 읽어오는 정수형
									   // 다음 내용이 없다면 -1반환
										//유니코드 이기때문에 int형인것
				
				if(data == -1 ) {//다음 내용이 없으면 -1이 대입되고 종료된다
					break;
				}
				//반복 종료가 안됬다면 char로 강제 형변환후 문자로 출력
				System.out.print((char)data);
				
				
				
			}
			
			
		
		}catch (IOException e) {
			e.printStackTrace();//예외 추적
			
			
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//--------------------------------------
	}
	//문자 기반 스트림
	
	//3) 파일 출력(문자 기반)
	public void output2() {
	
		FileWriter fw = null;// 프로그램에 서 파일로 쓰는 문자 기반 스트림
		
		try {
			
			fw = new FileWriter("test1.txt", true);//외부와 연결하는 스트림 객체 생성
			//뒤에 매개변수로 true가 있으면 메모장에 계속 이어써진다
			
			String str = "안녕하세요. Hello. 124. !#";
			
			fw.write(str);
			
			
		}catch(IOException e) {
			e.printStackTrace();
			
			
		}finally {
			
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
	}
	
	public void input2() {
		
		FileReader fr = null;
		
		try {
			fr= new FileReader("test1.txt");//통로 객체 생성	
			
			while(true) {
				
				int data = fr.read(); //다음 문자 읽기 없으몀 -1
				
				
				if(data == -1) {
					break;
				}
				
				System.out.print((char)data);
			}
			
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				fr.close();//통로 끊기
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
	

}
