package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Convidado;
import com.example.demo.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService convidadoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidado> convidados = convidadoService.findAll();

		model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {
		Convidado convidado = new Convidado(null, nome, email, telefone);

		convidadoService.insert(convidado);
		
			

		return this.listaConvidados(model);
	}
}
