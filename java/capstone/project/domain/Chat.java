package capstone.project.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Chat {

    private int chatId;

    @NotEmpty
    private String memberId; //member ID, 외래키

    @NotEmpty
    private String chatDate; //채팅 날짜

    @NotEmpty
    private String chatTime; //채팅 시간

    @NotEmpty
    private String chatContent; //채팅 내용
}
