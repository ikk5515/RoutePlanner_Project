package RoutePlanner.core.Service;


import RoutePlanner.core.domain.survey.Survey;
import RoutePlanner.core.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;


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
}
