package capstone.project.service.emotion;

import capstone.project.domain.Emotion;
import capstone.project.repository.emotion.EmotionRepository;
import capstone.project.repository.emotion.EmotionUpdateApiDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmotionService {

    private final EmotionRepository emotionRepository;

    // 감정을 저장하는 메서드
    public Emotion save(Emotion emotion) {
        return emotionRepository.save(emotion);
    }

    // 감정을 수정하는 메서드
    public void update(Integer diaryId, EmotionUpdateApiDto updateParam) {
        emotionRepository.update(diaryId, updateParam);
    }

    // 감정을 삭제하는 메서드
    public void delete(Integer diaryId) {
        emotionRepository.delete(diaryId);
    }

    // 일기 ID로 감정을 조회하는 메서드
    public Optional<Emotion> findByDiaryId(Integer diaryId) {
        return emotionRepository.findByDiaryId(diaryId);
    }

    // 회원의 월별 감정 통계를 조회하는 메서드
    public LinkedHashMap<String, Object> getMonthlyEmotionStatistics(String memberId, String month) {
        return emotionRepository.getMonthlyEmotionStatistics(memberId, month);
    }

    // 회원의 특정 월의 상위 3개의 감정을 조회하는 메서드
    public List<LinkedHashMap<String, Object>> getTopEmotionsByMonth(String memberId, String month) {
        return emotionRepository.getTopEmotionsByMonth(memberId, month);
    }

    // 회원의 특정 월의 시간별 감정을 조회하는 메서드
    public List<LinkedHashMap<String, Object>> getHourlyEmotionByMonth(String memberId, String month) {
        return emotionRepository.getHourlyEmotionByMonth(memberId, month);
    }

}

