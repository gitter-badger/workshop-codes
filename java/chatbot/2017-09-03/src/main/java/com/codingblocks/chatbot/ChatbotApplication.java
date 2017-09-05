package com.codingblocks.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@SpringBootApplication
public class ChatbotApplication {

	@GetMapping("/webhook")
	@ResponseBody
	public String verify(@RequestParam("hub.challenge") String challenge,
						 @RequestParam("hub.verify_token") String token){
		String t = "76783489768943768946967847638";
		if(t.equals(token)){
			return challenge;
		}
		return "fake";
	}

	@PostMapping("/webhook")
	@ResponseBody
	public void Hook(@RequestBody Hook hook){


		for(Hook.Item item : hook.entry) {
			for (Content i : item.messaging) {


				Response response = new Response();
				response.recipient = i.sender;
				response.message = i.message;

				if (response.message.text == null) {
					response.message.text = "Thanks for your attachment";
				} else {
					String data = response.message.text;

					if(data.contains("joke")){
						Jokes jokes = new Jokes();
						int random = (int) (Math.random() * jokes.jokes.size());
						response.message.text = (new Jokes()).jokes.get(random);
					} else {
						response.message.text = "Please please ask me to tell a joke";
					}
				}

				RestTemplate restTemplate = new RestTemplate();
				String url = "https://graph.facebook.com/v2.6/me/messages/";
				String access_token = "EAAVZCYbgrbjcBAFbYhK1eBb08RW54PfjjGeibGgNQKRNBm8DWAZBIhW6ZCr9rhBkQiZAdY48soAOgbcZBjzmnxNPbqIK8tRBN5ZB4hNEnn4CJEx0oOE6WmOxpuuREqcauttx2m6nP3Hg6J01uti9mClxeSJRhCuPiViJOOBqZBTH4KiRp42JXIV";
				// Query parameters
				UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
						// Add query parameter
						.queryParam("access_token", access_token);

				UriComponents components = builder.build();

				restTemplate.postForObject(components.toString(),response, String.class);
			}
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(ChatbotApplication.class, args);
	}
}
