package com.tour.heroes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/api" })
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class HeroController {

	List<Hero> listOfHeroes = new ArrayList<>();

	@RequestMapping(value = "/heroes", method = RequestMethod.GET)
	public List<Hero> getListOfHeroes() {

		Hero h1 = new Hero();
		h1.setId(1);
		h1.setName("prabhas");

		Hero h2 = new Hero();
		h2.setId(2);
		h2.setName("raana");

		listOfHeroes.add(h1);
		listOfHeroes.add(h2);

		return listOfHeroes;
	}
}
