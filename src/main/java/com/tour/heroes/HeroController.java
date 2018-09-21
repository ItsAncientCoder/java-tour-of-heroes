package com.tour.heroes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/api/heroes" })
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class HeroController {

	List<Hero> listOfHeroes = new ArrayList<>();

	@PostConstruct
	private void loadHeroes() {
		Hero h1 = new Hero();
		h1.setId(0);
		h1.setName("prabhas");
		Hero h2 = new Hero();
		h2.setId(1);
		h2.setName("raana");
		listOfHeroes.add(h1);
		listOfHeroes.add(h2);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Hero> getListOfHeroes() {
		return listOfHeroes;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteHero(@PathParam("id") int id) {
		if (id < listOfHeroes.size()) {
			listOfHeroes.remove(id);
		} else {
			new Exception("No hero found to delete ");
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Hero getHero(@PathVariable(value = "id") int id) {
		Hero hero = null;
		if (id < listOfHeroes.size()) {
			hero = listOfHeroes.get(id);
		} else {
			new Exception("No hero found ");
		}
		return hero;
	}
}
