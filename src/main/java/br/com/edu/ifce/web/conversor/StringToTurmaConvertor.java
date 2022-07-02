package br.com.edu.ifce.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.edu.ifce.domain.Turma;
import br.com.edu.ifce.service.TurmaService;

@Component
public class StringToTurmaConvertor implements Converter<String, Turma>{

	@Autowired
	private TurmaService turmaService;
	
	@Override
	public Turma convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return turmaService.buscarPorId(id);
	}

}
