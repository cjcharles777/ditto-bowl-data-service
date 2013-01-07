/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdiddy.web.controller;

import cdiddy.objects.Player;
import cdiddy.utils.application.PlayerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author cedric
 */
@Controller
@RequestMapping("/players")
public class PlayerController 
{
    
    @Autowired
    PlayerService playerService;
    
    @RequestMapping(value = "/retrievePlayer/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Player retrievePlayer(@PathVariable("id") int playerid) 
    {
     return playerService.retrivePlayer(playerid);
    }
    
    @RequestMapping(value = "/retrievePlayer/playerkey/{key}", method = RequestMethod.GET)
    @ResponseBody
    public Player retrievePlayerWithKey(@PathVariable("key") String playerKey) 
    {
     return playerService.retrivePlayerWithPlayerKey(playerKey);
    }
    
    @RequestMapping(value = "/retrievePlayers/{firstResult}/{maxResults}", method = RequestMethod.GET)
    @ResponseBody
    public List<Player> retrievePlayers(@PathVariable("firstResult") int firstResult, @PathVariable("maxResults") int maxResults) 
    {
     return playerService.retrivePlayers(firstResult, maxResults) ;
    }
    
    
}
