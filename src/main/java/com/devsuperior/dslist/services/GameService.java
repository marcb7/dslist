package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

// @Service => vai registrar a classe GameService como sendo um componente do sistema
@Service
public class GameService {

	@Autowired
	private GameRepository gameRepositoy;

	// Método que devolve uma lista de objetos DTO
	public List<GameMinDTO> findAllGames() {
		// trazer do banco de dados uma lista de games
		List<Game> result = gameRepositoy.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
		// stream() => é uma lib do Java que permite fazer operações com sequências de dados. A operação .map() transforma objetos de uma coisa para outra.
		// No caso acima, todo objeto x original, que era Game, eu quero transformar em um new GameMinDTO.
	}
}
