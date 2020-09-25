package br.com.unipe.aula.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.unipe.aula.dao.TorcedorDAO;
import br.com.unipe.aula.web.model.Torcedor;

@Controller
public class WelcomeController {
	
	
	@Autowired
	private TorcedorDAO dao;

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value = "/outro", method = RequestMethod.GET)
	public ModelAndView outro() {
		ModelAndView v = new ModelAndView("parametro");
		v.addObject("mensagem", "View com parâmetro funcionando com sucesso!");
		return v;
	}

	@RequestMapping(value = "/time", method = RequestMethod.POST)
	public ModelAndView mandaForm(@ModelAttribute Torcedor torcedor) {
		ModelAndView v = new ModelAndView("formulario");
		v.addObject("mensagem", torcedor.getNome() + " torce para o " + torcedor.getTime());
		return v;
	}

	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public ModelAndView exibeForm(Model model) {
		model.addAttribute("torcedor", new Torcedor());
		return new ModelAndView("formulario");
	}
	
	@PostMapping(value = "/cadastro")
	public ModelAndView cadastrarTorcedor(@ModelAttribute Torcedor torcedor) {
		dao = new TorcedorDAO();
		dao.salvar(torcedor);
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Torcedor cadastrado com sucesso!");
		return view;
	}

}
