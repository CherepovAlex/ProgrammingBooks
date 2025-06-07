package exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GuessPage {
    private Integer attempts;
    private Integer maxAttempts;
    private boolean isWin;
    private String message;
}
