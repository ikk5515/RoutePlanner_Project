package RoutePlanner.core.repository;

import RoutePlanner.core.domain.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    boolean existsByUserID(String userID);
}
