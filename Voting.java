package in.raj;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Voting {
	private final Map<String, Integer> candidates = new HashMap<>();

	@RequestMapping(value = "/entercandidate", method = { RequestMethod.GET, RequestMethod.POST })
	public String enterCandidate(@RequestParam String name) {
		candidates.put("ajay", 0);
		candidates.put("arun", 0);

		return "Candidate " + name + " entered successfully!";
	}

	@RequestMapping(value = "/castvote", method = { RequestMethod.GET, RequestMethod.POST })
	public String castVote(@RequestParam String name) {
		if (candidates.containsKey(name)) {
			int currentVotes = candidates.get(name);
			candidates.put(name, currentVotes + 1);
			return "Vote cast for " + name + ". Total votes: " + (currentVotes + 1);
		} else {
			return "Invalid candidate name!";
		}
	}

	@GetMapping("/countvote")
	public String countVote(@RequestParam String name) {
		if (candidates.containsKey(name)) {
			return "Vote count for " + name + ": " + candidates.get(name);
		} else {
			return "Invalid candidate!";
		}
	}

	@GetMapping("/listvote")
	public Map<String, Integer> listVotes() {
		return candidates;
	}

	@GetMapping("/getwinner")
	public String getWinner() {
	    if (candidates.isEmpty()) {
	        return "No candidates available.";
	    }

	    Map.Entry<String, Integer> maxEntry = candidates.entrySet()
	            .stream()
	            .max(Map.Entry.comparingByValue())
	            .orElse(null);

	    if (maxEntry != null) {
	        long count = candidates.entrySet()
	                .stream()
	                .filter(entry -> entry.getValue().equals(maxEntry.getValue()))
	                .count();

	        if (count > 1) {
	            return "It's a tie!";
	        } else {
	            return "Winner: " + maxEntry.getKey();
	        }
	    } else {
	        return "No winner found.";
	    }
	}
}
