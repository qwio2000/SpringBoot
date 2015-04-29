package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.model.Friends;
import demo.repository.GreetingRepository;

@Controller
public class GreetingController {
	
	@Autowired
	private GreetingRepository greetingRepository;
	
	@RequestMapping(value="/")
	public String indexMethod(Model model){
		List<Friends> friendList = greetingRepository.findAll();
		model.addAttribute("friendList", friendList);
		return "index";
	}
	@RequestMapping(value="/greeting")
	public String helloMethod(Model model,
			@RequestParam(value="name", required=false)String name,
			@RequestParam(value="userId",required=false)String userId){
		if(name != null && !name.isEmpty()){
			model.addAttribute("name", name);
		}else if(userId != null && !userId.isEmpty()){
			Friends friend = greetingRepository.findByUserId(userId);
			if(friend == null){
				friend = new Friends();
				friend.setName("처음보는분");
			}
			model.addAttribute("name",friend.getName());
		}else{
			model.addAttribute("name", "누구");
		}
		
		return "greeting";
	}
}
