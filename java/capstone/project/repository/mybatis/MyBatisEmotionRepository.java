package capstone.project.repository.mybatis;

import capstone.project.domain.Emotion;
import capstone.project.repository.emotion.EmotionRepository;
import capstone.project.repository.emotion.EmotionUpdateApiDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisEmotionRepository implements EmotionRepository {

    private final EmotionMapper emotionMapper;

    @Override
    public Emotion save(Emotion emotion) {
        emotionMapper.preSave(emotion);
        emotionMapper.save(emotion);
        return emotionMapper.findNewEmotion();
    }

    @Override
    public void update(Integer diaryId, EmotionUpdateApiDto updateParam) {
        emotionMapper.update(diaryId, updateParam);
    }

    @Override
    public void delete(Integer diaryId) {
        emotionMapper.delete(diaryId);
    }

    @Override
    public Optional<Emotion> findByDiaryId(Integer diaryId) {
        return emotionMapper.findByDiaryId(diaryId);
    }

    @Override
    public LinkedHashMap<String, Object> getMonthlyEmotionStatistics(String memberId, String month) {
        return emotionMapper.getMonthlyEmotionStatistics(memberId, month);
    }

    @Override
    public List<LinkedHashMap<String, Object>> getTopEmotionsByMonth(String memberId, String month) {
        return emotionMapper.getTopEmotionsByMonth(memberId, month);
    }

    @Override
    public List<LinkedHashMap<String, Object>> getHourlyEmotionByMonth(String memberId, String month) {
        return emotionMapper.getHourlyEmotionByMonth(memberId, month);
    }
}
