package RoutePlanner.core.Service;

import RoutePlanner.core.domain.survey.Survey;
import RoutePlanner.core.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class SurveyService {
    private final SurveyRepository surveyRepository;

    @Transactional
    public Survey create(Long id, String userID, String userWhere, String userWhat, String userWho) {
        Survey survey = new Survey();
        survey.setId(id);
        survey.setUserID(userID);
        survey.setUserWhere(userWhere);
        survey.setUserWHAT(userWhat);
        survey.setUserWho(userWho);

        this.surveyRepository.save(survey);
        return survey;
    }

    @Transactional
    public void delete(String userID) {
        Survey survey = surveyRepository.findByUserID(userID).orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다 " + userID));

        surveyRepository.delete(survey);
    }
}
