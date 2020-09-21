package br.com.unipe.aula.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unipe.aula.web.model.Torcedor;

@Controller
public class WelcomeController {

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

}
