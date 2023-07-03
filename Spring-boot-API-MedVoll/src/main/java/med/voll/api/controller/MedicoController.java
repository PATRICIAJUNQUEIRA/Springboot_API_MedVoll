package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Carrega  e faz as atualizações do projeto
@RestController
@RequestMapping("medicos") 
public class MedicoController {
	
	@PostMapping
	public void cadastrar(@RequestBody String json) {
		System.out.println(json);
	}
}
