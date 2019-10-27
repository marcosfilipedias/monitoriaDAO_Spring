package com.java.modular.monitoria.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.java.modular.monitoria.models.SchoolRecord;

public class RecordDao implements GenericDao<SchoolRecord, Integer> {

	static final String ARCHIVE = "Records.txt";
	@Override
	public SchoolRecord get(Integer id) {
		SchoolRecord sr = null;
		try(BufferedReader bufferin = new BufferedReader(new FileReader(ARCHIVE))){
			String line;
			while((line = bufferin.readLine())!= null){
				String[] data = line.split(";");
				sr = new SchoolRecord();
				sr.setStudentId(Integer.parseInt(data[0]));
				sr.setSubject(data[1]);
				sr.setGrade(Integer.parseInt(data[2]));
				if(id.equals(sr.getStudentId())){
					return sr;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void create(SchoolRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SchoolRecord> read() throws FileNotFoundException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SchoolRecord t) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SchoolRecord t) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
	}

}
