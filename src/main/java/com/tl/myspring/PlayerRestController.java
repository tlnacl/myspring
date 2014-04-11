package com.tl.myspring;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

import com.tl.myspring.BooksRestController.BookNotFoundException;
import com.tl.myspring.model.Book;
import com.tl.myspring.model.Player;
import com.tl.myspring.model.PlayerRepository;

@Controller
@RequestMapping("/players")
public class PlayerRestController {

	@Autowired
	PlayerRepository playerRepository;
	
	  @RequestMapping(method = RequestMethod.GET)
	  public @ResponseBody List<Player> list() {
	    return (List<Player>) this.playerRepository.findAll();
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public @ResponseBody Player find(@PathVariable("id") int id) {
	    Player player = this.playerRepository.findOne(id);
	    if (player == null) {
	      throw new PlayerNotFoundException(id);
	    }
	    return player;
	  }

	  @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"})
	  @ResponseStatus(HttpStatus.CREATED)
	  public HttpEntity<?> create(@RequestBody Player player, @Value("#{request.requestURL}") StringBuffer parentUri) {
	    player = this.playerRepository.save(player);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(childLocation(parentUri, player.getId()));
	    return new HttpEntity<Object>(headers);
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void delete(@PathVariable("id") int id) {
	    this.playerRepository.delete(id);
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void update(@PathVariable("id") Integer id, @RequestBody Player player) {
	    player.setId(id);
	    this.playerRepository.save(player);
	  }


	  private URI childLocation(StringBuffer parentUri, Object childId) {
	    UriTemplate uri = new UriTemplate(parentUri.append("/{childId}").toString());
	    return uri.expand(childId);
	  }

	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  public class PlayerNotFoundException extends RuntimeException {
	    public PlayerNotFoundException(int id) {
	      super("Player '" + id + "' not found.");
	    }
	  }
}
