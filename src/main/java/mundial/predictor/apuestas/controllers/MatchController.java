package mundial.predictor.apuestas.controllers;

import mundial.predictor.apuestas.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    private MatchService matchService;

    /**
     ** POST /api/match/create-match
     **/
    @PostMapping("/create-match")
    public ResponseEntity<Map<String, Object>> createMatch(@RequestParam int homeTeamId,
                                                           @RequestParam int awayTeamId,
                                                           @RequestParam String kickOffTime,
                                                           @RequestParam int matchStatusId,
                                                           @RequestParam int matchStageId,
                                                           @RequestParam String opensAt,
                                                           @RequestParam String closesAt,
                                                           @RequestParam int isLocked) {
        try {
            Map<String, Object> newMatch = matchService.createMatch(homeTeamId, awayTeamId, kickOffTime, matchStatusId, matchStageId, opensAt, closesAt, isLocked);
            return ResponseEntity.ok(newMatch);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     ** PUT /api/match/update-match
     **/
    @PutMapping("/update-match")
    public ResponseEntity<Map<String, Object>> updateMatch(@RequestParam int matchId,
                                                           @RequestParam int homeScore,
                                                           @RequestParam int awayScore,
                                                           @RequestParam int penalties,
                                                           @RequestParam int winnerTeamId,
                                                           @RequestParam int matchStatusId,
                                                           @RequestParam int isLocked) {
        try {
            Map<String, Object> updatedMatchResult = matchService.updateMatchResult(matchId, homeScore, awayScore, penalties, winnerTeamId, matchStatusId, isLocked);
            return ResponseEntity.ok(updatedMatchResult);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     ** GET /api/match/all
     **/
    @GetMapping("/all")
    public ResponseEntity<List<Map<String, Object>>> getMatches() {
        try {
            List<Map<String, Object>> matches = matchService.getMatches();
            return ResponseEntity.ok(matches);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     ** GET /api/match/by-home-tam
     **/
    @GetMapping("/by-home-tam")
    public ResponseEntity<List<Map<String, Object>>> getMatchesByHomeTeam(@RequestParam int countryId) {
        try {
            List<Map<String, Object>> matches = matchService.getMatchesByHomeTeam(countryId);
            return ResponseEntity.ok(matches);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     ** GET /api/match/by-away-tam
     **/
    @GetMapping("/by-away-tam")
    public ResponseEntity<List<Map<String, Object>>> getMatchesByAwayTeam(@RequestParam int countryId) {
        try {
            List<Map<String, Object>> matches = matchService.getMatchesByAwayTeam(countryId);
            return ResponseEntity.ok(matches);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     ** GET /api/match/by-date
     **/
    @GetMapping("/by-date")
    public ResponseEntity<List<Map<String, Object>>> getMatchesByDate(@RequestParam String date) {
        try {
            List<Map<String, Object>> matches = matchService.getMatchesByDate(date);
            return ResponseEntity.ok(matches);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     ** GET /api/match/unlocked
     **/
    @GetMapping("/unlocked")
    public ResponseEntity<List<Map<String, Object>>> getMatchesUnlocked() {
        try {
            List<Map<String, Object>> matches = matchService.getMatchesUnlocked();
            return ResponseEntity.ok(matches);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     ** GET /api/match/unlocked
     **/
    @GetMapping("/locked")
    public ResponseEntity<List<Map<String, Object>>> getMatchesLocked() {
        try {
            List<Map<String, Object>> matches = matchService.getMatchesLocked();
            return ResponseEntity.ok(matches);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     ** PUT /api/match/unlock
     **/
    @PutMapping("/unlock")
    public ResponseEntity<Map<String, Object>> unlockMatch(@RequestParam int matchId) {
        try {
            Map<String, Object> unlockedMatch = matchService.unlockMatch(matchId);
            return ResponseEntity.ok(unlockedMatch);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     ** PUT /api/match/lock
     **/
    @PutMapping("/lock")
    public ResponseEntity<Map<String, Object>> lockMatch(@RequestParam int matchId) {
        try {
            Map<String, Object> lockedMatch = matchService.lockMatch(matchId);
            return ResponseEntity.ok(lockedMatch);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
