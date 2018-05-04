package com.example.websocket.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;

import com.example.websocket.vo.D1;

public class CSVFileReader {
//	public static void main(String[] args) {
//		List<D1> expectList = new ArrayList<D1>();
//		D1 d = new D1();
//		d.setFlightNo("CA0001");
//		d.setToCityZH("昆明");
//		d.setCounterNo("D");
//		d.setStatusZH("延误");
//		expectList.add(d);
//		D1 dd = new D1();
//		dd.setFlightNo("CA0002");
//		dd.setToCityZH("上海");
//		dd.setCounterNo("E");
//		dd.setStatusZH("已起飞");
//		expectList.add(dd);
//
//		List<String> lists = readCSVFile(System.getProperty("user.dir")
//				+ "\\src\\test\\resources\\data\\d1\\testFlightsDisplayedInNext4Hours_expect.csv");
//		List<D1> d1List=new ArrayList<D1>();
//		for (String list : lists) {
//			String[] elements = list.split(",");
//			D1 d1 = new D1();
//			d1.setFlightNo(elements[0]);
//			d1.setToCityZH(elements[1]);
//			d1.setCounterNo(elements[2]);
//			d1.setStatusZH(elements[3]);
//			d1List.add(d1);
//		}
//	}

	public static List<String> readCSVFile(String filePath) throws UnsupportedEncodingException {
		File csv = new File(filePath); // CSV文件路径
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(csv), "UTF-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = "";
		List<String> lines = new ArrayList<String>();
		try {
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lines.remove(0);
		return lines;
	}
}
