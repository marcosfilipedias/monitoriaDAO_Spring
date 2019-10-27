package com.java.modular.monitoria.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.java.modular.monitoria.models.CurriculumLattes;

public class CurriculumDao implements GenericDao<CurriculumLattes, Integer>{

	static final String ARCHIVE = "Curriculums.txt";
	@Override
	public CurriculumLattes get(Integer id) {
		CurriculumLattes c = null;
		try(BufferedReader bufferin = new BufferedReader(new FileReader(ARCHIVE))){
			String line;
			while((line = bufferin.readLine())!= null){
				String[] data = line.split(";");
				c = new CurriculumLattes();
				c.setId(Integer.parseInt(data[0]));
				c.setArticles(Boolean.parseBoolean(data[1]));
				c.setEstage(Boolean.parseBoolean(data[2]));
				c.setExtention(Boolean.parseBoolean(data[3]));
				c.setMonitor(Boolean.parseBoolean(data[4]));
				c.setTopAcademic(Boolean.parseBoolean(data[5]));
				
				if(id.equals(c.getId())) {
					return c;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void create(CurriculumLattes t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CurriculumLattes> read() throws FileNotFoundException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CurriculumLattes t) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CurriculumLattes t) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
	}

	
}
