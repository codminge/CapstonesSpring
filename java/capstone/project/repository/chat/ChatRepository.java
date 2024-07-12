package capstone.project.repository.chat;

import capstone.project.domain.Chat;

import java.util.List;

public interface ChatRepository {

    int findLargestChatId();

    void memberChatSave(Chat memberChat);

    void aiChatSave(Chat aiChat);

    List<Chat> findById(Integer chatId);

    List<Chat> findByMemberId(String memberId);
}
