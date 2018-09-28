package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Convidado;
import com.example.demo.service.ConvidadoService;
import com.example.sendemail.service.EmailService;

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
	public ModelAndView listaConvidados(Model model) {
		Iterable<Convidado> convidados = convidadoService.findAll();

		model.addAttribute("convidados", convidados);

		return new ModelAndView("listaconvidados");
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {
		Convidado convidado = new Convidado(null, nome, email, telefone);

		convidadoService.insert(convidado);
		
		new EmailService().send(nome, email);

		return new ModelAndView("redirect:/listaconvidados");
	}
}
