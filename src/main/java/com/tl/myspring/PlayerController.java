package com.tl.myspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tl.myspring.model.Book;
import com.tl.myspring.model.Player;
import com.tl.myspring.model.PlayerRepository;

@Controller
@RequestMapping("/playersweb")
public class PlayerController {

	@Autowired
	PlayerRepository playerRepository;
	
	  @RequestMapping(method = RequestMethod.GET)
	  public @ResponseBody List<Player> list() {
	    return (List<Player>) this.playerRepository.findAll();
	  }
}
