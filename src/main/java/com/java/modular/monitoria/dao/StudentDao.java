package com.java.modular.monitoria.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.java.modular.monitoria.models.Student;

public class StudentDao implements GenericDao<Student, Integer> {

	static final String ARCHIVE = "Students.txt";
	static final String SEQUENCE = "StudentID.txt";
	CurriculumDao c = new CurriculumDao();
	RecordDao sr = new RecordDao();

	@Override
	public Student get(Integer id) {
		Student s = null;
		try (BufferedReader bufferin = new BufferedReader(new FileReader(ARCHIVE))) {
			String line;
			while ((line = bufferin.readLine()) != null) {
				String[] data = line.split(";");
				s = new Student();
				s.setRegister(Integer.parseInt(data[0]));
				s.setName(data[1]);
				s.setEmail(data[2]);
				s.setContact(data[3]);
				s.setStreat(data[4]);
				s.setRecord(sr.get(s.getId()));
				s.setCurriculum(c.get(s.getId()));

				if (id.equals(s.getId())) {
					return s;
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
	public void create(Student t) {
		try {
			BufferedReader bufferInSequence = new BufferedReader(new FileReader(SEQUENCE));
			BufferedWriter bufferOutStudent = new BufferedWriter(new FileWriter(ARCHIVE, true));

			Integer idGerator;
			String line = bufferInSequence.readLine();
			if (line != null) {
				idGerator = Integer.parseInt(line);
				bufferInSequence.close();
				BufferedWriter bufferOutSequence = new BufferedWriter(new FileWriter(SEQUENCE, false));
				bufferOutSequence.write(Integer.toString(idGerator + 1));
				bufferOutSequence.flush();
				bufferOutSequence.close();
			} else {
				idGerator = 1;
				BufferedWriter bufferOutSequence = new BufferedWriter(new FileWriter(SEQUENCE, false));
				bufferOutSequence.write(Integer.toString(idGerator + 1));
				bufferOutSequence.flush();
				bufferOutSequence.close();
			}
			String lineSeparator = ";";
			bufferOutStudent.write(idGerator + lineSeparator);
			bufferOutStudent.write(t.getRegister() + lineSeparator);
			bufferOutStudent.write(t.getName() + lineSeparator);
			bufferOutStudent.write(t.getContact() + lineSeparator);
			bufferOutStudent.write(t.getEmail() + lineSeparator);
			bufferOutStudent.write(t.getStreat() + lineSeparator);
			bufferOutStudent.write(t.getCurriculum() + lineSeparator);
			bufferOutStudent.write(t.getRecord() + "");
			bufferOutStudent.write(System.getProperty("line.separator"));
			bufferOutStudent.flush();
			bufferOutStudent.close();
			
		} catch (Exception e) {
			System.out.println("ERRO ao gravar o aluno no disco!");
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> read() throws FileNotFoundException, NumberFormatException, IOException {
		List<Student> listStudent = new ArrayList<Student>();
		Student s = null;
		BufferedReader bufferin = new BufferedReader(new FileReader(ARCHIVE));
		String line = null;
		while ((line = bufferin.readLine()) != null) {
			String[] dados = line.split(";");

			s = new Student();
			s.setId(Integer.parseInt(dados[0]));
			s.setRegister(Integer.parseInt(dados[1]));
			s.setName(dados[2]);
			s.setContact(dados[3]);
			s.setEmail(dados[4]);
			s.setStreat(dados[5]);
			s.setCurriculum(c.get(s.getId()));
			s.setRecord(sr.get(s.getId()));
			listStudent.add(s);
		}
		bufferin.close();
		return listStudent;
	}

	@Override
	public void update(Student t) throws NumberFormatException, IOException {
		List<Student> student = read();
		int index = student.indexOf(t);
		if (index != -1) {
			student.set(index, t);
			saveToFile(student);
		}
	}

	@Override
	public void delete(Student t) throws NumberFormatException, IOException {
		List<Student>student = read();
		int index = student.indexOf(t);
		if (index != -1) {
			student.remove(index);
			saveToFile(student);
		}
	}
	
	public void saveToFile(List<Student> list) throws IOException {
		BufferedWriter bufferOut = new BufferedWriter(new FileWriter(ARCHIVE, false));
		String lineSeparator = ";";
		for (Student s : list) {
			bufferOut.write(s.getId() + lineSeparator);
			bufferOut.write(s.getRegister() + lineSeparator);
			bufferOut.write(s.getName() + lineSeparator);
			bufferOut.write(s.getContact() + lineSeparator);
			bufferOut.write(s.getEmail() + lineSeparator);
			bufferOut.write(s.getStreat() + lineSeparator);
			bufferOut.write(s.getCurriculum() + lineSeparator);
			bufferOut.write(s.getRecord() + "");
			bufferOut.write(System.getProperty("line.separator"));
			bufferOut.flush();

		}
		bufferOut.close();
	}

}
