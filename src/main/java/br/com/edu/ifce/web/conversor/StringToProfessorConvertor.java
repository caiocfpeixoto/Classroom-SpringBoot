package br.com.edu.ifce.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.edu.ifce.domain.Professor;
import br.com.edu.ifce.service.ProfessorService;

@Component
public class StringToProfessorConvertor implements Converter<String, Professor>{

	@Autowired
	private ProfessorService service;
	
	@Override
	public Professor convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
